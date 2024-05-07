package com.spring.graphql.mysql.GraphQl.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.graphql.mysql.GraphQl.entity.Master;
import com.spring.graphql.mysql.GraphQl.entity.Client;
import com.spring.graphql.mysql.GraphQl.repository.MasterRepository;
import com.spring.graphql.mysql.GraphQl.repository.ClientRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private MasterRepository masterRepository;
    private ClientRepository clientRepository;

    @Autowired
    public Mutation(MasterRepository masterRepository, ClientRepository clientRepository) {
        this.masterRepository = masterRepository;
        this.clientRepository = clientRepository;
    }
    public Master createMaster(String name, String surname, Boolean excluded) {
        Master master = new Master();
        master.setName(name);
        master.setSurname(surname);
        master.setExcluded(excluded);

        masterRepository.save(master);
        return master;
    }

    public boolean deleteMaster(Long id_master) {
        Master master = masterRepository.findById(id_master)
                .orElseThrow(() -> new IllegalArgumentException("Master not found with id: " + id_master));
        master.setExcluded(true);

        masterRepository.save(master);
        return true;
    }

    public Master updateMaster(Long id_master, String name, String surname, Boolean excluded) throws EntityNotFoundException {
        Optional<Master> optMaster = masterRepository.findById(id_master);
        if (optMaster.isPresent()) {
            Master master = optMaster.get();
            if (name != null)
                master.setName(name);
            if (surname != null)
                master.setSurname(surname);
            if (excluded != null)
                master.setExcluded(excluded);

            masterRepository.save(master);
            return master;
        }
        throw new EntityNotFoundException("Not found Master to update!");
    }

    public Client createClient(String name, String surname, Boolean excluded, Long masterId) {
        Client client = new Client();
        client.setMaster(new Master(masterId));
        client.setName(name);
        client.setSurname(surname);
        client.setExcluded(excluded);

        clientRepository.save(client);
        return client;
    }

    public boolean deleteClient(Long id_client) {
        Client client = clientRepository.findById(id_client)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id_client));
        client.setExcluded(true);

        clientRepository.save(client);
        return true;
    }

    public Client updateClient(Long id_client, String name, String surname, Boolean excluded, Long masterId) throws EntityNotFoundException {
        Optional<Client> optClient = clientRepository.findById(id_client);
        if (optClient.isPresent()) {
            Client client = optClient.get();
            if (name != null)
                client.setName(name);
            if (surname != null)
                client.setSurname(surname);
            if (excluded != null)
                client.setExcluded(excluded);
            if (masterId != null)
                client.setMaster(new Master(masterId));

            clientRepository.save(client);
            return client;
        }

        throw new EntityNotFoundException("Not found Client to update!");
    }

}

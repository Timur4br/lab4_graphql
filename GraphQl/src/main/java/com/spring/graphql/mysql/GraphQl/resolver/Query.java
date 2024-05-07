package com.spring.graphql.mysql.GraphQl.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.graphql.mysql.GraphQl.entity.Master;
import com.spring.graphql.mysql.GraphQl.entity.Client;
import com.spring.graphql.mysql.GraphQl.repository.MasterRepository;
import com.spring.graphql.mysql.GraphQl.repository.ClientRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver
{
    private MasterRepository masterRepository;
    private ClientRepository clientRepository;

    @Autowired
    public Query(MasterRepository masterRepository, ClientRepository clientRepository) {
        this.masterRepository = masterRepository;
        this.clientRepository = clientRepository;
    }

    public Iterable<Master> findAllMasters() {
        return masterRepository.findAll();
    }

    public Iterable<Client> findAllClients() {
        return clientRepository.findAll();
    }
}

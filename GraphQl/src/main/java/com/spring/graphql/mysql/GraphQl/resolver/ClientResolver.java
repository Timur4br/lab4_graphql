package com.spring.graphql.mysql.GraphQl.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.graphql.mysql.GraphQl.entity.Master;
import com.spring.graphql.mysql.GraphQl.entity.Client;
import com.spring.graphql.mysql.GraphQl.repository.MasterRepository;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class ClientResolver implements GraphQLResolver<Client>
{
    @Autowired
    private MasterRepository masterRepository;

    public ClientResolver(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public Master getMaster(Client client) {
        return masterRepository.findById(client.getMaster().getId_master()).orElseThrow(null);
    }
}

package com.spring.graphql.mysql.GraphQl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.graphql.mysql.GraphQl.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>
{
}

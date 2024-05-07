package com.spring.graphql.mysql.GraphQl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.graphql.mysql.GraphQl.entity.Master;

public interface MasterRepository extends JpaRepository<Master, Long>
{
}

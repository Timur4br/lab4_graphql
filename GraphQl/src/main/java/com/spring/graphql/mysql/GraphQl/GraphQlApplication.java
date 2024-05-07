package com.spring.graphql.mysql.GraphQl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(GraphQlApplication.class, args);
	}
	@Bean
	public graphql.schema.GraphQLScalarType extendedScalarLong() {
		return graphql.scalars.ExtendedScalars.GraphQLLong;
	}
}

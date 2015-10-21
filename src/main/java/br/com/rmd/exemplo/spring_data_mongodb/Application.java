package br.com.rmd.exemplo.spring_data_mongodb;

import br.com.rmd.exemplo.spring_data_mongodb.pojo.Customer;
import br.com.rmd.exemplo.spring_data_mongodb.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepo repo;

    public static void main(String[] args) {
        SpringApplication.run( Application.class, args );
    }

    @Override
    public void run(String... args) throws Exception {

        repo.deleteAll();

        // save a couple of customers
        repo.save( new Customer( "Alice", "Smith" ) );
        repo.save( new Customer( "Bob", "Smith" ) );


        System.out.println( new Date() );

        for ( int i = 0; i < 1000000; i++ ) {
            repo.save( new Customer( "Renato" + i, "Macegossa" ) );
        }

        System.out.println( new Date() );


        // fetch all customers
        System.out.println( "Customers found with findAll():" );
        System.out.println( "-------------------------------" );
        repo.findAll().forEach( System.out::println );
        System.out.println();

        // fetch an individual customer
        System.out.println( "Customer found with findByFirstName('Alice'):" );
        System.out.println( "--------------------------------" );
        System.out.println( repo.findByFirstName( "Alice" ) );

        System.out.println( "Customers found with findByLastName('Smith'):" );
        System.out.println( "--------------------------------" );
        repo.findByLastName( "Smith" ).forEach( System.out::println );
    }
}

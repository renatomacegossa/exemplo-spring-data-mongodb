package br.com.rmd.exemplo.spring_data_mongodb.repo;

import br.com.rmd.exemplo.spring_data_mongodb.pojo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepo extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

}

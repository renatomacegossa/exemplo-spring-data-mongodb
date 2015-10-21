package br.com.rmd.exemplo.spring_data_mongodb.pojo;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer idade = 20;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format( "Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName );
    }
}

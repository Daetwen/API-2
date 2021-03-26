package com.vlad.test.testProject;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Integer idPerson) {
        super(String.format("Person is not found with id : '%s'", idPerson));
    }
}

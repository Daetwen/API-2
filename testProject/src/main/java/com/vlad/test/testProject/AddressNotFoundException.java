package com.vlad.test.testProject;

public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(Integer Persons_idPerson) {
        super(String.format("Person is not found with id : '%s'", Persons_idPerson));
    }
}

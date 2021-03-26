package com.vlad.test.testProject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_address")
    private Integer id_address;
    private String region;
    private String city;
    private String street;
    private String house;
    private Integer flat;
    @JoinColumn(name = "persons_id_persons")
    @NotNull
    private Integer persons_id_persons;

    public Address(){
        super();
    }

    public Address(Integer idAddress, String Region, String City,
                   String Street, String House, Integer Flat, Integer Persons_idPersons){
        this.id_address = idAddress;
        this.region = Region;
        this.city = City;
        this.street = Street;
        this.house = House;
        this.flat = Flat;
        this.persons_id_persons = Persons_idPersons;
    }

    public void copy(Address address){
        this.setRegion(address.getRegion());
        this.setCity(address.getCity());
        this.setStreet(address.getStreet());
        this.setHouse(address.getHouse());
        this.setFlat(address.getFlat());
        this.setPersons_id_persons(address.getPersons_id_persons());
    }

    public Integer getId_address(){
        return this.id_address;
    }
    public void setId(Integer id){
        this.id_address = id_address;
    }

    public String getRegion(){
        return this.region;
    }
    public void setRegion(String Region){
        this.region = Region;
    }

    public String getCity(){
        return this.city;
    }
    public void setCity(String City){
        this.city = City;
    }

    public String getStreet(){
        return this.street;
    }
    public void setStreet(String Street){
        this.street = Street;
    }

    public String getHouse(){
        return this.house;
    }
    public void setHouse(String House){
        this.house = House;
    }

    public Integer getFlat(){
        return this.flat;
    }
    public void setFlat(Integer Flat){
        this.flat = Flat;
    }

    public Integer getPersons_id_persons(){
        return this.persons_id_persons;
    }
    public void setPersons_id_persons(Integer Persons_IdPersons){
        this.persons_id_persons = Persons_IdPersons;
    }
}

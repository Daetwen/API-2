package com.vlad.test.testProject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "persons")
@ApiModel(description = "Details about Person")
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "idPersons")
    @ApiModelProperty(notes = "id of person")
    private Integer idPersons;
    @ApiModelProperty(notes = "name of person")
    private String name;
    @ApiModelProperty(notes = "second name of person")
    private String soname;
    @ApiModelProperty(notes = "gender of person")
    private String gender;
    @ApiModelProperty(notes = "age of person")
    private Integer age;
    @OneToMany(targetEntity=Address.class)
    @JoinColumn(name = "persons_id_persons")
    private List address;

    public Person(){
        super();
    }

    public Person(Integer idPersons, String name, String soname, String gender, Integer age){
        this.idPersons = idPersons;
        this.name = name;
        this.soname = soname;
        this.gender = gender;
        this.age = age;
    }

    public Person(String name, String soname, String gender, Integer age){
        this.name = name;
        this.soname = soname;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId(){
        return this.idPersons;
    }
    public void setIdPersons(Integer idPersons){
        this.idPersons = idPersons;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSoname(){
        return this.soname;
    }
    public void setSoname(String soname){
        this.soname = soname;
    }

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    public List getAddress() {
        return this.address;
    }
    public void setAddress(List address) {
        this.address = address;
    }

    public void copyPersonDTO(PersonDTO personDTO) {
        this.idPersons = personDTO.getId();
        this.name = personDTO.getName();
        this.soname = personDTO.getSoname();
        this.gender = personDTO.getGender();
        this.age = personDTO.getAge();
    }
}

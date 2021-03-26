package com.vlad.test.testProject;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class PersonDTO {
    private Integer idPersons;
    private String name;
    private String soname;
    private String gender;
    private Integer age;

    public PersonDTO(){
        super();
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
}

package com.vlad.test.testProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Integer> {
    List<Person> findBySoname(String soname);
    List<Person> findByIdPersonsAndSoname(Integer idPersons, String soname);
}

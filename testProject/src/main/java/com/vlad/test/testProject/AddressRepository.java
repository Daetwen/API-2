package com.vlad.test.testProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCity(String city);
//    List<Address> findByIdPersons(Integer persons_id_persons);
//    void deleteAddressesByPersons_id_persons(List<Address> addresses);
}

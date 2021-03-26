package com.vlad.test.testProject;

import com.vlad.test.testProject.Person;
import com.vlad.test.testProject.PersonsRepository;
import com.vlad.test.testProject.PersonNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonsController {

    @Autowired
    PersonsRepository personsRepository;
    @Autowired
    AddressRepository addressRepository;

    // Получить все записи
    @GetMapping("/persons2")
    @ApiOperation(value = "Get all persons",
                  notes = "Return list of all persons")
    public List<Person> getAllNotes() {
        return personsRepository.findAll();
    }

    // Создать запись
    @PostMapping("/persons2")
    @ApiOperation(value = "Create person")
    public Person createNote(@Valid @RequestBody PersonDTO personDTO) {
        Person person = new Person();
        person.copyPersonDTO(personDTO);
        return personsRepository.save(person);
    }

    // Получить запись по id
    @GetMapping("/persons2/person")
    @ApiOperation(value = "Get person for id or soname",
            notes = "Return list of all persons with this parametr")
    public List<Person> getNoteById(@RequestParam(value = "id", required = false) Integer idPerson,
                              @RequestParam(value = "soname", required = false) String soname)
            throws PersonNotFoundException {
        List<Person> persons = new ArrayList<Person>();
        if (idPerson == null && soname == null){
            throw new PersonNotFoundException(idPerson);
        }
        else if (idPerson == null && soname != null) {
            persons = personsRepository.findBySoname(soname);
        }
        else if (idPerson != null && soname == null) {
            Optional<Person> personOptional = personsRepository.findById(idPerson);
            if(personOptional.isPresent()){
                persons.add(personOptional.get());
            }
        }
        else {
            persons = personsRepository.findByIdPersonsAndSoname(idPerson, soname);
        }
        return persons;
    }

//    // Получить запись по soname
//    @GetMapping("/persons2")
//    public List getNoteBySoname(@RequestParam(value = "soname") String soname) {
//        return personsRepository.findBySoname(soname);
//    }

//    // Обновить имя
//    @PutMapping("/persons2/{id}")
//    public Persons updateName(@PathVariable(value = "idPersons") Integer idPersons,
//                              @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
//
//        Persons persons = personsRepository.findById(idPersons)
//                .orElseThrow(() -> new PersonNotFoundException(idPersons));
//
//        persons.setName(personForUpdate.getName());
//
//        Persons updatedPerson = personsRepository.save(persons);
//        return updatedPerson;
//    }
//
//    // Обновить фамилию
//    @PutMapping("/persons2/{id}")
//    public Persons updateSoname(@PathVariable(value = "idPersons") Integer idPersons,
//                              @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
//
//        Persons persons = personsRepository.findById(idPersons)
//                .orElseThrow(() -> new PersonNotFoundException(idPersons));
//
//        persons.setSoname(personForUpdate.getSoname());
//
//        Persons updatedPerson = personsRepository.save(persons);
//        return updatedPerson;
//    }
//
//    // Обновить возраст
//    @PutMapping("/persons2/{id}")
//    public Persons updateAge(@PathVariable(value = "idPersons") Integer idPersons,
//                                @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
//
//        Persons persons = personsRepository.findById(idPersons)
//                .orElseThrow(() -> new PersonNotFoundException(idPersons));
//
//        persons.setAge(personForUpdate.getAge());
//
//        Persons updatedPerson = personsRepository.save(persons);
//        return updatedPerson;
//    }

    // Обновить запись
    @PutMapping("/persons2/")
    @ApiOperation(value = "Update person",
            notes = "Update some person for any parametr")
    public Person updateNote(@RequestParam(value = "id", required = false) Integer idPersons,
                           @Valid @RequestBody PersonDTO personForUpdate) throws PersonNotFoundException {

        Person persons = personsRepository.findById(idPersons)
                .orElseThrow(() -> new PersonNotFoundException(idPersons));

        persons.setName(personForUpdate.getName());
        persons.setSoname(personForUpdate.getSoname());
        persons.setGender(personForUpdate.getGender());
        persons.setAge(personForUpdate.getAge());

        Person updatedPerson = personsRepository.save(persons);
        return updatedPerson;
    }

    // Удалить запись по id
    @DeleteMapping("/persons2/")
    @ApiOperation(value = "Delete person",
            notes = "Delete person for id")
    public ResponseEntity deletePerson(@RequestParam(value = "id", required = false) Integer idPerson) throws PersonNotFoundException {
        Person person = personsRepository.findById(idPerson)
                .orElseThrow(() -> new PersonNotFoundException(idPerson));

        personsRepository.delete(person);
        return ResponseEntity.ok().build();
    }

    //Получить список всех адресов человека
    @GetMapping("/persons2/addresses")
    @ApiOperation(value = "Get all addresses of person")
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Получить адрис по параметру
    @GetMapping("/persons2/addrrsses/address")
    @ApiOperation(value = "Get address for id or City",
            notes = "Return list of all addresses with this parametr")
    public List<Address> getAddressById(@RequestParam(value = "id_address", required = false) Integer id_address,
                                    @RequestParam(value = "city", required = false) String city)
            throws AddressNotFoundException {
        List<Address> addresses = new ArrayList<Address>();
        if (id_address == null && city == null){
            throw new AddressNotFoundException(id_address);
        }
        else if (id_address == null && city != null) {
            addresses = addressRepository.findByCity(city);
        }
        else if (id_address != null && city == null) {
            Optional<Address> addressOptional = addressRepository.findById(id_address);
            if(addressOptional.isPresent()){
                addresses.add(addressOptional.get());
            }
        }
        return addresses;
    }

    //Добавить адрес
    @PostMapping("/persons2/addresses")
    @ApiOperation(value = "Create address")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

    // Обновить запись
    @PutMapping("/persons2/addresses")
    @ApiOperation(value = "Update address",
            notes = "Update some address for any parametr")
    public Address updateAddress(@RequestParam(value = "id", required = false) Integer Persons_idPersons,
                             @Valid @RequestBody Address addressForUpdate) throws AddressNotFoundException {

        Address address = addressRepository.findById(Persons_idPersons)
                .orElseThrow(() -> new AddressNotFoundException(Persons_idPersons));

        address.setRegion(addressForUpdate.getRegion());
        address.setCity(addressForUpdate.getCity());
        address.setStreet(addressForUpdate.getStreet());
        address.setHouse(addressForUpdate.getHouse());
        address.setFlat(addressForUpdate.getFlat());
        address.setPersons_id_persons(addressForUpdate.getPersons_id_persons());

        Address updatedAddress = addressRepository.save(address);
        return updatedAddress;
    }

    // Удалить адрес по id
    @DeleteMapping("/persons2/addresses")
    @ApiOperation(value = "Delete address",
            notes = "Delete address for id")
    public ResponseEntity deleteAddress(@RequestParam(value = "id", required = false) Integer id_address) throws AddressNotFoundException {
        Address address = addressRepository.findById(id_address)
                .orElseThrow(() -> new AddressNotFoundException(id_address));

        addressRepository.delete(address);
        return ResponseEntity.ok().build();
    }

//    // Удалить адрес по persons_id_persons
//    @DeleteMapping("/persons2/addresses")
//    @ApiOperation(value = "Delete address",
//            notes = "Delete address for id")
//    public ResponseEntity deleteAddressForIdPerson(@RequestParam(value = "persons_id_persons", required = false) Integer persons_id_persons) throws AddressNotFoundException {
//        List<Address> address = addressRepository.findByIdPersons(persons_id_persons);
//
//        addressRepository.deleteAddressesByPersons_id_persons(address);
//        return ResponseEntity.ok().build();
//    }
}

//package com.vlad.test.testProject;
//
//import com.vlad.test.testProject.Person;
//import com.vlad.test.testProject.PersonsRepository;
//import com.vlad.test.testProject.PersonNotFoundException;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class PersonsAndAddressController {
//
//    @Autowired
//    PersonsRepository personsRepository;
//
//    @Autowired
//    AddressRepository addressRepository;
//
//    // Получить все записи
//    @GetMapping("/persons")
//    @ApiOperation(value = "Get all persons",
//            notes = "Return list of all persons")
//    public List getAllNotes() {
//        return personsRepository.findAll();
//    }
//
//    // Создать запись
//    @PostMapping("/persons")
//    @ApiOperation(value = "Create person")
//    public Person createNote(@Valid @RequestBody Person person) {
//        return personsRepository.save(person);
//    }
//
//    // Получить запись по id
//    @GetMapping("/persons/person")
//    @ApiOperation(value = "Get person for id or soname",
//            notes = "Return list of all persons with this parametr")
//    public List getNoteById(@RequestParam(value = "id", required = false) Integer idPerson,
//                            @RequestParam(value = "soname", required = false) String soname)
//            throws PersonNotFoundException {
//        List<Person> persons = new ArrayList<Person>();
//        if (idPerson == null && soname == null){
//            throw new PersonNotFoundException(idPerson);
//        }
//        else if (idPerson == null && soname != null) {
//            persons = personsRepository.findBySoname(soname);
//        }
//        else if (idPerson != null && soname == null) {
//            Optional<Person> personOptional = personsRepository.findById(idPerson);
//            if(personOptional.isPresent()){
//                persons.add(personOptional.get());
//            }
//        }
//        else {
//            persons = personsRepository.findByIdPersonsAndSoname(idPerson, soname);
//        }
//        return persons;
//    }
//
////    // Получить запись по soname
////    @GetMapping("/persons2")
////    public List getNoteBySoname(@RequestParam(value = "soname") String soname) {
////        return personsRepository.findBySoname(soname);
////    }
//
////    // Обновить имя
////    @PutMapping("/persons2/{id}")
////    public Persons updateName(@PathVariable(value = "idPersons") Integer idPersons,
////                              @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
////
////        Persons persons = personsRepository.findById(idPersons)
////                .orElseThrow(() -> new PersonNotFoundException(idPersons));
////
////        persons.setName(personForUpdate.getName());
////
////        Persons updatedPerson = personsRepository.save(persons);
////        return updatedPerson;
////    }
////
////    // Обновить фамилию
////    @PutMapping("/persons2/{id}")
////    public Persons updateSoname(@PathVariable(value = "idPersons") Integer idPersons,
////                              @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
////
////        Persons persons = personsRepository.findById(idPersons)
////                .orElseThrow(() -> new PersonNotFoundException(idPersons));
////
////        persons.setSoname(personForUpdate.getSoname());
////
////        Persons updatedPerson = personsRepository.save(persons);
////        return updatedPerson;
////    }
////
////    // Обновить возраст
////    @PutMapping("/persons2/{id}")
////    public Persons updateAge(@PathVariable(value = "idPersons") Integer idPersons,
////                                @Valid @RequestBody Persons personForUpdate) throws PersonNotFoundException {
////
////        Persons persons = personsRepository.findById(idPersons)
////                .orElseThrow(() -> new PersonNotFoundException(idPersons));
////
////        persons.setAge(personForUpdate.getAge());
////
////        Persons updatedPerson = personsRepository.save(persons);
////        return updatedPerson;
////    }
//
//    // Обновить запись
//    @PutMapping("/persons/")
//    @ApiOperation(value = "Update person",
//            notes = "Update some person for any parametr")
//    public Person updateNote(@RequestParam(value = "id", required = false) Integer idPersons,
//                             @Valid @RequestBody Person personForUpdate) throws PersonNotFoundException {
//
//        Person persons = personsRepository.findById(idPersons)
//                .orElseThrow(() -> new PersonNotFoundException(idPersons));
//
//        persons.setName(personForUpdate.getName());
//        persons.setSoname(personForUpdate.getSoname());
//        persons.setGender(personForUpdate.getGender());
//        persons.setAge(personForUpdate.getAge());
//
//        Person updatedPerson = personsRepository.save(persons);
//        return updatedPerson;
//    }
//
//    // Удалить запись по id
//    @DeleteMapping("/persons/")
//    @ApiOperation(value = "Delete person",
//            notes = "Delete person for id")
//    public ResponseEntity deletePerson(@RequestParam(value = "id", required = false) Integer idPerson) throws PersonNotFoundException {
//        Person person = personsRepository.findById(idPerson)
//                .orElseThrow(() -> new PersonNotFoundException(idPerson));
//
//        personsRepository.delete(person);
//        return ResponseEntity.ok().build();
//    }
//}
//

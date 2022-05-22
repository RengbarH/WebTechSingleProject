package de.htwberlin.webtech.web.service;


import de.htwberlin.webtech.web.api.Person;
import de.htwberlin.webtech.web.api.PersonManipulationRequest;
import de.htwberlin.webtech.web.persistance.Gender;
import de.htwberlin.webtech.web.persistance.PersonEntity;
import de.htwberlin.webtech.web.persistance.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person findById(Long id) {
        var personEntity = personRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Person create(PersonManipulationRequest request) {
        String uuiIdentifier = UUID.randomUUID().toString();
        var gender = Gender.valueOf(request.getGender());
        var personEntity = new PersonEntity(request.getFirstName(), request.getLastName(), gender, uuiIdentifier);
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);
    }

    public Person update(Long id, PersonManipulationRequest request) {
        var personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return null;
        }
        var personEntity = personEntityOptional.get();
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName((request.getLastName()));
        personEntity.setGender(Gender.valueOf(request.getGender()));
        personEntity.setIdentifier(request.getIdentifier());
        personEntity = personRepository.save(personEntity);

        return transformEntity(personEntity);
    }

    public boolean deleteById(Long id) {
        if (!personRepository.existsById(id)) {
            return false;
        }
        personRepository.deleteById(id);
        return true;
    }

    private Person transformEntity(PersonEntity personEntity) {
        var gender = personEntity.getGender() != null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                gender,
                personEntity.getIdentifier()
        );
    }
}

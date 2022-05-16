package de.htwberlin.webtech.web.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    public List<PersonEntity> findAllByFirstName(String firstName);

}

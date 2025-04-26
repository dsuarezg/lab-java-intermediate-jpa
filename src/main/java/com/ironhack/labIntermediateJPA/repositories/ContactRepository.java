package com.ironhack.labIntermediateJPA.repositories;

import com.ironhack.labIntermediateJPA.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

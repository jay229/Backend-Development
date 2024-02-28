package com.scm.SmartContactManager.repositories;

import com.scm.SmartContactManager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}

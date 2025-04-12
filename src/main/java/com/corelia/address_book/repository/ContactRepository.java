package com.corelia.address_book.repository;

import com.corelia.address_book.model.Contact;
import com.corelia.address_book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByUserEmail(String email);
    Optional<Contact> findByIdAndUserEmail(Long id, String email);


}

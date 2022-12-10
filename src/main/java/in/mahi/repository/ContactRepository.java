package in.mahi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahi.entitie.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{

	
}

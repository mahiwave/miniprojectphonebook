package in.mahi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mahi.entitiebinding.ContactForm;
import in.mahi.service.ContactService;

@RestController
@CrossOrigin
public class ContactController {

	@Autowired
	ContactService service;
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody ContactForm form) {
		String status = service.saveContact(form);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> listContacts() {
		List<ContactForm> list = service.getContactList();
		return list;
	}
	
	@PutMapping("/contact")
	public ContactForm editContact(@RequestBody ContactForm contactid) {
		ContactForm contactForm = service.editContact(contactid);
		return contactForm;
	}
	
	@DeleteMapping("/contact/{id}")
	public List<ContactForm> deleteContact(@PathVariable Integer id) {
		List<ContactForm> contactFormList = service.deleteContact(id);
		return contactFormList;
	}
	
	//GET => http://localhost:8080/contact/101
		@GetMapping("/contact/{contactId}")
	public ContactForm getContactById(@PathVariable Integer contactId) {
			ContactForm contact = service.getContactById(contactId);
			return contact;
	}
}

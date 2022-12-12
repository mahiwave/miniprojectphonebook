package in.mahi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mahi.entitiebinding.ContactForm;
import in.mahi.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService service;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		String status = service.saveContact(form);
		return status;
	}
	
	@PostMapping("/get")
	public List<ContactForm> listContacts() {
		List<ContactForm> list = service.getContactList();
		return list;
	}
	
	@GetMapping("/edit/{id}")
	public ContactForm editContact(@RequestBody Integer id) {
		ContactForm contactForm = service.editContact(id);
		return contactForm;
	}
	
	@DeleteMapping("/delete/{id}")
	public List<ContactForm> deleteContact(@PathVariable Integer id) {
		List<ContactForm> contactFormList = service.deleteContact(id);
		return contactFormList;
	}
}

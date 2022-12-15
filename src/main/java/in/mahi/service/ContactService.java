package in.mahi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.mahi.entitiebinding.ContactForm;

@Service
public interface ContactService {

	public String saveContact(ContactForm cForm);
	
	public List<ContactForm> getContactList();
	
	public ContactForm editContact(ContactForm contactId);
	
	public List<ContactForm> deleteContact(Integer conId);
	
	public ContactForm getContactById(Integer contactId);
}

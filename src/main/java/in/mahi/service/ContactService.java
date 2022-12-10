package in.mahi.service;

import java.util.List;

import in.mahi.entitiebinding.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm cForm);
	
	public List<ContactForm> getContactList();
	
	public ContactForm editContact(Integer conid);
	
	public List<ContactForm> deleteContact(Integer conId);
}

package in.mahi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mahi.entitie.Contact;
import in.mahi.entitiebinding.ContactForm;
import in.mahi.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public String saveContact(ContactForm cForm) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(cForm, contact);
		contact = contactRepository.save(contact);
		
		if(contact.getContactId() !=null) {
			return "Sucess";
		}
		return "Failed";
	}

	@Override
	public List<ContactForm> getContactList() {
		List<ContactForm> findAll = new ArrayList<>();
		List<Contact> contactLists = contactRepository.findAll();
		for (Contact e : contactLists) {
			ContactForm cf = new ContactForm();
			BeanUtils.copyProperties(e,cf);
			findAll.add(cf);
		}
		return findAll;
	}

	@Override
	public ContactForm editContact(ContactForm contactForm) {
		Optional<Contact> findById = contactRepository.findById(contactForm.getContactId());
		if(findById.isPresent()) {
			Contact contact = new Contact();
			ContactForm cForm = new ContactForm();
			BeanUtils.copyProperties(contact , cForm);
			return cForm;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer conId) {
		contactRepository.deleteById(conId);
		//getList and show the list
		List<ContactForm> contactList = getContactList();
		return contactList;
	}
	
	@Override
	public ContactForm getContactById(Integer contactId) {

		Optional<Contact> contactData = contactRepository.findById(contactId);
		ContactForm cForm = new ContactForm();
		if (contactData.isPresent()) {
			Contact contact = new Contact();
			contact = contactData.get();
			BeanUtils.copyProperties(contact , cForm);
			return cForm;
		}
		return null;
	}

}

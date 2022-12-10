package in.mahi.entitiebinding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class ContactForm {

	private Integer id;
	private String name;
	private String email;
	private Long phoneNumber;
	private Boolean isActive;
	private LocalDate createdOn;
	private LocalDate updatedOn;

}

package in.mahi.entitie;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name = "IsActive")
	private Boolean isActive;
	
	@Column(name = "CREATED_ON")
	@CreationTimestamp
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_ON")
	private LocalDate updatedOn;

}

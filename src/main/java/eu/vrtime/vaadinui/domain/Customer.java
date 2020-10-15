package eu.vrtime.vaadinui.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String customerId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	public Customer(final String customerId, final String firstName, final String lastName) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (this.id == null || other.id == null)
			return false;
		return sameIdentityAs(other);
	}

	private boolean sameIdentityAs(Customer other) {
		return (other != null && other.getId().equals(this.getId()));
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerId=" + customerId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}

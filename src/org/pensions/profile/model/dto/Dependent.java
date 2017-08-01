package org.pensions.profile.model.dto;

import java.lang.reflect.GenericArrayType;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.bson.BsonBoolean;
import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonWriter;
import org.bson.conversions.Bson;
import org.pensions.profile.data.interfaces.MongoModal;

@Entity
@Table(name = "dependent", uniqueConstraints = {
		@UniqueConstraint(columnNames = "dependent_id"),
		@UniqueConstraint(columnNames = "account_number")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Dependent implements MongoModal {

	private long id;
	private String name;
	private String address;
	private boolean maritalStatus;
	private Boolean disabled;
	private String relation;
	private String accountNumber;
	private String nic;
	private Date dateOfBirth;
	private int branchId;
	
	public Dependent() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "dependent_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "name", length = 100, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "address", length = 100, nullable = true)
	public String getAddress() {
		return address;
	}

	@Column(name = "maritalStatus", nullable = false)
	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	@Column(name = "relation", length = 8, nullable = false)
	public String getRelation() {
		return relation;
	}

	@Column(name = "account_number", length = 25, nullable = true, unique = true)
	public String getAccountNumber() {
		return accountNumber;
	}

	@Column(name = "nic", length = 12, nullable = true)
	public String getNic() {
		return nic;
	}



	@Column(name = "dob", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	@Column(name = "is_disabled", nullable = true)
	public Boolean isDisabled() {
		return disabled;
	}
	
	

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * this method converts the dto into a bson
	 * @return a bson document
	 */
	@Override
	public Bson getDocument() {
		BsonDocument bsonDoc= new BsonDocument().append("id", new BsonInt64(getId()))
						  						.append("name", new BsonString(getName()))
											    .append("address", new BsonString(getAddress()))
											    .append("marital_status", new BsonBoolean(isMaritalStatus()))
											    .append("disabled", new BsonBoolean(isDisabled()))
											    .append("relation", new BsonString(getRelation()))
											    .append("account_num", new BsonString(getAccountNumber()))
											    .append("nic", new BsonString(getNic()))
											    .append("date_of_birth", new BsonString(String.valueOf((getDateOfBirth()))))
											    .append("branch_id", new BsonInt32(getBranchId()));
		return bsonDoc;
		
						  
	}
	
	
}

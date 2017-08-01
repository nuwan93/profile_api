package org.pensions.profile.model.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pensioner", uniqueConstraints = {
		@UniqueConstraint(columnNames = "pensioner_id"),
		@UniqueConstraint(columnNames = "nic"),
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Pensioner {

	private long id;
	private String name;
	private String prefName;
	private String salutation;
	private String address;
	private String nic;
	private String designation;
	private Date dateOfRetired;
	private Date dateOfDeceased;
	private boolean pensionable;
	private boolean permanant;
	private boolean idIssued;
	private String serviceDomain;
	private String wopNumber;
	private String pensionerType;
	private int dependentId;
	private int stateId;
	private int villageOfficeId;

	
	
	public Pensioner() {
		
	}

	@Id
	@Column(name = "pensioner_id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "name", length = 400, nullable = false)
	//@Pattern(regexp = "^[a-zA-Z]$", message = "invalid name")
	public String getName() {
		return name;
	}

	@Column(name = "salutation", length = 4, nullable = false)
	public String getSalutation() {
		return salutation;
	}

	@Column(name = "address", length = 150, nullable = false)
	public String getAddress() {
		return address;
	}

	@Column(name = "nic", length = 12, nullable = false, unique = true)
	//@Pattern(regexp = "^[0-9]{9}[vVxX]$", message = "Reg ex error")
	public String getNic() {
		return nic;
	}

	@Column(name = "designation", nullable = false, length = 60)
	//@Pattern(regexp = "^[a-zA-Z]$", message = "invalid designation")
	public String getDesignation() {
		return designation;
	}

	@Column(name = "retired_date", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateOfRetired() {
		return dateOfRetired;
	}

	@Column(name = "deceased_date", nullable = true)
	@Temporal(TemporalType.DATE)
	public Date getDateOfDeceased() {
		return dateOfDeceased;
	}

	@Column(name = "pensionable", nullable = false)
	public boolean isPensionable() {
		return pensionable;
	}

	@Column(name = "permanant", nullable = false)
	public boolean isPermanant() {
		return permanant;
	}

	@Column(name = "serviceDomain", nullable = false, length = 200)
	public String getServiceDomain() {
		return serviceDomain;
	}

	@Column(name = "wop_number", nullable = true, length = 50)
	//@Pattern(regexp = "^[a-zA-Z]$", message = "invalid W&OP number") // this regular ex should be re visited
	public String getWopNumber() {
		return wopNumber;
	}

	
	@Column(name = "type", length = 10)
	public String getPensionerType() {
		return pensionerType;
	}

	@Column(name = "is_id_issued", columnDefinition = "boolean default false", nullable = false)
	public boolean isIdIssued() {
		return idIssued;
	}

	@Column(name = "perfered_name", nullable = true, length = 100)
	public String getPrefName() {
		return prefName;
	}
	

	public int getDependentId() {
		return dependentId;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getVillageOfficeId() {
		return villageOfficeId;
	}

	public void setVillageOfficeId(int villageOfficeId) {
		this.villageOfficeId = villageOfficeId;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public void setIdIssued(boolean idIssued) {
		this.idIssued = idIssued;
	}

	public void setPensionerType(String pensionerType) {
		this.pensionerType = pensionerType;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setDateOfRetired(Date dateOfRetired) {
		this.dateOfRetired = dateOfRetired;
	}

	public void setDateOfDeceased(Date dateOfDeceased) {
		this.dateOfDeceased = dateOfDeceased;
	}

	public void setPensionable(boolean pensionable) {
		this.pensionable = pensionable;
	}

	public void setPermanant(boolean permanant) {
		this.permanant = permanant;
	}

	public void setServiceDomain(String serviceDomain) {
		this.serviceDomain = serviceDomain;
	}

	public void setWopNumber(String wOPNumber) {
		wopNumber = wOPNumber;
	}
	
}

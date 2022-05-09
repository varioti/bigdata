package project;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Employees {

	private Integer employeeID;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private LocalDate birthDate;
	private LocalDate hireDate;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String homePhone;
	private String extension;
	private byte[] photo;
	private String notes;
	private String photoPath;
	private Double salary;

	public Employees(Map<String,Object> map) {
		this.employeeID = (Integer) map.get("EmployeeID");
		this.lastName = (String) map.get("LastName");
		this.firstName = (String) map.get("FirstName");
		this.address = (String) map.get("Address");
		this.city = (String) map.get("City");
		this.region = (String) map.get("Region");
		this.postalCode = (String) map.get("PostalCode");
		this.country = (String) map.get("Country");
		this.title = (String) map.get("Title");
		this.titleOfCourtesy = (String) map.get("TitleOfCourtesy");
		this.birthDate = (LocalDate) map.get("BirthDate");
		this.hireDate = (LocalDate) map.get("HireDate");
		this.homePhone = (String) map.get("HomePhone");;
		this.extension = (String) map.get("Extension");
		this.photo = (byte[]) map.get("Photo");
		this.notes = (String) map.get("Notes");
		this.photoPath = (String) map.get("PhotoPath");
		this.salary = (Double) map.get("Salary");
	}
	
	@Override
	public String toString(){
		return "Employees [ " + "employeeID="+employeeID +", "+
					"lastName="+lastName +", "+
					"firstName="+firstName +", "+
					"title="+title +", "+
					"titleOfCourtesy="+titleOfCourtesy +", "+
					"birthDate="+birthDate +", "+
					"hireDate="+hireDate +", "+
					"address="+address +", "+
					"city="+city +", "+
					"region="+region +", "+
					"postalCode="+postalCode +", "+
					"country="+country +", "+
					"homePhone="+homePhone +", "+
					"extension="+extension +", "+
					"photo="+photo +", "+
					"notes="+notes +", "+
					"photoPath="+photoPath +", "+
					"salary="+salary +"]"; 
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getTitle() {
		return title;
	}

	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getExtension() {
		return extension;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public String getNotes() {
		return notes;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public Double getSalary() {
		return salary;
	}
}
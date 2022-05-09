package project;

import java.util.Map;

public class Suppliers {

		private Integer supplierId;
		private String companyName;
		private String contactName;
		private String contactTitle;
		private String address;
		private String city;
		private String region;
		private String postalCode;
		private String country;
		private String phone;
		private String fax;
		private String homePage;
		
		Suppliers(Map<String,Object> map){
			this.supplierId = (Integer) map.get("SupllierID");
			this.companyName = (String) map.get("CompanyName");
			this.contactName = (String) map.get("ContactName");
			this.contactTitle = (String) map.get("ContactTitle");
			this.address = (String) map.get("Address");
			this.city = (String) map.get("City");
			this.region = (String) map.get("Region");
			this.postalCode = (String) map.get("PostalCode");
			this.country = (String) map.get("Country");
			this.phone = (String) map.get("Phone");
			this.fax = (String) map.get("Fax");
			this.homePage = (String) map.get("HomePage");
		}

		@Override
		public String toString() {
			return "Supplier [supplierId=" + supplierId + ", companyName=" + companyName + ", contactName="
					+ contactName + ", contactTitle=" + contactTitle + ", address=" + address + ", city=" + city
					+ ", region=" + region + ", postalCode=" + postalCode + ", country=" + country + ", phone=" + phone
					+ ", fax=" + fax + ", homePage=" + homePage + "]";
		}

		public Integer getSupplierId() {
			return supplierId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public String getContactName() {
			return contactName;
		}

		public String getContactTitle() {
			return contactTitle;
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

		public String getPhone() {
			return phone;
		}

		public String getFax() {
			return fax;
		}

		public String getHomePage() {
			return homePage;
		} 
}

package project;

public class Shipper {

	private Integer shipperID;
	private String companyName;
	private String phone;
	
	// Empty constructor
	public Shipper() {}
	
	//Constructor by id
		public Shipper(Integer shipperID) {
			this.shipperID = shipperID;
		}
	
	//Constructor
	public Shipper(Integer shipperID,String companyName,String phone) {
		this.shipperID = shipperID;
		this.companyName = companyName;
		this.phone = phone;
	}
	
	//Add Company Name
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	//Add Company Phone
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString(){
		return "SHIPPER: " + this.shipperID + "\n \t NAME: "+this.companyName+
				"\n \t PHONE: "+ this.phone;
		}

}

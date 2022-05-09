package project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Orders {

	private Integer id;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private Double freight;
	private String shipName;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostalCode;
	private String shipCountry;

	public Orders(Map<String,Object> map) {
		this.id = (Integer) map.get("ID");
		this.orderDate = (LocalDate) map.get("OrderDate");
		this.requiredDate = (LocalDate) map.get("RequiredDate");
		this.shippedDate = (LocalDate) map.get("ShippedDate");
		this.freight = (Double) map.get("Freight");
		this.shipName = (String) map.get("ShipName");
		this.shipAddress = (String) map.get("ShipAddress");
		this.shipCity = (String) map.get("ShipCity");
		this.shipRegion = (String) map.get("ShipRegion");
		this.shipPostalCode = (String) map.get("ShipPostalCode");
		this.shipCountry = (String) map.get("ShipCountry");
	}

	@Override
	public String toString(){
		return "Orders { " + "id="+id +", "+
					"orderDate="+orderDate +", "+
					"requiredDate="+requiredDate +", "+
					"shippedDate="+shippedDate +", "+
					"freight="+freight +", "+
					"shipName="+shipName +", "+
					"shipAddress="+shipAddress +", "+
					"shipCity="+shipCity +", "+
					"shipRegion="+shipRegion +", "+
					"shipPostalCode="+shipPostalCode +", "+
					"shipCountry="+shipCountry +"}"; 
	}



	public Integer getId() {
		return id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public Double getFreight() {
		return freight;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}
}

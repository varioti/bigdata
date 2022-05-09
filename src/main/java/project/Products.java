package project;

import java.util.Map;

public class Products {

	private Integer productId;
	private String productName;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Boolean discontinued;
	private Integer supplierRef;
	private Integer categoryRef;


	public Products(Map<String, Object> map) {
		this.productId = (Integer) map.get("ProductId");
		this.productName = (String) map.get("ProductName");
		this.quantityPerUnit = (String) map.get("QuantityPerUnit");
		this.unitPrice = (Double) map.get("UnitPrice");
		this.unitsInStock = (Integer) map.get("UnitsInStock");
		this.unitsOnOrder = (Integer) map.get("UnitsOnOrder");
		this.reorderLevel = (Integer) map.get("ReorderLevel");
		this.discontinued = (Boolean) map.get("Discontinued");
		this.supplierRef = (Integer) map.get("SupplierRef");
		this.categoryRef = (Integer) map.get("CategoryRef");
	}

	@Override
	public String toString(){
		return "Products { " + "productId="+productId +", "+
					"productName="+productName +", "+
					"quantityPerUnit="+quantityPerUnit +", "+
					"unitPrice="+unitPrice +", "+
					"unitsInStock="+unitsInStock +", "+
					"unitsOnOrder="+unitsOnOrder +", "+
					"reorderLevel="+reorderLevel +", "+
					"supplierRef="+supplierRef +", "+
					"categoryRef="+categoryRef +", "+
					"discontinued="+discontinued +"}"; 
	}

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public Integer getSupplierRef() {
		return supplierRef;
	}

	public Integer getCategoryRef() {
		return categoryRef;
	}
	
	
}
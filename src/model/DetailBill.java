/**
 * 
 */
package model;

/**
 * @author JONATAN FRANCO
 *
 */
public class DetailBill {
	//Declaracion de variables
	private int id;
	private int quantity;
	private float unitValue;
	private float totalValue;
	private Product product;
	private Bill bill;
	
	//Metodos constructores
	public DetailBill(int id, int quantity, float unitValue, float totalValue, Product product, Bill bill) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
		this.product = product;
		this.bill = bill;
	}
	
	public DetailBill() { }

	//Metodos get y set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(float unitValue) {
		this.unitValue = unitValue;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}

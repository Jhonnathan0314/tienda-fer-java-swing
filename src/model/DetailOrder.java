/**
 * 
 */
package model;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF5
 * @version V1 -> 20-04-2023
 */
public class DetailOrder {
	//Variables declaration
	private int id;
	private int orderedQuantity;
	private int receivedQuantity;
	private float unitValue;
	private float totalValue;
	private float saleValue;
	private float percentageProfit;
	private Product product;
	private Order order;
	
	//Construct method than receives a product attributes
	public DetailOrder(int id, int orderedQuantity, int receivedQuantity, float unitValue, float totalValue, float saleValue, float percentageProfit, Product product, Order order) {
		super();
		this.id = id;
		this.orderedQuantity = orderedQuantity;
		this.receivedQuantity = receivedQuantity;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
		this.saleValue = saleValue;
		this.percentageProfit = percentageProfit;
		this.product = product;
		this.order = order;
	}
	
	//Empty construct method
	public DetailOrder() { }

	//Get and set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public int getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(int receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
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

	public float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
	}

	public float getPercentageProfit() {
		return percentageProfit;
	}

	public void setPercentageProfit(float percentageProfit) {
		this.percentageProfit = percentageProfit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}

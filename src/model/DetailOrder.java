/**
 * 
 */
package model;

/**
 * @author JONATAN FRANCO
 *
 */
public class DetailOrder {
	//Declaracion de variables
	private int id;
	private int orderedQuantity;
	private int receivedQuantity;
	private float unitValue;
	private float totalValue;
	private float percentageProfit;
	private Product product;
	private Order order;
	
	//Metodos constructores
	public DetailOrder(int id, int orderedQuantity, int receivedQuantity, float unitValue, float totalValue,
			float percentageProfit, Product product, Order order) {
		super();
		this.id = id;
		this.orderedQuantity = orderedQuantity;
		this.receivedQuantity = receivedQuantity;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
		this.percentageProfit = percentageProfit;
		this.product = product;
		this.order = order;
	}
	
	public DetailOrder() { }

	//Metodos get y set
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

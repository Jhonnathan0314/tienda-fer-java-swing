/**
 * 
 */
package view;

import java.util.List;

import model.Bill;
import model.Order;
import model.Product;
import model.Section;
import model.Supplier;

/**
 * @author JONATAN FRANCO
 *
 */
public interface CustomEventAnswer {

	public void isValidResponse(boolean isValid, List<Product> products);
	
	public void goToHomeFromSection(List<Product> products);
	
	public void goToHomeFromProduct(List<Product> products);
	
	public void goToHomeFromSupplier(List<Product> products);
	
	public void goToHomeFromBill(List<Product> products);
	
	public void goToHomeFromOrder(List<Product> products);
	
	public void goToSectionFromHome(List<Section> sections);

	public void goToSectionFromProduct(List<Section> sections);

	public void goToSectionFromSupplier(List<Section> sections);

	public void goToSectionFromBill(List<Section> sections);

	public void goToSectionFromOrder(List<Section> sections);
	
	public void goToProductFromHome(List<Product> products);

	public void goToProductFromSection(List<Product> products);

	public void goToProductFromSupplier(List<Product> products);

	public void goToProductFromBill(List<Product> products);

	public void goToProductFromOrder(List<Product> products);
	
	public void goToSupplierFromHome(List<Supplier> suppliers);

	public void goToSupplierFromSection(List<Supplier> suppliers);

	public void goToSupplierFromProduct(List<Supplier> suppliers);

	public void goToSupplierFromBill(List<Supplier> suppliers);

	public void goToSupplierFromOrder(List<Supplier> suppliers);
	
	public void goToBillFromHome(List<Bill> bills);

	public void goToBillFromSection(List<Bill> bills);

	public void goToBillFromProduct(List<Bill> bills);

	public void goToBillFromSupplier(List<Bill> bills);

	public void goToBillFromOrder(List<Bill> bills);
	
	public void goToOrderFromHome(List<Order> orders);

	public void goToOrderFromSection(List<Order> orders);

	public void goToOrderFromProduct(List<Order> orders);

	public void goToOrderFromSupplier(List<Order> orders);

	public void goToOrderFromBill(List<Order> orders);
	
	public void goToCreateSection();

	public void goToCreateProduct(List<Section> sections);

	public void goToCreateSupplier();
	
	public void filteredSectionsResponse(List<Section> sections);

	public void filteredProductsByNameResponse(List<Product> products);

	public void filteredSuppliersBySupplierNameResponse(List<Supplier> suppliers);
	
	public void goToSectionFromCreateSection(List<Section> sections);

	public void goToProductFromCreateProduct(List<Product> products);

	public void goToSupplierFromCreateSupplier(List<Supplier> suppliers);
	
}

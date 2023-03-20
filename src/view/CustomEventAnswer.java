/**
 * 
 */
package view;

import java.util.List;

import model.Bill;
import model.DetailBill;
import model.DetailOrder;
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

	
	public void goToUpdateSection(Section section);

	public void goToUpdateProduct(Product product, List<Section> sections);

	public void goToUpdateSupplier(Supplier supplier);
	
	
	public void filteredSectionsResponse(List<Section> sections);

	public void filteredProductsByNameResponse(List<Product> products);

	public void filteredSuppliersBySupplierNameResponse(List<Supplier> suppliers);
	
	
	public void goToSectionFromCreateSection(List<Section> sections);
	
	public void goToProductFromCreateSection(List<Product> products);

	public void goToSupplierFromCreateSection(List<Supplier> suppliers);

	public void goToBillFromCreateSection(List<Bill> bills);

	public void goToOrderFromCreateSection(List<Order> orders);

	
	public void goToSectionFromUpdateSection(List<Section> sections);

	public void goToProductFromUpdateSection(List<Product> products);

	public void goToSupplierFromUpdateSection(List<Supplier> suppliers);

	public void goToBillFromUpdateSection(List<Bill> bills);

	public void goToOrderFromUpdateSection(List<Order> orders);
	
	
	public void goToSectionFromCreateProduct(List<Section> sections);
	
	public void goToProductFromCreateProduct(List<Product> products);

	public void goToSupplierFromCreateProduct(List<Supplier> suppliers);

	public void goToBillFromCreateProduct(List<Bill> bills);

	public void goToOrderFromCreateProduct(List<Order> orders);
	
	
	public void goToSectionFromUpdateProduct(List<Section> sections);

	public void goToProductFromUpdateProduct(List<Product> products);

	public void goToSupplierFromUpdateProduct(List<Supplier> suppliers);

	public void goToBillFromUpdateProduct(List<Bill> bills);

	public void goToOrderFromUpdateProduct(List<Order> orders);
	
	
	public void goToSectionFromCreateSupplier(List<Section> sections);
	
	public void goToProductFromCreateSupplier(List<Product> products);

	public void goToSupplierFromCreateSupplier(List<Supplier> suppliers);

	public void goToBillFromCreateSupplier(List<Bill> bills);

	public void goToOrderFromCreateSupplier(List<Order> orders);
	

	public void goToSectionFromUpdateSupplier(List<Section> sections);

	public void goToProductFromUpdateSupplier(List<Product> products);

	public void goToSupplierFromUpdateSupplier(List<Supplier> suppliers);

	public void goToBillFromUpdateSupplier(List<Bill> bills);
	
	public void goToOrderFromUpdateSupplier(List<Order> orders);


	public void goToSectionFromDetailBill(List<Section> sections);

	public void goToProductFromDetailBill(List<Product> products);

	public void goToSupplierFromDetailBill(List<Supplier> suppliers);

	public void goToBillFromDetailBill(List<Bill> bills);

	public void goToOrderFromDetailBill(List<Order> orders);
	

	public void goToSectionFromDetailOrder(List<Section> sections);

	public void goToProductFromDetailOrder(List<Product> products);

	public void goToSupplierFromDetailOrder(List<Supplier> suppliers);

	public void goToBillFromDetailOrder(List<Bill> bills);

	public void goToOrderFromDetailOrder(List<Order> orders);
	
	
	public void goToBillFromGenerateBill(List<Bill> bills);

	
	public void goToOrderFromGenerateOrder(List<Order> orders);
	
	
	public void refreshSections(List<Section> sections);

	public void refreshProducts(List<Product> products);

	public void refreshSuppliers(List<Supplier> suppliers);

	public void refreshBills(List<Bill> bills);

	public void refreshOrders(List<Order> orders);

	
	public void goGenerateBill(Bill bill, List<Product> products);

	public void goGenerateOrder(Order order, List<Product> products);
	
	
	public void goToDetailBill(List<DetailBill> detailsBill, Bill bill);

	public void goToDetailOrder(List<DetailOrder> detailsOrder, Order order);

	
	public void returnProductsFindedByName(List<Product> products);

}

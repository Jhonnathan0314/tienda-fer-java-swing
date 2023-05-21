/**
 * 
 */
package controller;

import java.util.List;

import model.DetailBill;
import model.DetailOrder;
import model.Product;
import model.Section;
import model.Supplier;

/**
 * @author JONATAN FRANCO
 *
 */
public interface CustomEvent {
	
	public void validateUserLogin(String username, String password);
	
	
	public void goToHomeFromSection();
	
	public void goToHomeFromProduct();
	
	public void goToHomeFromSupplier();
	
	public void goToHomeFromBill();
	
	public void goToHomeFromOrder();
	
	
	public void goToSectionFromHome();

	public void goToSectionFromProduct();

	public void goToSectionFromSupplier();

	public void goToSectionFromBill();

	public void goToSectionFromOrder();
	
	
	public void goToProductFromHome();
	
	public void goToProductFromSection();

	public void goToProductFromSupplier();

	public void goToProductFromBill();

	public void goToProductFromOrder();
	
	
	public void goToSupplierFromHome();

	public void goToSupplierFromSection();

	public void goToSupplierFromProduct();

	public void goToSupplierFromBill();

	public void goToSupplierFromOrder();
	
	
	public void goToBillFromHome();

	public void goToBillFromSection();

	public void goToBillFromProduct();

	public void goToBillFromSupplier();

	public void goToBillFromOrder();
	
	
	public void goToOrderFromHome();

	public void goToOrderFromSection();

	public void goToOrderFromProduct();

	public void goToOrderFromSupplier();

	public void goToOrderFromBill();
	
	
	public void goToCreateSection();

	public void goToCreateProduct();

	public void goToCreateSupplier();
	
	
	public void goToUpdateSection(int idSelected);
	
	public void goToUpdateProduct(int idSelected);

	public void goToUpdateSupplier(String idSelected);
	
	
	public void goToSectionFromCreateSection();

	public void goToProductFromCreateSection();

	public void goToSupplierFromCreateSection();

	public void goToBillFromCreateSection();

	public void goToOrderFromCreateSection();


	public void goToSectionFromUpdateSection();

	public void goToProductFromUpdateSection();

	public void goToSupplierFromUpdateSection();

	public void goToBillFromUpdateSection();

	public void goToOrderFromUpdateSection();
	
	
	public void goToSectionFromCreateProduct();

	public void goToProductFromCreateProduct();

	public void goToSupplierFromCreateProduct();

	public void goToBillFromCreateProduct();

	public void goToOrderFromCreateProduct();
	
	
	public void goToSectionFromUpdateProduct();

	public void goToProductFromUpdateProduct();

	public void goToSupplierFromUpdateProduct();

	public void goToBillFromUpdateProduct();

	public void goToOrderFromUpdateProduct();
	

	public void goToSectionFromCreateSupplier();

	public void goToProductFromCreateSupplier();

	public void goToSupplierFromCreateSupplier();

	public void goToBillFromCreateSupplier();

	public void goToOrderFromCreateSupplier();

	
	public void goToSectionFromUpdateSupplier();

	public void goToProductFromUpdateSupplier();

	public void goToSupplierFromUpdateSupplier();

	public void goToBillFromUpdateSupplier();

	public void goToOrderFromUpdateSupplier();
	
	
	public void goToSectionFromDetailBill();

	public void goToProductFromDetailBill();

	public void goToSupplierFromDetailBill();

	public void goToBillFromDetailBill();

	public void goToOrderFromDetailBill();
	
	
	public void goToSectionFromDetailOrder();

	public void goToProductFromDetailOrder();

	public void goToSupplierFromDetailOrder();

	public void goToBillFromDetailOrder();

	public void goToOrderFromDetailOrder();
	

	public void goToBillFromGenerateBill();
	

	public void goToOrderFromGenerateOrder();
	
	
	public void udpateFilterSections(String searchName);

	public void udpateFilterProductsByName(String searchName);

	public void udpateFilterSuppliers(String searchName);

	
	public void createSection(String name);

	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, int sectionId);

	public void createSupplier(String supplierId, String supplierName, String sellerName, String phone);

	public void goGenerateBill();

	public void goGenerateOrder(String idSupplier);
	
	
	public void updateSection(Section section);

	public void updateProduct(Product product);

	public void updateSupplier(Supplier supplier);
	
	
	public void deleteSectionById(int idSelected);

	public void deleteProductById(int idSelected);

	public void deleteSupplierById(String idSelected);

	public void deleteBillById(int idSelected);

	public void deleteOrderById(int idSelected);

	
	public void viewDetailBill(int idSelected);

	public void viewDetailOrder(int idSelected);

	
	public void findProductsByName(String searchName);


	public void generateDetailBill(List<DetailBill> detailsBill);

	public void generateDetailOrder(List<DetailOrder> detailsOrder);

}

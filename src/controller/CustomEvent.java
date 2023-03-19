/**
 * 
 */
package controller;

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
	
	
	public void udpateFilterSections(String searchName);

	public void udpateFilterProductsByName(String searchName);

	public void udpateFilterSuppliers(String searchName);

	
	public void createSection(String name);

	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging,
			String quantityPackaging, int sectionId);

	public void createSupplier(String supplierId, String supplierName, String sellerName, String phone);

	
	public void updateSection(Section section);

	public void updateProduct(Product product);

	public void updateSupplier(Supplier supplier);
	
	
	public void deleteSectionById(int idSelected);

	public void deleteProductById(int idSelected);

	public void deleteSupplierById(String idSelected);

}

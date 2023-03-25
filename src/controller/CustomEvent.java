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
	
	
	public void goToSectionFromHome();

	public void goToSectionFromProduct();

	public void goToSectionFromSupplier();
	
	
	public void goToProductFromHome();
	
	public void goToProductFromSection();

	public void goToProductFromSupplier();
	
	
	public void goToSupplierFromHome();

	public void goToSupplierFromSection();

	public void goToSupplierFromProduct();
	
	
	public void goToCreateSection();

	public void goToCreateProduct();

	public void goToCreateSupplier();
	
	
	public void goToUpdateSection(int idSelected);
	
	public void goToUpdateProduct(int idSelected);

	public void goToUpdateSupplier(String idSelected);
	
	
	public void goToSectionFromCreateSection();

	public void goToProductFromCreateSection();

	public void goToSupplierFromCreateSection();


	public void goToSectionFromUpdateSection();

	public void goToProductFromUpdateSection();

	public void goToSupplierFromUpdateSection();
	
	
	public void goToSectionFromCreateProduct();

	public void goToProductFromCreateProduct();

	public void goToSupplierFromCreateProduct();
	
	
	public void goToSectionFromUpdateProduct();

	public void goToProductFromUpdateProduct();

	public void goToSupplierFromUpdateProduct();
	

	public void goToSectionFromCreateSupplier();

	public void goToProductFromCreateSupplier();

	public void goToSupplierFromCreateSupplier();

	
	public void goToSectionFromUpdateSupplier();

	public void goToProductFromUpdateSupplier();

	public void goToSupplierFromUpdateSupplier();
	
	
	public void udpateFilterSections(String searchName);

	public void udpateFilterProductsByName(String searchName);

	public void udpateFilterSuppliers(String searchName);

	
	public void createSection(String name);

	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, int sectionId);

	public void createSupplier(String supplierId, String supplierName, String sellerName, String phone);
	
	
	public void updateSection(Section section);

	public void updateProduct(Product product);

	public void updateSupplier(Supplier supplier);
	
	
	public void deleteSectionById(int idSelected);

	public void deleteProductById(int idSelected);

	public void deleteSupplierById(String idSelected);

}

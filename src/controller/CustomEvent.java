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
	
	//Login method
	public void validateUserLogin(String username, String password);
	
	
	/*
	 * Methods to go to home from section, product or supplier
	 */
	public void goToHomeFromSection();
	
	public void goToHomeFromProduct();
	
	public void goToHomeFromSupplier();
	
	
	/*
	 * Methods to go to section from home, product or supplier
	 */
	public void goToSectionFromHome();

	public void goToSectionFromProduct();

	public void goToSectionFromSupplier();
	
	
	/*
	 * Methods to go to product from home, section or supplier
	 */
	public void goToProductFromHome();
	
	public void goToProductFromSection();

	public void goToProductFromSupplier();
	
	
	/*
	 * Methods to go to supplier from home, section or product
	 */
	public void goToSupplierFromHome();

	public void goToSupplierFromSection();

	public void goToSupplierFromProduct();
	
	
	/*
	 * Methods to go to create section, product or supplier
	 */
	public void goToCreateSection();

	public void goToCreateProduct();

	public void goToCreateSupplier();
	
	
	/*
	 * Methods to go to update section, product or supplier
	 */
	public void goToUpdateSection(int idSelected);
	
	public void goToUpdateProduct(int idSelected);

	public void goToUpdateSupplier(String idSelected);
	
	
	/*
	 * Methods to go to section, product or supplier from create section
	 */
	public void goToSectionFromCreateSection();

	public void goToProductFromCreateSection();

	public void goToSupplierFromCreateSection();


	/*
	 * Methods to go to section, product or supplier from update section
	 */
	public void goToSectionFromUpdateSection();

	public void goToProductFromUpdateSection();

	public void goToSupplierFromUpdateSection();
	
	
	/*
	 * Methods to go to section, product or supplier from create product
	 */
	public void goToSectionFromCreateProduct();

	public void goToProductFromCreateProduct();

	public void goToSupplierFromCreateProduct();
	
	
	/*
	 * Methods to go to section, product or supplier from update product
	 */
	public void goToSectionFromUpdateProduct();

	public void goToProductFromUpdateProduct();

	public void goToSupplierFromUpdateProduct();
	

	/*
	 * Methods to go to section, product or supplier from create supplier
	 */
	public void goToSectionFromCreateSupplier();

	public void goToProductFromCreateSupplier();

	public void goToSupplierFromCreateSupplier();

	
	/*
	 * Methods to go to section, product or supplier from update supplier
	 */
	public void goToSectionFromUpdateSupplier();

	public void goToProductFromUpdateSupplier();

	public void goToSupplierFromUpdateSupplier();
	
	
	/*
	 * Method to update filter sections, products or suppliers
	 */
	public void udpateFilterSections(String searchName);

	public void udpateFilterProductsByName(String searchName);

	public void udpateFilterSuppliers(String searchName);

	
	/*
	 * Method that create a section, product or supplier
	 */
	public void createSection(String name);

	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, int sectionId);

	public void createSupplier(String supplierId, String supplierName, String sellerName, String phone);
	
	
	/*
	 * Method that update a section, product or supplier
	 */
	public void updateSection(Section section);

	public void updateProduct(Product product);

	public void updateSupplier(Supplier supplier);
	
	
	/*
	 * Method that delete a section, product or supplier
	 */
	public void deleteSectionById(int idSelected);

	public void deleteProductById(int idSelected);

	public void deleteSupplierById(String idSelected);

}

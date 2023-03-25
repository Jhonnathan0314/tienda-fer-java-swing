/**
 * 
 */
package view;

import java.util.List;

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
	
	
	public void goToSectionFromHome(List<Section> sections);

	public void goToSectionFromProduct(List<Section> sections);

	public void goToSectionFromSupplier(List<Section> sections);
	
	
	public void goToProductFromHome(List<Product> products);

	public void goToProductFromSection(List<Product> products);

	public void goToProductFromSupplier(List<Product> products);
	
	
	public void goToSupplierFromHome(List<Supplier> suppliers);

	public void goToSupplierFromSection(List<Supplier> suppliers);

	public void goToSupplierFromProduct(List<Supplier> suppliers);
	
	
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

	
	public void goToSectionFromUpdateSection(List<Section> sections);

	public void goToProductFromUpdateSection(List<Product> products);

	public void goToSupplierFromUpdateSection(List<Supplier> suppliers);
	
	
	public void goToSectionFromCreateProduct(List<Section> sections);
	
	public void goToProductFromCreateProduct(List<Product> products);

	public void goToSupplierFromCreateProduct(List<Supplier> suppliers);
	
	
	public void goToSectionFromUpdateProduct(List<Section> sections);

	public void goToProductFromUpdateProduct(List<Product> products);

	public void goToSupplierFromUpdateProduct(List<Supplier> suppliers);
	
	
	public void goToSectionFromCreateSupplier(List<Section> sections);
	
	public void goToProductFromCreateSupplier(List<Product> products);

	public void goToSupplierFromCreateSupplier(List<Supplier> suppliers);
	

	public void goToSectionFromUpdateSupplier(List<Section> sections);

	public void goToProductFromUpdateSupplier(List<Product> products);

	public void goToSupplierFromUpdateSupplier(List<Supplier> suppliers);
	
	
	public void refreshSections(List<Section> sections);

	public void refreshProducts(List<Product> products);

	public void refreshSuppliers(List<Supplier> suppliers);

}

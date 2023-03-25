/**
 * 
 */
package controller;

import java.util.List;

import model.Product;
import model.Section;
import model.Supplier;
import modeldao.ProductDAO;
import modeldao.SectionDAO;
import modeldao.SupplierDAO;
import modeldao.UserSecurityDAO;
import view.CustomEventAnswer;
import view.IOManager;

/**
 * @author JONATAN FRANCO
 *
 */
public class Control implements CustomEvent {
	//Declaracion de variables
	private SectionDAO sectionDAO;
	private ProductDAO productDAO;
	private SupplierDAO supplierDAO;
	private UserSecurityDAO userSecurityDAO;
	
	private CustomEventAnswer answer;
	
	public Control(String empty) { }
	
	public Control() {
		Conexion conexion = new Conexion();
		conexion.getConexion();
		sectionDAO = new SectionDAO(conexion.getConnect());
		productDAO = new ProductDAO(conexion.getConnect());
		productDAO.setSectionDAO(sectionDAO);
		supplierDAO = new SupplierDAO(conexion.getConnect());
		userSecurityDAO = new UserSecurityDAO(conexion.getConnect());
	}

	public void init() {
		IOManager frame = new IOManager();
		frame.setVisible(true);
	}

	public CustomEventAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(CustomEventAnswer answer) {
		this.answer = answer;
	}

	@Override
	public void validateUserLogin(String username, String password) {
		boolean isValid = userSecurityDAO.checkPassword(username, password);
		List<Product> products = productDAO.findScarceProducts();
		answer.isValidResponse(isValid, products);
	}
	
	@Override
	public void goToHomeFromSection() {
		List<Product> products = productDAO.findScarceProducts();
		answer.goToHomeFromSection(products);
	}
	
	@Override
	public void goToHomeFromProduct() {
		List<Product> products = productDAO.findScarceProducts();
		answer.goToHomeFromProduct(products);
	}

	@Override
	public void goToHomeFromSupplier() {
		List<Product> products = productDAO.findScarceProducts();
		answer.goToHomeFromSupplier(products);
	}

	@Override
	public void goToSectionFromHome() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromHome(sections);
	}

	@Override
	public void goToSectionFromProduct() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromProduct(sections);
	}

	@Override
	public void goToSectionFromSupplier() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromSupplier(sections);
	}
	@Override
	public void goToProductFromHome() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromHome(products);
	}
	
	@Override
	public void goToProductFromSection() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromSection(products);
	}

	@Override
	public void goToProductFromSupplier() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromSupplier(products);
	}

	@Override
	public void goToSupplierFromHome() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromHome(suppliers);
	}
	
	@Override
	public void goToSupplierFromSection() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromSection(suppliers);
	}

	@Override
	public void goToSupplierFromProduct() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromProduct(suppliers);
	}

	@Override
	public void goToCreateSection() {
		answer.goToCreateSection();
	}

	@Override
	public void goToCreateProduct() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToCreateProduct(sections);
	}

	@Override
	public void goToCreateSupplier() {
		answer.goToCreateSupplier();
	}

	@Override
	public void goToUpdateSection(int idSelected) {
		Section section = new Section();
		section = sectionDAO.findById(idSelected);
		answer.goToUpdateSection(section);
	}

	@Override
	public void goToUpdateProduct(int idSelected) {
		Product product = new Product();
		product = productDAO.findById(idSelected);
		List<Section> sections = sectionDAO.findAll();
		answer.goToUpdateProduct(product, sections);
	}

	@Override
	public void goToUpdateSupplier(String idSelected) {
		Supplier supplier = new Supplier();
		supplier = supplierDAO.findById(idSelected);
		answer.goToUpdateSupplier(supplier);
	}

	@Override
	public void goToSectionFromCreateSection() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromCreateSection(sections);
	}

	@Override
	public void goToProductFromCreateSection() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromCreateSection(products);
	}

	@Override
	public void goToSupplierFromCreateSection() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromCreateSection(suppliers);
	}
	
	@Override
	public void goToSectionFromUpdateSection() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromUpdateSection(sections);
	}

	@Override
	public void goToProductFromUpdateSection() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromUpdateSection(products);
	}

	@Override
	public void goToSupplierFromUpdateSection() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromUpdateSection(suppliers);
	}

	@Override
	public void goToSectionFromCreateProduct() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromCreateProduct(sections);
	}

	@Override
	public void goToProductFromCreateProduct() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromCreateProduct(products);
	}

	@Override
	public void goToSupplierFromCreateProduct() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromCreateProduct(suppliers);
	}

	@Override
	public void goToSectionFromUpdateProduct() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromUpdateProduct(sections);
	}

	@Override
	public void goToProductFromUpdateProduct() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromUpdateProduct(products);
	}

	@Override
	public void goToSupplierFromUpdateProduct() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromUpdateProduct(suppliers);
	}

	@Override
	public void goToSectionFromCreateSupplier() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromCreateSupplier(sections);
	}

	@Override
	public void goToProductFromCreateSupplier() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromCreateSupplier(products);
	}

	@Override
	public void goToSupplierFromCreateSupplier() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromCreateSupplier(suppliers);
	}

	@Override
	public void goToSectionFromUpdateSupplier() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromUpdateSupplier(sections);
	}

	@Override
	public void goToProductFromUpdateSupplier() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromUpdateSupplier(products);
	}

	@Override
	public void goToSupplierFromUpdateSupplier() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromUpdateSupplier(suppliers);
	}

	@Override
	public void udpateFilterSections(String searchName) {
		List<Section> sections = sectionDAO.findByName(searchName);
		answer.filteredSectionsResponse(sections);
	}

	@Override
	public void udpateFilterProductsByName(String searchName) {
		List<Product> products = productDAO.findByName(searchName);
		answer.filteredProductsByNameResponse(products);
	}

	@Override
	public void udpateFilterSuppliers(String searchName) {
		List<Supplier> suppliers = supplierDAO.findByName(searchName);
		answer.filteredSuppliersBySupplierNameResponse(suppliers);
	}

	@Override
	public void createSection(String name) {
		Section section = new Section();
		section.setName(name);
		section = sectionDAO.create(section);
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromCreateSection(sections);
	}

	@Override
	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, int sectionId) {
		Product product = new Product();
		product.setName(name);
		product.setQuantityAvailable(quantityAvailable);
		product.setSaleValue(saleValue);
		product.setPackaging(packaging);
		product.setQuantityPackaging(quantityPackaging);
		product.setSection(new Section(sectionId, "", null));
		product = productDAO.create(product);
		List<Product> products = productDAO.findAll();
		answer.goToProductFromCreateProduct(products);
	}

	@Override
	public void createSupplier(String supplierId, String supplierName, String sellerName, String phone) {
		Supplier supplier = new Supplier();
		supplier.setId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSellerName(sellerName);
		supplier.setPhone(phone);
		supplier = supplierDAO.create(supplier);
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromCreateSupplier(suppliers);
	}

	@Override
	public void updateSection(Section section) {
		sectionDAO.update(section.getId(), section);
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromUpdateSection(sections);
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.update(product.getId(), product);
		List<Product> products = productDAO.findAll();
		answer.goToProductFromUpdateProduct(products);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		supplierDAO.update(supplier.getId(), supplier);
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromUpdateSupplier(suppliers);
	}

	@Override
	public void deleteSectionById(int idSelected) {
		sectionDAO.deleteById(idSelected);
		List<Section> sections = sectionDAO.findAll();
		answer.refreshSections(sections);
	}

	@Override
	public void deleteProductById(int idSelected) {
		productDAO.deleteById(idSelected);
		List<Product> products = productDAO.findAll();
		answer.refreshProducts(products);
	}

	@Override
	public void deleteSupplierById(String idSelected) {
		supplierDAO.deleteById(idSelected);
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.refreshSuppliers(suppliers);
	}
}

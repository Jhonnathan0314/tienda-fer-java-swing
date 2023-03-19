/**
 * 
 */
package controller;

import java.util.LinkedList;
import java.util.List;

import model.Bill;
import model.Order;
import model.Product;
import model.Section;
import model.Supplier;
import modeldao.BillDAO;
import modeldao.DetailBillDAO;
import modeldao.DetailOrderDAO;
import modeldao.OrderDAO;
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
	private BillDAO billDAO;
	private DetailBillDAO detailBillDAO;
	private OrderDAO orderDAO;
	private DetailOrderDAO detailOrderDAO;
	private UserSecurityDAO userSecurityDAO;
	
	private CustomEventAnswer answer;
	
	public Control() {
		Conexion conexion = new Conexion();
		conexion.getConexion();
		sectionDAO = new SectionDAO(conexion.getConnect());
		productDAO = new ProductDAO(conexion.getConnect());
		productDAO.setSectionDAO(sectionDAO);
		supplierDAO = new SupplierDAO(conexion.getConnect());
		billDAO = new BillDAO(conexion.getConnect());
		detailBillDAO = new DetailBillDAO(conexion.getConnect());
		detailBillDAO.setBillDAO(billDAO);
		detailBillDAO.setProductDAO(productDAO);
		orderDAO = new OrderDAO(conexion.getConnect());
		orderDAO.setSupplierDAO(supplierDAO);
		detailOrderDAO = new DetailOrderDAO(conexion.getConnect());
		detailOrderDAO.setOrderDAO(orderDAO);
		detailOrderDAO.setProductDAO(productDAO);
		userSecurityDAO = new UserSecurityDAO(conexion.getConnect());
	}

	public void init() {
		
		
//		List<Section> sections = sectionDAO.findAll();
//		for(Section section : sections) {
//			System.out.println(section.getName());
//		}
		
//		Section section = new Section();
//		section.setName("PRUEBA CREAR");
//		section = sectionDAO.create(section);
		
//		Section section = new Section();
//		section.setName("PRUEBA ACTUALIZAR");
//		section = sectionDAO.update(11, section);
	
//		section = sectionDAO.findById(11);
//		System.out.println(section.getName());
		
//		boolean isDeleted = sectionDAO.deleteById(11);
//		System.out.println(isDeleted);
		

		
//		List<Product> products = productDAO.findAll();
//		for(Product product : products) {
//			System.out.println(product.getName() + "; Seccion: " + product.getSection().getName());
//		}
		
//		List<Product> products = productDAO.findByName("COCA");
//		for(Product product : products) {
//			System.out.println(product.getName() + "; Seccion: " + product.getSection().getName());
//		}		
		
//		List<Product> products = productDAO.findBySection(3);
//		for(Product product : products) {
//			System.out.println(product.getName() + "; Seccion: " + product.getSection().getName());
//		}		
		
//		Product product = new Product();
//		product.setName("PRUEBA CREAR");
//		product.setQuantityAvailable(0);
//		product.setSaleValue(1000);
//		product.setPackaging("CAJA");
//		product.setQuantityPackaging("1000ml");
//		product.setSection(new Section(1, "", null));
//		productDAO.create(product);
		
//		Product product = new Product();
//		product.setName("PRUEBA ACTUALIZAR");
//		product.setQuantityAvailable(5);
//		product.setSaleValue(10000);
//		product.setPackaging("BOLSA");
//		product.setQuantityPackaging("900ml");
//		product.setSection(new Section(1, "", null));
//		productDAO.update(568, product);
		
//		product = productDAO.findById(568);
//		System.out.println(product.getName() + "; Seccion: " + product.getSection().getName());
		
//		boolean isDeleted = productDAO.deleteById(568);
			
		
//		List<Supplier> suppliers = supplierDAO.findAll();
//		for(Supplier supplier : suppliers) {
//			System.out.println(supplier.getSupplierName());
//		}
		
//		Supplier supplier = new Supplier();
//		supplier.setId("3125543042");
//		supplier.setSupplierName("PRUEBA CREAR");
//		supplier.setSellerName("PRUEBA CREAR");
//		supplier.setPhone("18000111222");
//		supplier = supplierDAO.create(supplier);
//		
//		Supplier supplier = new Supplier();
//		supplier.setId("3125543042");
//		supplier.setSupplierName("PRUEBA ACTUALIZAR");
//		supplier.setSellerName("PRUEBA ACTUALIZAR");
//		supplier.setPhone("18000111333");
//		supplier = supplierDAO.update("3125543042", supplier);
	
//		supplier = supplierDAO.findById("3125543042");
//		System.out.println(supplier.getSupplierName());
		
//		boolean isDeleted = supplierDAO.deleteById("3125543042");
//		System.out.println(isDeleted);
		
		
//		List<Bill> bills = billDAO.findAll();
//		for(Bill bill : bills) {
//			System.out.println(bill.getId() + "; tv: " + bill.getTotalValue() + "; dt: " + bill.getDate());
//		}
		
//		Bill bill = new Bill();
//		bill.setTotalValue(10000);
//		billDAO.create(bill);
		
//		bill = billDAO.findById(2);
//		System.out.println(bill.getId() + "; tv: " + bill.getTotalValue() + "; dt: " + bill.getDate());
		
//		List<Bill> bills = billDAO.findByYear(2023);
//		for(Bill bill : bills) {
//			System.out.println(bill.getId() + "; tv: " + bill.getTotalValue() + "; dt: " + bill.getDate());
//		}
		
//		List<Bill> bills = billDAO.findByYearAndMonth(2023, 03);
//		for(Bill bill : bills) {
//			System.out.println(bill.getId() + "; tv: " + bill.getTotalValue() + "; dt: " + bill.getDate());
//		}
		
//		List<Bill> bills = billDAO.findByYearAndMonthAndDay(2023, 3, 5);
//		for(Bill bill : bills) {
//			System.out.println(bill.getId() + "; tv: " + bill.getTotalValue() + "; dt: " + bill.getDate());
//		}
		
//		boolean isDeleted = billDAO.deleteById(1);
//		System.out.println(isDeleted);
		
		
//		DetailBill detailBill = new DetailBill();
		
//		Product product = new Product();
//		product = productDAO.findById(1);
		
//		Bill bill = new Bill();
//		bill.setId(2);
		
//		detailBill.setProduct(product);
//		detailBill.setBill(bill);
//		detailBill.setQuantity(3);
//		detailBill.setUnitValue(product.getSaleValue());
//		detailBill.setTotalValue(detailBill.getQuantity() * detailBill.getUnitValue());
//		detailBillDAO.insert(detailBill);
		
//		detailBill = new DetailBill();
//		product = new Product();
//		product = productDAO.findById(2);
		
//		bill = new Bill();
//		bill.setId(2);
		
//		detailBill.setProduct(product);
//		detailBill.setBill(bill);
//		detailBill.setQuantity(2);
//		detailBill.setUnitValue(product.getSaleValue());
//		detailBill.setTotalValue(detailBill.getQuantity() * detailBill.getUnitValue());
//		detailBillDAO.insert(detailBill);
		
//		List<DetailBill> detailBills = detailBillDAO.findByBill(2);
//		for(DetailBill detailBill2 : detailBills) {
//			System.out.println("producto: " + detailBill2.getProduct().getName());
//		}
		
		
//		List<Order> orders = orderDAO.findAll();
//		for(Order order : orders) {
//			System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
//		}
		
//		Order order = new Order();
//		order.setTotalValue(10000);
//		order.setSupplier(new Supplier("0", "", "", "", null));
//		orderDAO.create(order);
		
//		order = orderDAO.findById(1);
//		System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
		
//		List<Order> orders = orderDAO.findByYear(2023);
//		for(Order order : orders) {
//			System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
//		}
		
//		List<Order> orders = orderDAO.findByYearAndMonth(2023, 3);
//		for(Order order : orders) {
//			System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
//		}
		
//		List<Order> orders = orderDAO.findByYearAndMonthAndDay(2023, 3, 5);
//		for(Order order : orders) {
//			System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
//		}
		
//		List<Order> orders = orderDAO.findBySupplier("0");
//		for(Order order : orders) {
//			System.out.println(order.getId() + "; tv: " + order.getTotalValue() + "; dt: " + order.getDate());
//		}
		
//		boolean isDeleted = orderDAO.deleteById(1);
//		System.out.println(isDeleted);
		
		
//		DetailOrder detailOrder = new DetailOrder();
		
//		Product product = new Product();
//		product = productDAO.findById(1);
		
//		Order order = new Order();
//		order.setId(1);
		
//		detailOrder.setProduct(product);
//		detailOrder.setOrder(order);
//		detailOrder.setOrderedQuantity(5);
//		detailOrder.setReceivedQuantity(4);
//		detailOrder.setUnitValue(1600);
//		detailOrder.setTotalValue(detailOrder.getReceivedQuantity() * detailOrder.getUnitValue());
//		detailOrderDAO.insert(detailOrder);
		
//		detailOrder = new DetailOrder();
//		product = new Product();
//		product = productDAO.findById(2);
		
//		order = new Order();
//		order.setId(1);
		
//		detailOrder.setProduct(product);
//		detailOrder.setOrder(order);
//		detailOrder.setOrderedQuantity(6);
//		detailOrder.setReceivedQuantity(6);
//		detailOrder.setUnitValue(1600);
//		detailOrder.setTotalValue(detailOrder.getReceivedQuantity() * detailOrder.getUnitValue());
//		detailOrderDAO.insert(detailOrder);
		
//		List<DetailOrder> detailOrders = detailOrderDAO.findByOrder(1);
//		for(DetailOrder detailOrder2 : detailOrders) {
//			System.out.println("producto: " + detailOrder2.getProduct().getName());
//		}
		
//		boolean isValid = userSecurityDAO.checkPassword("admin", "tiendadonalola");
//		System.out.println("isvalid: " + isValid);
		
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
	public void goToHomeFromBill() {
		List<Product> products = productDAO.findScarceProducts();
		answer.goToHomeFromBill(products);
	}

	@Override
	public void goToHomeFromOrder() {
		List<Product> products = productDAO.findScarceProducts();
		answer.goToHomeFromOrder(products);
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
	public void goToSectionFromBill() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromBill(sections);
	}

	@Override
	public void goToSectionFromOrder() {
		List<Section> sections = sectionDAO.findAll();
		answer.goToSectionFromOrder(sections);
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
	public void goToProductFromBill() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromBill(products);
	}

	@Override
	public void goToProductFromOrder() {
		List<Product> products = productDAO.findAll();
		answer.goToProductFromOrder(products);
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
	public void goToSupplierFromBill() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromBill(suppliers);
	}

	@Override
	public void goToSupplierFromOrder() {
		List<Supplier> suppliers = supplierDAO.findAll();
		answer.goToSupplierFromOrder(suppliers);
	}

	@Override
	public void goToBillFromHome() {
		List<Bill> bills = billDAO.findAll();
		answer.goToBillFromHome(bills);
	}
	
	@Override
	public void goToBillFromSection() {
		List<Bill> bills = billDAO.findAll();
		answer.goToBillFromSection(bills);
	}

	@Override
	public void goToBillFromProduct() {
		List<Bill> bills = billDAO.findAll();
		answer.goToBillFromProduct(bills);
	}

	@Override
	public void goToBillFromSupplier() {
		List<Bill> bills = billDAO.findAll();
		answer.goToBillFromSupplier(bills);
	}

	@Override
	public void goToBillFromOrder() {
		List<Bill> bills = billDAO.findAll();
		answer.goToBillFromOrder(bills);
	}

	@Override
	public void goToOrderFromHome() {
		List<Order> orders = orderDAO.findAll();
		answer.goToOrderFromHome(orders);
	}
	
	@Override
	public void goToOrderFromSection() {
		List<Order> orders = orderDAO.findAll();
		answer.goToOrderFromSection(orders);
	}

	@Override
	public void goToOrderFromProduct() {
		List<Order> orders = orderDAO.findAll();
		answer.goToOrderFromProduct(orders);
	}

	@Override
	public void goToOrderFromSupplier() {
		List<Order> orders = orderDAO.findAll();
		answer.goToOrderFromSupplier(orders);
	}

	@Override
	public void goToOrderFromBill() {
		List<Order> orders = orderDAO.findAll();
		answer.goToOrderFromBill(orders);
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
	public void createProduct(String name, int quantityAvailable, float saleValue, String packaging,
			String quantityPackaging, int sectionId) {
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

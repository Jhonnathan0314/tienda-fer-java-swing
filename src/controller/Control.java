/**
 * 
 */
package controller;

import java.util.List;

import model.Bill;
import model.DetailBill;
import model.DetailOrder;
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
	
	private CustomEventAnswer answer;

	public void init() {
		Conexion conexion = new Conexion();
		conexion.getConexion();
		
		sectionDAO = new SectionDAO(conexion.getConnect());
		
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
		

		productDAO = new ProductDAO(conexion.getConnect());
		productDAO.setSectionDAO(sectionDAO);
		
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
		
//		IOManager frame = new IOManager();
//		frame.setVisible(true);
		
		supplierDAO = new SupplierDAO(conexion.getConnect());
		
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
		
		billDAO = new BillDAO(conexion.getConnect());
		
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
		
		detailBillDAO = new DetailBillDAO(conexion.getConnect());
		detailBillDAO.setBillDAO(billDAO);
		detailBillDAO.setProductDAO(productDAO);
		
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
		
		orderDAO = new OrderDAO(conexion.getConnect());
		orderDAO.setSupplierDAO(supplierDAO);
		
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
		
		detailOrderDAO = new DetailOrderDAO(conexion.getConnect());
		detailOrderDAO.setOrderDAO(orderDAO);
		detailOrderDAO.setProductDAO(productDAO);
		
		DetailOrder detailOrder = new DetailOrder();
		
		Product product = new Product();
		product = productDAO.findById(1);
		
		Order order = new Order();
		order.setId(1);
		
		detailOrder.setProduct(product);
		detailOrder.setOrder(order);
		detailOrder.setOrderedQuantity(5);
		detailOrder.setReceivedQuantity(4);
		detailOrder.setUnitValue(1600);
		detailOrder.setTotalValue(detailOrder.getReceivedQuantity() * detailOrder.getUnitValue());
		detailOrderDAO.insert(detailOrder);
		
		detailOrder = new DetailOrder();
		product = new Product();
		product = productDAO.findById(2);
		
		order = new Order();
		order.setId(1);
		
		detailOrder.setProduct(product);
		detailOrder.setOrder(order);
		detailOrder.setOrderedQuantity(6);
		detailOrder.setReceivedQuantity(6);
		detailOrder.setUnitValue(1600);
		detailOrder.setTotalValue(detailOrder.getReceivedQuantity() * detailOrder.getUnitValue());
		detailOrderDAO.insert(detailOrder);
		
		List<DetailOrder> detailOrders = detailOrderDAO.findByOrder(1);
		for(DetailOrder detailOrder2 : detailOrders) {
			System.out.println("producto: " + detailOrder2.getProduct().getName());
		}
	}

	public CustomEventAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(CustomEventAnswer answer) {
		this.answer = answer;
	}
	
}

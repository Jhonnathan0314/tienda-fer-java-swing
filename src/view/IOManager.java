package view;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import controller.Control;
import model.Bill;
import model.DetailBill;
import model.DetailOrder;
import model.Order;
import model.Product;
import model.Section;
import model.Supplier;
import view.basic.HomePane;
import view.basic.LoginPane;
import view.bill.BillAllPane;
import view.bill.DetailBillPane;
import view.bill.GenerateBillPane;
import view.order.DetailOrderPane;
import view.order.GenerateOrderPane;
import view.order.OrderAllPane;
import view.product.CreateProductPane;
import view.product.ProductAllPane;
import view.product.UpdateProductPane;
import view.section.CreateSectionPane;
import view.section.SectionAllPane;
import view.section.UpdateSectionPane;
import view.supplier.CreateSupplierPane;
import view.supplier.SupplierAllPane;
import view.supplier.UpdateSupplierPane;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote JFRAME PRINCIPAL
 * @version V2 -> 24-03-2023
 */
public class IOManager extends JFrame implements CustomEventAnswer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variables declaration
	private Dimension dim;
	
	private LoginPane loginPane;
	private HomePane homePane;
	
	private SectionAllPane sectionAllPane;
	private CreateSectionPane createSectionPane;
	private UpdateSectionPane updateSectionPane;
	
	private ProductAllPane productAllPane;
	private CreateProductPane createProductPane;
	private UpdateProductPane updateProductPane;

	private SupplierAllPane supplierAllPane;
	private CreateSupplierPane createSupplierPane;
	private UpdateSupplierPane updateSupplierPane;
	
	private BillAllPane billAllPane;
	private DetailBillPane detailBillPane;
	private GenerateBillPane generateBillPane;
	
	private OrderAllPane orderAllPane;
	private DetailOrderPane detailOrderPane;
	private GenerateOrderPane generateOrderPane;
	
	/**
	 * Create the frame.
	 */
	public IOManager() {
		Control control = new Control();
		control.setAnswer(this);
		
		dim = super.getToolkit().getScreenSize();
		
		setTitle("Tienda doña Lola");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(dim);
		
		loginPane = new LoginPane();
		loginPane.setSize(dim);
		((LoginPane) loginPane).setEvent(control);
		add(loginPane);
		
		homePane = new HomePane();
		homePane.setSize(dim);
		((HomePane) homePane).setEvent(control);
		homePane.setVisible(false);
		add(homePane);
		
		sectionAllPane = new SectionAllPane();
		sectionAllPane.setSize(dim);
		((SectionAllPane) sectionAllPane).setEvent(control);
		sectionAllPane.setVisible(false);
		add(sectionAllPane);
		
		createSectionPane = new CreateSectionPane();
		createSectionPane.setSize(dim);
		((CreateSectionPane) createSectionPane).setEvent(control);
		createSectionPane.setVisible(false);
		add(createSectionPane);
		
		updateSectionPane = new UpdateSectionPane();
		updateSectionPane.setSize(dim);
		((UpdateSectionPane) updateSectionPane).setEvent(control);
		updateSectionPane.setVisible(false);
		add(updateSectionPane);
		
		productAllPane = new ProductAllPane();
		productAllPane.setSize(dim);
		((ProductAllPane) productAllPane).setEvent(control);
		productAllPane.setVisible(false);
		add(productAllPane);
		
		createProductPane = new CreateProductPane();
		createProductPane.setSize(dim);
		((CreateProductPane) createProductPane).setEvent(control);
		createProductPane.setVisible(false);
		add(createProductPane);
		
		updateProductPane = new UpdateProductPane();
		updateProductPane.setSize(dim);
		((UpdateProductPane) updateProductPane).setEvent(control);
		updateProductPane.setVisible(false);
		add(updateProductPane);
		
		supplierAllPane = new SupplierAllPane();
		supplierAllPane.setSize(dim);
		((SupplierAllPane) supplierAllPane).setEvent(control);
		supplierAllPane.setVisible(false);
		add(supplierAllPane);
		
		createSupplierPane = new CreateSupplierPane();
		createSupplierPane.setSize(dim);
		((CreateSupplierPane) createSupplierPane).setEvent(control);
		createSupplierPane.setVisible(false);
		add(createSupplierPane);
		
		updateSupplierPane = new UpdateSupplierPane();
		updateSupplierPane.setSize(dim);
		((UpdateSupplierPane) updateSupplierPane).setEvent(control);
		updateSupplierPane.setVisible(false);
		add(updateSupplierPane);
		
		billAllPane = new BillAllPane();
		billAllPane.setSize(dim);
		((BillAllPane) billAllPane).setEvent(control);
		billAllPane.setVisible(false);
		add(billAllPane);
		
		detailBillPane = new DetailBillPane();
		detailBillPane.setSize(dim);
		((DetailBillPane) detailBillPane).setEvent(control);
		detailBillPane.setVisible(false);
		add(detailBillPane);
		
		generateBillPane = new GenerateBillPane();
		generateBillPane.setSize(dim);
		((GenerateBillPane) generateBillPane).setEvent(control);
		generateBillPane.setVisible(false);
		add(generateBillPane);
		
		orderAllPane = new OrderAllPane();
		orderAllPane.setSize(dim);
		((OrderAllPane) orderAllPane).setEvent(control);
		orderAllPane.setVisible(false);
		add(orderAllPane);
		
		detailOrderPane = new DetailOrderPane();
		detailOrderPane.setSize(dim);
		((DetailOrderPane) detailOrderPane).setEvent(control);
		detailOrderPane.setVisible(false);
		add(detailOrderPane);
		
		generateOrderPane = new GenerateOrderPane();
		generateOrderPane.setSize(dim);
		((GenerateOrderPane) generateOrderPane).setEvent(control);
		generateOrderPane.setVisible(false);
		add(generateOrderPane);
	}

	/**
	 * @param isValid -> Response if login is valid
	 * @param products -> Scarced products
	 */
	@Override
	public void isValidResponse(boolean isValid, List<Product> products) {
		if(isValid) {
			((LoginPane) loginPane).setVisible(false);
			((HomePane) homePane).setProducts(products);
			((HomePane) homePane).setVisible(true);
		}else {
			((LoginPane) loginPane).setValid(isValid);			
		}
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToHomeFromSection(List<Product> products) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToHomeFromProduct(List<Product> products) {
		((ProductAllPane) productAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToHomeFromSupplier(List<Product> products) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToHomeFromBill(List<Product> products) {
		((BillAllPane) billAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToHomeFromOrder(List<Product> products) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	/**
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromHome(List<Section> sections) {
		((HomePane) homePane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromProduct(List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromSupplier(List<Section> sections) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromBill(List<Section> sections) {
		((BillAllPane) billAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromOrder(List<Section> sections) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToProductFromHome(List<Product> products) {
		((HomePane) homePane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToProductFromSection(List<Product> products) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToProductFromSupplier(List<Product> products) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToProductFromBill(List<Product> products) {
		((BillAllPane) billAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * @param products -> Scarced products
	 */
	@Override
	public void goToProductFromOrder(List<Product> products) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromHome(List<Supplier> suppliers) {
		((HomePane) homePane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromSection(List<Supplier> suppliers) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromProduct(List<Supplier> suppliers) {
		((ProductAllPane) productAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromBill(List<Supplier> suppliers) {
		((BillAllPane) billAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromOrder(List<Supplier> suppliers) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromHome(List<Bill> bills) {
		((HomePane) homePane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromSection(List<Bill> bills) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromProduct(List<Bill> bills) {
		((ProductAllPane) productAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromSupplier(List<Bill> bills) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromOrder(List<Bill> bills) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromHome(List<Order> orders, List<Supplier> suppliers) {
		((HomePane) homePane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromSection(List<Order> orders, List<Supplier> suppliers) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromProduct(List<Order> orders, List<Supplier> suppliers) {
		((ProductAllPane) productAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromSupplier(List<Order> orders, List<Supplier> suppliers) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromBill(List<Order> orders, List<Supplier> suppliers) {
		((BillAllPane) billAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show CreateSectionPane and hide SectionAllPane
	 */
	@Override
	public void goToCreateSection() {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((CreateSectionPane) createSectionPane).setVisible(true);
	}

	/**
	 * Show CreateProductPane and hide ProductAllPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToCreateProduct(List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((CreateProductPane) createProductPane).setSections(sections);
		((CreateProductPane) createProductPane).setVisible(true);
	}

	/**
	 * Show CreateSupplierPane and hide SupplierAllPane
	 */
	@Override
	public void goToCreateSupplier() {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((CreateSupplierPane) createSupplierPane).setVisible(true);
	}

	/**
	 * Show UpdateSectionPane and hide SectionAllPane
	 * @param section -> section selected
	 */
	@Override
	public void goToUpdateSection(Section section) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((UpdateSectionPane) updateSectionPane).setSection(section);
		((UpdateSectionPane) updateSectionPane).setVisible(true);
	}

	/**
	 * Show UpdateProductPane and hide ProductAllPane
	 * @param product -> product selected
	 * @param sections -> all sections
	 */
	@Override
	public void goToUpdateProduct(Product product, List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((UpdateProductPane) updateProductPane).setSections(sections);
		((UpdateProductPane) updateProductPane).setProduct(product);
		((UpdateProductPane) updateProductPane).setVisible(true);
	}

	/**
	 * Show UpdateSupplierPane and hide SupplierAllPane
	 * @param supplier -> supplier selected
	 */
	@Override
	public void goToUpdateSupplier(Supplier supplier) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((UpdateSupplierPane) updateSupplierPane).setSupplier(supplier);
		((UpdateSupplierPane) updateSupplierPane).setVisible(true);
	}

	/**
	 * @param sections -> sections finded
	 */
	@Override
	public void filteredSectionsResponse(List<Section> sections) {
		((SectionAllPane) sectionAllPane).setSections(sections);
	}

	/**
	 * @param products -> products finded
	 */
	@Override
	public void filteredProductsByNameResponse(List<Product> products) {
		((ProductAllPane) productAllPane).setProducts(products);
	}

	/**
	 * @param suppliers -> suppliers finded
	 */
	@Override
	public void filteredSuppliersBySupplierNameResponse(List<Supplier> suppliers) {
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
	}

	/**
	 * Show SectionAllPane and hide CreateSectionPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromCreateSection(List<Section> sections) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide CreateSectionPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromCreateSection(List<Product> products) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide CreateSectionPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromCreateSection(List<Supplier> suppliers) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide CreateSectionPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromCreateSection(List<Bill> bills) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide CreateSectionPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromCreateSection(List<Order> orders, List<Supplier> suppliers) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide UpdateSectionPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromUpdateSection(List<Section> sections) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide UpdateSectionPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromUpdateSection(List<Product> products) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide UpdateSectionPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromUpdateSection(List<Supplier> suppliers) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide UpdateSectionPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromUpdateSection(List<Bill> bills) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide UpdateSectionPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromUpdateSection(List<Order> orders, List<Supplier> suppliers) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide CreateProductPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromCreateProduct(List<Section> sections) {
		((CreateProductPane) createProductPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide CreateProductPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromCreateProduct(List<Product> products) {
		((CreateProductPane) createProductPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide CreateProductPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromCreateProduct(List<Supplier> suppliers) {
		((CreateProductPane) createProductPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide CreateProductPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromCreateProduct(List<Bill> bills) {
		((CreateProductPane) createProductPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide CreateProductPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromCreateProduct(List<Order> orders, List<Supplier> suppliers) {
		((CreateProductPane) createProductPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide UpdateProductPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromUpdateProduct(List<Section> sections) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide UpdateProductPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromUpdateProduct(List<Product> products) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide UpdateProductPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromUpdateProduct(List<Supplier> suppliers) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide UpdateProductPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromUpdateProduct(List<Bill> bills) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide UpdateProductPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromUpdateProduct(List<Order> orders, List<Supplier> suppliers) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide CreateSupplierPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromCreateSupplier(List<Section> sections) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide CreateSupplierPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromCreateSupplier(List<Product> products) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide CreateSupplierPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromCreateSupplier(List<Supplier> suppliers) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide CreateSupplierPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromCreateSupplier(List<Bill> bills) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide CreateSupplierPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromCreateSupplier(List<Order> orders, List<Supplier> suppliers) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide UpdateSupplierPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromUpdateSupplier(List<Section> sections) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide UpdateSupplierPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromUpdateSupplier(List<Product> products) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide UpdateSupplierPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromUpdateSupplier(List<Supplier> suppliers) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide UpdateSupplierPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromUpdateSupplier(List<Bill> bills) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide UpdateSupplierPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromUpdateSupplier(List<Order> orders, List<Supplier> suppliers) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide DetailBillPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromDetailBill(List<Section> sections) {
		((DetailBillPane) detailBillPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide DetailBillPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromDetailBill(List<Product> products) {
		((DetailBillPane) detailBillPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide DetailBillPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromDetailBill(List<Supplier> suppliers) {
		((DetailBillPane) detailBillPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide DetailBillPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromDetailBill(List<Bill> bills) {
		((DetailBillPane) detailBillPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide DetailBillPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromDetailBill(List<Order> orders, List<Supplier> suppliers) {
		((DetailBillPane) detailBillPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show SectionAllPane and hide DetailOrderPane
	 * @param sections -> All sections
	 */
	@Override
	public void goToSectionFromDetailOrder(List<Section> sections) {
		((DetailOrderPane) detailOrderPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	/**
	 * Show ProductAllPane and hide DetailOrderPane
	 * @param products -> All products
	 */
	@Override
	public void goToProductFromDetailOrder(List<Product> products) {
		((DetailOrderPane) detailOrderPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	/**
	 * Show SupplierAllPane and hide DetailOrderPane
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToSupplierFromDetailOrder(List<Supplier> suppliers) {
		((DetailOrderPane) detailOrderPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide DetailOrderPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromDetailOrder(List<Bill> bills) {
		((DetailOrderPane) detailOrderPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide DetailOrderPane
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromDetailOrder(List<Order> orders, List<Supplier> suppliers) {
		((DetailOrderPane) detailOrderPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	/**
	 * Show BillAllPane and hide GenerateBillPane
	 * @param bills -> All bills
	 */
	@Override
	public void goToBillFromGenerateBill(List<Bill> bills) {
		((GenerateBillPane) generateBillPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	/**
	 * Show OrderAllPane and hide GenerateOrderPane 
	 * @param orders -> All orders
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void goToOrderFromGenerateOrder(List<Order> orders, List<Supplier> suppliers) {
		((GenerateOrderPane) generateOrderPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setSuppliers(suppliers);
		((OrderAllPane) orderAllPane).setVisible(true);
	}
	
	@Override
	public void returnProductsFindedByName(List<Product> products) {
		((GenerateBillPane) generateBillPane).setProducts(products);
	}
	
	/**
	 * update all sections after delete section by id
	 * @param sections -> All sections
	 */
	@Override
	public void refreshSections(List<Section> sections) {
		((SectionAllPane) sectionAllPane).setSections(sections);
	}
	
	/**
	 * update all products after delete product by id
	 * @param products -> All products
	 */
	@Override
	public void refreshProducts(List<Product> products) {
		((ProductAllPane) productAllPane).setProducts(products);
	}
	
	/**
	 * update all suppliers after delete supplier by id
	 * @param suppliers -> All suppliers
	 */
	@Override
	public void refreshSuppliers(List<Supplier> suppliers) {
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
	}

	@Override
	public void refreshBills(List<Bill> bills) {
		((BillAllPane) billAllPane).setBills(bills);
	}

	@Override
	public void refreshOrders(List<Order> orders) {
		((OrderAllPane) orderAllPane).setOrders(orders);
	}

	@Override
	public void goGenerateBill(Bill bill, List<Product> products) {
		((BillAllPane) billAllPane).setVisible(false);
		((GenerateBillPane) generateBillPane).setBill(bill);
		((GenerateBillPane) generateBillPane).setDetailsBill(new LinkedList<>());
		((GenerateBillPane) generateBillPane).setProducts(products);
		((GenerateBillPane) generateBillPane).setVisible(true);
	}

	@Override
	public void goGenerateOrder(Order order, List<Product> products) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((GenerateOrderPane) generateOrderPane).setOrder(order);
		((GenerateOrderPane) generateOrderPane).setDetailsOrder(new LinkedList<>());
		((GenerateOrderPane) generateOrderPane).setProducts(products);
		((GenerateOrderPane) generateOrderPane).setVisible(true);
	}

	@Override
	public void goToDetailBill(List<DetailBill> detailsBill, Bill bill) {
		((BillAllPane) billAllPane).setVisible(false);
		((DetailBillPane) detailBillPane).setBill(bill);
		((DetailBillPane) detailBillPane).setDetailsBill(detailsBill);
		((DetailBillPane) detailBillPane).setVisible(true);
	}

	@Override
	public void goToDetailOrder(List<DetailOrder> detailsOrder, Order order) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((DetailOrderPane) detailOrderPane).setOrder(order);
		((DetailOrderPane) detailOrderPane).setDetailsOrder(detailsOrder);
		((DetailOrderPane) detailOrderPane).setVisible(true);
	}

}

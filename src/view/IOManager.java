package view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import controller.Control;
import model.Bill;
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

public class IOManager extends JFrame implements CustomEventAnswer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@Override
	public void goToHomeFromSection(List<Product> products) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	@Override
	public void goToHomeFromProduct(List<Product> products) {
		((ProductAllPane) productAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	@Override
	public void goToHomeFromSupplier(List<Product> products) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	@Override
	public void goToHomeFromBill(List<Product> products) {
		((BillAllPane) billAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	@Override
	public void goToHomeFromOrder(List<Product> products) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((HomePane) homePane).setProducts(products);
		((HomePane) homePane).setVisible(true);
	}

	@Override
	public void goToSectionFromHome(List<Section> sections) {
		((HomePane) homePane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromProduct(List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromSupplier(List<Section> sections) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromBill(List<Section> sections) {
		((BillAllPane) billAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromOrder(List<Section> sections) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromHome(List<Product> products) {
		((HomePane) homePane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromSection(List<Product> products) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromSupplier(List<Product> products) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromBill(List<Product> products) {
		((BillAllPane) billAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromOrder(List<Product> products) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromHome(List<Supplier> suppliers) {
		((HomePane) homePane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromSection(List<Supplier> suppliers) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromProduct(List<Supplier> suppliers) {
		((ProductAllPane) productAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromBill(List<Supplier> suppliers) {
		((BillAllPane) billAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromOrder(List<Supplier> suppliers) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromHome(List<Bill> bills) {
		((HomePane) homePane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromSection(List<Bill> bills) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromProduct(List<Bill> bills) {
		((ProductAllPane) productAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromSupplier(List<Bill> bills) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromOrder(List<Bill> bills) {
		((OrderAllPane) orderAllPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromHome(List<Order> orders) {
		((HomePane) homePane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromSection(List<Order> orders) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromProduct(List<Order> orders) {
		((ProductAllPane) productAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromSupplier(List<Order> orders) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromBill(List<Order> orders) {
		((BillAllPane) billAllPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToCreateSection() {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((CreateSectionPane) createSectionPane).setVisible(true);
	}

	@Override
	public void goToCreateProduct(List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((CreateProductPane) createProductPane).setSections(sections);
		((CreateProductPane) createProductPane).setVisible(true);
	}

	@Override
	public void goToCreateSupplier() {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((CreateSupplierPane) createSupplierPane).setVisible(true);
	}

	@Override
	public void goToUpdateSection(Section section) {
		((SectionAllPane) sectionAllPane).setVisible(false);
		((UpdateSectionPane) updateSectionPane).setSection(section);
		((UpdateSectionPane) updateSectionPane).setVisible(true);
	}

	@Override
	public void goToUpdateProduct(Product product, List<Section> sections) {
		((ProductAllPane) productAllPane).setVisible(false);
		((UpdateProductPane) updateProductPane).setSections(sections);
		((UpdateProductPane) updateProductPane).setProduct(product);
		((UpdateProductPane) updateProductPane).setVisible(true);
	}

	@Override
	public void goToUpdateSupplier(Supplier supplier) {
		((SupplierAllPane) supplierAllPane).setVisible(false);
		((UpdateSupplierPane) updateSupplierPane).setSupplier(supplier);
		((UpdateSupplierPane) updateSupplierPane).setVisible(true);
	}
	
	@Override
	public void filteredSectionsResponse(List<Section> sections) {
		((SectionAllPane) sectionAllPane).setSections(sections);
	}

	@Override
	public void filteredProductsByNameResponse(List<Product> products) {
		((ProductAllPane) productAllPane).setProducts(products);
	}

	@Override
	public void filteredSuppliersBySupplierNameResponse(List<Supplier> suppliers) {
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
	}

	@Override
	public void goToSectionFromCreateSection(List<Section> sections) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromCreateSection(List<Product> products) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromCreateSection(List<Supplier> suppliers) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromCreateSection(List<Bill> bills) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromCreateSection(List<Order> orders) {
		((CreateSectionPane) createSectionPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromUpdateSection(List<Section> sections) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromUpdateSection(List<Product> products) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromUpdateSection(List<Supplier> suppliers) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromUpdateSection(List<Bill> bills) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromUpdateSection(List<Order> orders) {
		((UpdateSectionPane) updateSectionPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromCreateProduct(List<Section> sections) {
		((CreateProductPane) createProductPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromCreateProduct(List<Product> products) {
		((CreateProductPane) createProductPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromCreateProduct(List<Supplier> suppliers) {
		((CreateProductPane) createProductPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromCreateProduct(List<Bill> bills) {
		((CreateProductPane) createProductPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromCreateProduct(List<Order> orders) {
		((CreateProductPane) createProductPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromUpdateProduct(List<Section> sections) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}
	
	@Override
	public void goToProductFromUpdateProduct(List<Product> products) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromUpdateProduct(List<Supplier> suppliers) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromUpdateProduct(List<Bill> bills) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromUpdateProduct(List<Order> orders) {
		((UpdateProductPane) updateProductPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromCreateSupplier(List<Section> sections) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromCreateSupplier(List<Product> products) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromCreateSupplier(List<Supplier> suppliers) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromCreateSupplier(List<Bill> bills) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromCreateSupplier(List<Order> orders) {
		((CreateSupplierPane) createSupplierPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void goToSectionFromUpdateSupplier(List<Section> sections) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((SectionAllPane) sectionAllPane).setSections(sections);
		((SectionAllPane) sectionAllPane).setVisible(true);
	}

	@Override
	public void goToProductFromUpdateSupplier(List<Product> products) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((ProductAllPane) productAllPane).setProducts(products);
		((ProductAllPane) productAllPane).setVisible(true);
	}

	@Override
	public void goToSupplierFromUpdateSupplier(List<Supplier> suppliers) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
		((SupplierAllPane) supplierAllPane).setVisible(true);
	}

	@Override
	public void goToBillFromUpdateSupplier(List<Bill> bills) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((BillAllPane) billAllPane).setBills(bills);
		((BillAllPane) billAllPane).setVisible(true);
	}

	@Override
	public void goToOrderFromUpdateSupplier(List<Order> orders) {
		((UpdateSupplierPane) updateSupplierPane).setVisible(false);
		((OrderAllPane) orderAllPane).setOrders(orders);
		((OrderAllPane) orderAllPane).setVisible(true);
	}

	@Override
	public void refreshSections(List<Section> sections) {
		((SectionAllPane) sectionAllPane).setSections(sections);
	}

	@Override
	public void refreshProducts(List<Product> products) {
		((ProductAllPane) productAllPane).setProducts(products);
	}

	@Override
	public void refreshSuppliers(List<Supplier> suppliers) {
		((SupplierAllPane) supplierAllPane).setSuppliers(suppliers);
	}

}

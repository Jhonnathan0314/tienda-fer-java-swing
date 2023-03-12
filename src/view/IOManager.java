package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Control;
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
	public void isValidResponse(boolean isValid) {
		if(isValid) {
			((LoginPane) loginPane).setVisible(false);
			((HomePane) homePane).setVisible(true);
		}else {
			((LoginPane) loginPane).setValid(isValid);			
		}
	}

}

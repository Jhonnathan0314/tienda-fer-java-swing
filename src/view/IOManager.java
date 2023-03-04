package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Control;
import view.basic.HomePane;
import view.basic.LoginPane;
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
//		add(loginPane);
		
		homePane = new HomePane();
		homePane.setSize(dim);
		((HomePane) homePane).setEvent(control);
//		add(homePane);
		
		sectionAllPane = new SectionAllPane();
		sectionAllPane.setSize(dim);
		((SectionAllPane) sectionAllPane).setEvent(control);
//		add(sectionAllPane);
		
		createSectionPane = new CreateSectionPane();
		createSectionPane.setSize(dim);
		((CreateSectionPane) createSectionPane).setEvent(control);
//		add(createSectionPane);
		
		updateSectionPane = new UpdateSectionPane();
		updateSectionPane.setSize(dim);
		((UpdateSectionPane) updateSectionPane).setEvent(control);
//		add(updateSectionPane);
		
		productAllPane = new ProductAllPane();
		productAllPane.setSize(dim);
		((ProductAllPane) productAllPane).setEvent(control);
//		add(productAllPane);
		
		createProductPane = new CreateProductPane();
		createProductPane.setSize(dim);
		((CreateProductPane) createProductPane).setEvent(control);
//		add(createProductPane);
		
		updateProductPane = new UpdateProductPane();
		updateProductPane.setSize(dim);
		((UpdateProductPane) updateProductPane).setEvent(control);
//		add(updateProductPane);
		
		supplierAllPane = new SupplierAllPane();
		supplierAllPane.setSize(dim);
		((SupplierAllPane) supplierAllPane).setEvent(control);
//		add(supplierAllPane);
		
		createSupplierPane = new CreateSupplierPane();
		createSupplierPane.setSize(dim);
		((CreateSupplierPane) createSupplierPane).setEvent(control);
//		add(createSupplierPane);
		
		updateSupplierPane = new UpdateSupplierPane();
		updateSupplierPane.setSize(dim);
		((UpdateSupplierPane) updateSupplierPane).setEvent(control);
		add(updateSupplierPane);
	}

}

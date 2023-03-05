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
	}

	public CustomEventAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(CustomEventAnswer answer) {
		this.answer = answer;
	}
	
}

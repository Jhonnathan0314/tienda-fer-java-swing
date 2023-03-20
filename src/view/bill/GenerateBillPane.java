package view.bill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.CustomEvent;
import model.Bill;
import model.DetailBill;
import model.Product;
import view.table.RenderTable;

public class GenerateBillPane extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaracion de variables
	private JLabel logo;
	private JLabel background;
	private JLabel footerLbl;
	private JLabel containerLbl;
	private JLabel billContainerLbl;
	private JLabel billCodeLbl;
	private JLabel billDateLbl;
	private JLabel stockLbl;
	private JLabel totalValueLbl;
	
	private JTextField searchField;
	private JTextField searchStockField;

	private JComboBox<String> productsFindedField;

	private JButton sectionButton;
	private JButton productButton;
	private JButton supplierButton;
	private JButton billButton;
	private JButton orderButton;
	private JButton searchButton;
	private JButton addButton;
	private JButton cancelButton;
	private JButton generateButton;
	private JButton deleteButton;
	
	private ImageIcon image;
	private Icon icon;
	
	private JScrollPane scrollPane;
	private JTable table;

	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";
	private String deleteRoot = "src/img/delete.png";
	
	private Dimension dim;
	
	private Color greenButton = new Color(14, 150, 89);
	private Color redButton = new Color(255, 92, 92);
	private Color blueContainer = new Color(15, 51, 66);
	private Color lightGray = new Color(218, 218, 218);
	
	private Bill bill;
	private List<DetailBill> detailsBill = new LinkedList<>();
	private List<Product> products = new LinkedList<>();
	private Product productSelected;
	private DetailBill detailBill;

	private int column, row, idSelected;
	private float totalValue = 0;
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public GenerateBillPane() {
		setLayout(null);
		dim = super.getToolkit().getScreenSize();
		
		background = new JLabel("");
		background.setSize(dim);
		setImageLabel(background, backgroundRoot);
		add(background, 0);
		
		logo = new JLabel("");
		logo.setBounds(109, 80, 80, 80);
		setImageLabel(logo, logoRoot);
		add(logo, 0);
		
		sectionButton = new JButton("Secciones");
		sectionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sectionButton.setForeground(Color.WHITE);
		sectionButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		sectionButton.setBorder(new LineBorder(blueContainer, 1, true));
		sectionButton.setBackground(blueContainer);
		sectionButton.setBounds(29, 200, 234, 49);
		add(sectionButton, 0);
		
		productButton = new JButton("Productos");
		productButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productButton.setForeground(Color.WHITE);
		productButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		productButton.setBorder(new LineBorder(blueContainer, 1, true));
		productButton.setBackground(blueContainer);
		productButton.setBounds(29, 280, 234, 49);
		add(productButton, 0);
		
		supplierButton = new JButton("Proveedores");
		supplierButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supplierButton.setForeground(Color.WHITE);
		supplierButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		supplierButton.setBorder(new LineBorder(blueContainer, 1, true));
		supplierButton.setBackground(blueContainer);
		supplierButton.setBounds(29, 360, 234, 49);
		add(supplierButton, 0);
		
		billButton = new JButton("Facturas");
		billButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		billButton.setForeground(Color.WHITE);
		billButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		billButton.setBorder(new LineBorder(greenButton, 1, true));
		billButton.setBackground(greenButton);
		billButton.setBounds(29, 440, 234, 49);
		add(billButton, 0);
		
		orderButton = new JButton("Pedidos");
		orderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderButton.setForeground(Color.WHITE);
		orderButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		orderButton.setBorder(new LineBorder(blueContainer, 1, true));
		orderButton.setBackground(blueContainer);
		orderButton.setBounds(29, 520, 234, 49);
		add(orderButton, 0);
		
		containerLbl = new JLabel("<html><body><center>Generar factura</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 360, (int) dim.getHeight() - 320);
		containerLbl.setLocation(310, 70);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);
		
		billContainerLbl = new JLabel("");
		billContainerLbl.setBackground(Color.WHITE);
		billContainerLbl.setOpaque(true);
		billContainerLbl.setForeground(Color.BLACK);
		billContainerLbl.setSize((int) dim.getWidth() - 400, (int) dim.getHeight() - 390);
		billContainerLbl.setLocation(330, 120);
		billContainerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		billContainerLbl.setVerticalAlignment(SwingConstants.TOP);
		billContainerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(billContainerLbl, 0);
		
		billCodeLbl = new JLabel("Codigo factura: ####");
		billCodeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		billCodeLbl.setBounds(470, 144, 280, 33);
		add(billCodeLbl, 0);
		
		billDateLbl = new JLabel("Fecha: dd/mm/yyyy");
		billDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		billDateLbl.setBounds(1171, 144, 220, 33);
		add(billDateLbl, 0);
		
		searchField = new JTextField();
		searchField.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchField.setHorizontalAlignment(SwingConstants.CENTER);
		searchField.setBounds(440, 190, 803, 40);
		add(searchField, 0);
		
		searchButton = new JButton("Consultar");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchButton.setBackground(greenButton);
		searchButton.setBounds(1243, 190, 109, 40);
		searchButton.setActionCommand("search");
		searchButton.addActionListener(this);
		add(searchButton, 0);
		
		productsFindedField = new JComboBox<String>();
		productsFindedField.setBorder(new LineBorder(Color.GRAY, 1, true));
		productsFindedField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		productsFindedField.setBounds(440, 190, 803, 40);
		productsFindedField.addActionListener(this);
		productsFindedField.setActionCommand("product");
		add(productsFindedField, 0);
		productsFindedField.setVisible(false);
		
		stockLbl = new JLabel("Stock disponible: ");
		stockLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stockLbl.setBounds(490, 250, 220, 33);
		add(stockLbl, 0);
		
		searchStockField = new JTextField();
		searchStockField.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchStockField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchStockField.setHorizontalAlignment(SwingConstants.CENTER);
		searchStockField.setBounds(800, 250, 200, 35);
		add(searchStockField, 0);
		
		addButton = new JButton("Agregar");
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		addButton.setBackground(greenButton);
		addButton.setBounds(1163, 250, 129, 35);
		addButton.addActionListener(this);
		addButton.setActionCommand("add");
		add(addButton, 0);
		
		deleteButton = new JButton();
		deleteButton.setBackground(lightGray);
		deleteButton.setBorder(null);
		image = new ImageIcon(deleteRoot);
		icon = new ImageIcon(
				image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)
			);
		deleteButton.setIcon(icon);
		deleteButton.setName("delete");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 310, 1072, 180);
		scrollPane.setBorder(BorderFactory.createLineBorder(blueContainer));
		add(scrollPane, 0);
		
		table = new JTable();
		table.getTableHeader().setBackground(greenButton);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 19));
		table.getTableHeader().setBorder(new LineBorder(greenButton, 1, true));
		table.getTableHeader().setResizingAllowed(true);
		table.setBackground(lightGray);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(25);
		table.addMouseListener(this);
		
		totalValueLbl = new JLabel("Valor total: $" + totalValue);
		totalValueLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalValueLbl.setBounds(1240, 500, 200, 33);
		add(totalValueLbl, 0);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cancelButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		cancelButton.setBackground(redButton);
		cancelButton.setBounds(450, 530, 129, 40);
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("cancel");
		add(cancelButton, 0);
		
		generateButton = new JButton("Generar");
		generateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generateButton.setForeground(Color.WHITE);
		generateButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		generateButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		generateButton.setBackground(greenButton);
		generateButton.setBounds(1200, 530, 129, 40);
		generateButton.addActionListener(this);
		generateButton.setActionCommand("generate");
		add(generateButton, 0);
		
		footerLbl = new JLabel("<html><body><center>Creado por: <br>Jonatan Fernando Franco Cardenas<br>William Fernando Roa Vargas</center></body></html>");
		footerLbl.setBackground(blueContainer);
		footerLbl.setOpaque(true);
		footerLbl.setForeground(Color.WHITE);
		footerLbl.setSize((int) dim.getWidth(), 115);
		footerLbl.setLocation(0, 680);
		footerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		footerLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(footerLbl, 0);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(searchButton.getActionCommand())){
			if(searchButton.getText().equals("Consultar")) {
				updateFindedProducts();
			}else {
				productsFindedField.setVisible(false);
				searchButton.setText("Consultar");
				searchField.setText("");
				searchField.setVisible(true);
			}
		}
		if(e.getActionCommand().equals(productsFindedField.getActionCommand())) {
			productSelected = new Product();
			productSelected.setName(String.valueOf(productsFindedField.getSelectedItem()));
			for(int i = 0; i < products.size(); i++) {
				if(products.get(i).getName().equals(productSelected.getName())) {
					productSelected = products.get(i);
					i = products.size();
				}
			}
			stockLbl.setText("Stock disponible: " + productSelected.getQuantityAvailable());
		}
		if(e.getActionCommand().equals(addButton.getActionCommand())) {
			int quantitySelected = Integer.parseInt(searchStockField.getText());
			detailBill = new DetailBill();
			detailBill.setProduct(productSelected);
			detailBill.setQuantity(quantitySelected);
			detailBill.setUnitValue(productSelected.getSaleValue());
			detailBill.setTotalValue(productSelected.getSaleValue() * quantitySelected);
			detailBill.setBill(bill);
			detailsBill.add(detailBill);
			setDetailsBill(detailsBill);
			
			totalValue += detailBill.getTotalValue();

			for(int i = 0; i < products.size(); i++) {
				if(productSelected.getId() == products.get(i).getId()) {
					products.get(i).setQuantityAvailable(products.get(i).getQuantityAvailable() - quantitySelected);
					i = products.size();
				}
			}
			stockLbl.setText("Stock disponible: ");
			searchStockField.setText("");
			
			totalValueLbl.setText("Valor total: $" + totalValue);
			
			productsFindedField.setVisible(false);
			searchButton.setText("Consultar");
			searchField.setText("");
			searchField.setVisible(true);
		}
		if(e.getActionCommand().equals(cancelButton.getActionCommand())) {
			event.deleteBillById(bill.getId());
			event.goToBillFromGenerateBill();
		}
		if(e.getActionCommand().equals(generateButton.getActionCommand())) {
			event.generateDetailBill(detailsBill);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		column = table.getColumnModel().getColumnIndexAtX(e.getX());
		row = e.getY()/table.getRowHeight();
		if(column <= table.getColumnCount() && column >= 0 && row <= table.getRowCount() && row >= 0) {
			Object obj = table.getValueAt(row, column);
			if(obj instanceof JButton) {
				((JButton) obj).doClick();
				JButton botones = (JButton) obj;
				if(botones.getName().equals("delete")) {
					idSelected = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0)));
					for(int i = 0; i < detailsBill.size(); i++) {
						if(detailsBill.get(i).getProduct().getId() == idSelected) {
							for(int j = 0; j < products.size(); j++) {
								if(products.get(j).getId() == idSelected) {
									products.get(j).setQuantityAvailable(products.get(j).getQuantityAvailable() + detailsBill.get(i).getQuantity());
									stockLbl.setText("Stock disponible: ");
									searchStockField.setText("");

									totalValue -= detailsBill.get(i).getTotalValue();
									totalValueLbl.setText("Valor total: $" + totalValue);
									
									productsFindedField.setVisible(false);
									searchButton.setText("Consultar");
									searchField.setText("");
									searchField.setVisible(true);
									j = products.size();
								}
							}
							detailsBill.remove(i);
							setDetailsBill(detailsBill);
							i = detailsBill.size();
						}
					}
				}
			}
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
	private void setImageLabel(JLabel label, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(
			image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)
		);
		label.setIcon(icon);
		this.repaint();
	}


	public CustomEvent getEvent() {
		return event;
	}


	public void setEvent(CustomEvent event) {
		this.event = event;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;

		billCodeLbl.setText("Codigo factura: " + bill.getId());
		billDateLbl.setText("Fecha: " + bill.getDate());
		totalValueLbl.setText("Valor compra: $" + bill.getTotalValue());
	}

	public List<DetailBill> getDetailsBill() {
		return detailsBill;
	}

	public void setDetailsBill(List<DetailBill> detailsBill) {
		this.detailsBill = detailsBill;
		
		table.setDefaultRenderer(Object.class, new RenderTable());
		
		DefaultTableModel model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.setColumnIdentifiers(new String[] { "Id", "Producto", "Cantidad", "Valor unitario", "Valor total", "Eliminar" });

		for(int i = 0; i < detailsBill.size(); i++) {
			Object struct[] = { detailsBill.get(i).getProduct().getId(), detailsBill.get(i).getProduct().getName(), detailsBill.get(i).getQuantity(), detailsBill.get(i).getUnitValue(), detailsBill.get(i).getTotalValue(), deleteButton };
			model.addRow(struct);
		};

		table.setModel(model);

		scrollPane.setViewportView(table);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	private void updateFindedProducts() {
		List<Product> findedProducts = new LinkedList<>();
		String searchName = searchField.getText();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().toUpperCase().contains(searchName.toUpperCase())) {
				findedProducts.add(products.get(i));
			}
		}
		
		String[] productsObj = new String[findedProducts.size()];
		for(int i = 0; i < findedProducts.size(); i++) {
			productsObj[i] = findedProducts.get(i).getName();
		}
		DefaultComboBoxModel<String> sectionsComboBox = new DefaultComboBoxModel<String>(productsObj);
		productsFindedField.setModel(sectionsComboBox);
		
		searchField.setVisible(false);
		
		searchButton.setText("Volver");
		
		productsFindedField.setVisible(true);
		
		productSelected = new Product();
		productSelected.setName(String.valueOf(productsFindedField.getSelectedItem()));
		for(int i = 0; i < findedProducts.size(); i++) {
			if(findedProducts.get(i).getName().equals(productSelected.getName())) {
				productSelected = findedProducts.get(i);
				i = products.size();
			}
		}
		stockLbl.setText("Stock disponible: " + productSelected.getQuantityAvailable());
	}
}

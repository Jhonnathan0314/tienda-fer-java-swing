package view.order;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.CustomEvent;
import model.DetailOrder;
import model.Order;
import model.Product;
import view.table.RenderTable;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF5
 * @version V1 -> 20-04-2023
 */
public class GenerateOrderPane extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaracion de variables
	private JLabel logo;
	private JLabel background;
	private JLabel footerLbl;
	private JLabel containerLbl;
	private JLabel orderContainerLbl;
	private JLabel orderCodeLbl;
	private JLabel supplierLbl;
	private JLabel orderDateLbl;
	private JLabel orderedQuantityLbl;
	private JLabel receivedQuantityLbl;
	private JLabel unitValueLbl;
	private JLabel saleValueLbl;
	private JLabel totalValueLbl;
	
	private JTextField searchField;
	private JTextField orderedQuantityField;
	private JTextField receivedQuantityField;
	private JTextField unitValueField;
	private JTextField saleValueField;

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
	
	private List<DetailOrder> detailsOrder = new LinkedList<>();
	private Order order;
	private List<Product> products = new LinkedList<>();
	private Product productSelected;
	private DetailOrder detailOrder;
	
	private int column, row, idSelected;
	private float totalValue;
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public GenerateOrderPane() {
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
		billButton.setBorder(new LineBorder(blueContainer, 1, true));
		billButton.setBackground(blueContainer);
		billButton.setBounds(29, 440, 234, 49);
		add(billButton, 0);
		
		orderButton = new JButton("Pedidos");
		orderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderButton.setForeground(Color.WHITE);
		orderButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		orderButton.setBorder(new LineBorder(greenButton, 1, true));
		orderButton.setBackground(greenButton);
		orderButton.setBounds(29, 520, 234, 49);
		add(orderButton, 0);
		
		containerLbl = new JLabel("<html><body><center>Generar pedido</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 360, (int) dim.getHeight() - 280);
		containerLbl.setLocation(310, 50);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);
		
		orderContainerLbl = new JLabel("");
		orderContainerLbl.setBackground(Color.WHITE);
		orderContainerLbl.setOpaque(true);
		orderContainerLbl.setForeground(Color.BLACK);
		orderContainerLbl.setSize((int) dim.getWidth() - 400, (int) dim.getHeight() - 350);
		orderContainerLbl.setLocation(330, 100);
		orderContainerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		orderContainerLbl.setVerticalAlignment(SwingConstants.TOP);
		orderContainerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(orderContainerLbl, 0);
		
		orderCodeLbl = new JLabel("Codigo factura: ####");
		orderCodeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		orderCodeLbl.setBounds(470, 100, 280, 33);
		add(orderCodeLbl, 0);
		
		supplierLbl = new JLabel("Proveedor: {nombre del proveedor}");
		supplierLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supplierLbl.setBounds(740, 100, 280, 33);
		add(supplierLbl, 0);
		
		orderDateLbl = new JLabel("Fecha: dd/mm/yyyy");
		orderDateLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		orderDateLbl.setBounds(1171, 100, 220, 33);
		add(orderDateLbl, 0);
		
		searchField = new JTextField();
		searchField.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchField.setHorizontalAlignment(SwingConstants.CENTER);
		searchField.setBounds(440, 140, 803, 40);
		add(searchField, 0);
		
		searchButton = new JButton("Consultar");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchButton.setBackground(greenButton);
		searchButton.setBounds(1243, 140, 109, 40);
		searchButton.setActionCommand("search");
		searchButton.addActionListener(this);
		add(searchButton, 0);
		
		productsFindedField = new JComboBox<String>();
		productsFindedField.setBorder(new LineBorder(Color.GRAY, 1, true));
		productsFindedField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		productsFindedField.setBounds(440, 140, 803, 40);
		productsFindedField.addActionListener(this);
		productsFindedField.setActionCommand("product");
		add(productsFindedField, 0);
		productsFindedField.setVisible(false);
		
		orderedQuantityLbl = new JLabel("Cantidad pedida: ");
		orderedQuantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		orderedQuantityLbl.setBounds(440, 210, 220, 33);
		add(orderedQuantityLbl, 0);
		
		orderedQuantityField = new JTextField();
		orderedQuantityField.setBorder(new LineBorder(Color.GRAY, 1, true));
		orderedQuantityField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		orderedQuantityField.setHorizontalAlignment(SwingConstants.CENTER);
		orderedQuantityField.setBounds(600, 210, 160, 35);
		add(orderedQuantityField, 0);
		
		receivedQuantityLbl = new JLabel("Cantidad recibida: ");
		receivedQuantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		receivedQuantityLbl.setBounds(440, 260, 220, 33);
		add(receivedQuantityLbl, 0);
		
		receivedQuantityField = new JTextField();
		receivedQuantityField.setBorder(new LineBorder(Color.GRAY, 1, true));
		receivedQuantityField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		receivedQuantityField.setHorizontalAlignment(SwingConstants.CENTER);
		receivedQuantityField.setBounds(600, 260, 160, 35);
		add(receivedQuantityField, 0);
		
		unitValueLbl = new JLabel("Precio compra: ");
		unitValueLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		unitValueLbl.setBounds(780, 210, 220, 33);
		add(unitValueLbl, 0);
		
		unitValueField = new JTextField();
		unitValueField.setBorder(new LineBorder(Color.GRAY, 1, true));
		unitValueField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		unitValueField.setHorizontalAlignment(SwingConstants.CENTER);
		unitValueField.setBounds(940, 210, 160, 35);
		add(unitValueField, 0);
		
		saleValueLbl = new JLabel("Precio venta: ");
		saleValueLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saleValueLbl.setBounds(780, 260, 220, 33);
		add(saleValueLbl, 0);
		
		saleValueField = new JTextField();
		saleValueField.setBorder(new LineBorder(Color.GRAY, 1, true));
		saleValueField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		saleValueField.setHorizontalAlignment(SwingConstants.CENTER);
		saleValueField.setBounds(940, 260, 160, 35);
		add(saleValueField, 0);
		
		addButton = new JButton("Agregar");
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		addButton.setBackground(greenButton);
		addButton.setBounds(1163, 240, 129, 35);
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
		scrollPane.setBounds(360, 330, 1072, 180);
		scrollPane.setBorder(BorderFactory.createLineBorder(blueContainer));
		add(scrollPane, 0);
		
		table = new JTable();
		table.getTableHeader().setBackground(greenButton);
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 19));
		table.getTableHeader().setBorder(new LineBorder(greenButton, 1, true));
		table.getTableHeader().setResizingAllowed(true);
		table.setBackground(lightGray);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(25);
		table.addMouseListener(this);
		
		totalValueLbl = new JLabel("Valor total: ${variable}");
		totalValueLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalValueLbl.setBounds(1240, 515, 200, 33);
		add(totalValueLbl, 0);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cancelButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		cancelButton.setBackground(redButton);
		cancelButton.setBounds(450, 550, 129, 40);
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("cancel");
		add(cancelButton, 0);
		
		generateButton = new JButton("Generar");
		generateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generateButton.setForeground(Color.WHITE);
		generateButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		generateButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		generateButton.setBackground(greenButton);
		generateButton.setBounds(1200, 550, 129, 40);
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

	/**
	 * 	Method excecuted when a button with action listener is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(searchButton.getActionCommand())){
			if(searchButton.getText().equals("Consultar")) {
				if(searchField.getText().isEmpty()) {
					searchField.setBorder(new LineBorder(Color.RED, 3, true));
				}else {			
					searchField.setBorder(new LineBorder(Color.GRAY, 1, true));		
					updateFindedProducts();
				}
			}else {
				productsFindedField.setVisible(false);
				searchField.setBorder(new LineBorder(Color.GRAY, 1, true));
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
		}
		if(e.getActionCommand().equals(addButton.getActionCommand())) {
			boolean isFormValid = true;
			
			int orderedQuantitySelected = 0;
			if(validateNumberField(orderedQuantityField)) {				
				orderedQuantitySelected = Integer.parseInt(orderedQuantityField.getText());
				orderedQuantityField.setBorder(new LineBorder(Color.GRAY, 1, true));
			}else {
				isFormValid = false;
				orderedQuantityField.setText("");
				orderedQuantityField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			
			int receivedQuantitySelected = 0;
			if(validateNumberField(receivedQuantityField)) {				
				receivedQuantitySelected = Integer.parseInt(receivedQuantityField.getText());
				receivedQuantityField.setBorder(new LineBorder(Color.GRAY, 1, true));
			}else {
				isFormValid = false;
				receivedQuantityField.setText("");
				receivedQuantityField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			
			int unitValue = 0;
			if(validateNumberField(unitValueField)) {				
				unitValue = Integer.parseInt(unitValueField.getText());
				unitValueField.setBorder(new LineBorder(Color.GRAY, 1, true));
			}else {
				isFormValid = false;
				unitValueField.setText("");
				unitValueField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			
			int saleValue = 0;
			if(validateNumberField(saleValueField)) {				
				saleValue = Integer.parseInt(saleValueField.getText());
				saleValueField.setBorder(new LineBorder(Color.GRAY, 1, true));
				if(saleValue <= unitValue) {
					isFormValid = false;
					saleValueField.setBorder(new LineBorder(Color.ORANGE, 3, true));
				}
			}else {
				isFormValid = false;
				saleValueField.setText("");
				saleValueField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			
			if(isFormValid) {
				detailOrder = new DetailOrder();
				detailOrder.setProduct(productSelected);
				detailOrder.setOrderedQuantity(orderedQuantitySelected);
				detailOrder.setReceivedQuantity(receivedQuantitySelected);
				detailOrder.setUnitValue(unitValue);
				detailOrder.setTotalValue(unitValue * receivedQuantitySelected);
				detailOrder.setSaleValue(saleValue);
				detailOrder.setPercentageProfit(((detailOrder.getSaleValue() - detailOrder.getUnitValue()) / detailOrder.getUnitValue()) * 100);
				detailOrder.setOrder(order);
				detailsOrder.add(detailOrder);
				setDetailsOrder(detailsOrder);
				
				totalValue += detailOrder.getTotalValue();
				
				for(int i = 0; i < products.size(); i++) {
					if(productSelected.getId() == products.get(i).getId()) {
						products.get(i).setQuantityAvailable(products.get(i).getQuantityAvailable() + receivedQuantitySelected);
						products.get(i).setSaleValue(saleValue);
						i = products.size();
					}
				}
				orderedQuantityField.setText("");
				receivedQuantityField.setText("");
				unitValueField.setText("");
				saleValueField.setText("");
				
				totalValueLbl.setText("Valor total: $" + totalValue);
				
				productsFindedField.setVisible(false);
				searchButton.setText("Consultar");
				searchField.setText("");
				searchField.setVisible(true);
			}
			
		}
		if(e.getActionCommand().equals(cancelButton.getActionCommand())) {
			event.deleteOrderById(order.getId());
			event.goToOrderFromGenerateOrder();
		}
		if(e.getActionCommand().equals(generateButton.getActionCommand())) {
			if(detailsOrder.size() > 0) {				
				event.generateDetailOrder(detailsOrder);
			}else {
				JOptionPane.showMessageDialog(null, "NO PUEDE GENERAR UN PEDIDO VACIO, SI DESEA VOLVER, PRESIONE CANCELAR");
			}
		}
	}
	
	private boolean validateNumberField(JTextField field) {
		try {
			new BigInteger(field.getText());
			if(new BigInteger(field.getText()).intValue() > 0) {				
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 	Methods excecuted when persons do a click
	 */
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
					for(int i = 0; i < detailsOrder.size(); i++) {
						if(detailsOrder.get(i).getProduct().getId() == idSelected) {
							for(int j = 0; j < products.size(); j++) {
								if(products.get(j).getId() == idSelected) {
									products.get(j).setQuantityAvailable(products.get(j).getQuantityAvailable() - detailsOrder.get(i).getReceivedQuantity());
									orderedQuantityField.setText("");
									receivedQuantityField.setText("");
									unitValueField.setText("");
									saleValueField.setText("");

									totalValue -= detailsOrder.get(i).getTotalValue();
									totalValueLbl.setText("Valor total: $" + totalValue);
									
									productsFindedField.setVisible(false);
									searchButton.setText("Consultar");
									searchField.setText("");
									searchField.setVisible(true);
									j = products.size();
								}
							}
							detailsOrder.remove(i);
							setDetailsOrder(detailsOrder);
							i = detailsOrder.size();
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

	/**
	 * Method that put an image on a label
	 * @param label -> label object
	 * @param root -> image to put root
	 */
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
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
		
		orderCodeLbl.setText("Codigo pedido: " + order.getId());
		orderDateLbl.setText("Fecha: " + order.getDate());
		totalValueLbl.setText("Valor compra: $" + order.getTotalValue());
		supplierLbl.setText("Proveedor: " + order.getSupplier().getSupplierName());
	}

	public List<DetailOrder> getDetailsOrder() {
		return detailsOrder;
	}
	
	public void setDetailsOrder(List<DetailOrder> detailsOrder) {
		this.detailsOrder = detailsOrder;
		
		table.setDefaultRenderer(Object.class, new RenderTable());
		
		DefaultTableModel model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.setColumnIdentifiers(new String[] { "Id", "Producto", "Cantidad pedida", "Cantidad recibida", "Valor unitario", "Valor total", "Valor venta", "Ganacia %", "Eliminar" });

		for(int i = 0; i < detailsOrder.size(); i++) {
			Object struct[] = { detailsOrder.get(i).getProduct().getId(), detailsOrder.get(i).getProduct().getName(), detailsOrder.get(i).getOrderedQuantity(), detailsOrder.get(i).getReceivedQuantity(), detailsOrder.get(i).getUnitValue(), detailsOrder.get(i).getTotalValue(), detailsOrder.get(i).getSaleValue(), detailsOrder.get(i).getPercentageProfit()+"%", deleteButton };
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
	}
}

package view.supplier;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.CustomEvent;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF3
 * @version V1 -> @ 24-03-2023
 */
public class CreateSupplierPane extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables declaration
	private JLabel logo;
	private JLabel background;
	private JLabel footerLbl;
	private JLabel containerLbl;

	private JLabel supplierIdLabel;
	private JLabel supplierNameLabel;
	private JLabel sellerNameLabel;
	private JLabel phoneLabel;

	private JTextField supplierIdField;
	private JTextField supplierNameField;
	private JTextField sellerNameField;
	private JTextField phoneField;

	private JButton sectionButton;
	private JButton productButton;
	private JButton supplierButton;
	private JButton billButton;
	private JButton orderButton;
	private JButton createButton;

	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";

	private Dimension dim;
	
	private Color greenButton = new Color(14, 150, 89);
	private Color blueContainer = new Color(15, 51, 66);
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public CreateSupplierPane() {
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
		sectionButton.setActionCommand("sections");
		sectionButton.addActionListener(this);
		add(sectionButton, 0);

		productButton = new JButton("Productos");
		productButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productButton.setForeground(Color.WHITE);
		productButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		productButton.setBorder(new LineBorder(blueContainer, 1, true));
		productButton.setBackground(blueContainer);
		productButton.setBounds(29, 280, 234, 49);
		productButton.setActionCommand("products");
		productButton.addActionListener(this);
		add(productButton, 0);

		supplierButton = new JButton("Proveedores");
		supplierButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supplierButton.setForeground(Color.WHITE);
		supplierButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		supplierButton.setBorder(new LineBorder(blueContainer, 1, true));
		supplierButton.setBackground(greenButton);
		supplierButton.setBounds(29, 360, 234, 49);
		supplierButton.setActionCommand("suppliers");
		supplierButton.addActionListener(this);
		add(supplierButton, 0);

		billButton = new JButton("Facturas");
		billButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		billButton.setForeground(Color.WHITE);
		billButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		billButton.setBorder(new LineBorder(blueContainer, 1, true));
		billButton.setBackground(blueContainer);
		billButton.setBounds(29, 440, 234, 49);
		billButton.setActionCommand("bills");
		billButton.addActionListener(this);
		add(billButton, 0);

		orderButton = new JButton("Pedidos");
		orderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderButton.setForeground(Color.WHITE);
		orderButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		orderButton.setBorder(new LineBorder(blueContainer, 1, true));
		orderButton.setBackground(blueContainer);
		orderButton.setBounds(29, 520, 234, 49);
		orderButton.setActionCommand("orders");
		orderButton.addActionListener(this);
		add(orderButton, 0);
		
		containerLbl = new JLabel("<html><body><center>Crear proveedor</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 600, (int) dim.getHeight() - 370);
		containerLbl.setLocation(420, 130);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);
		
		supplierIdLabel = new JLabel("NIT o documento del proveedor");
		supplierIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supplierIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		supplierIdLabel.setForeground(Color.WHITE);
		supplierIdLabel.setBounds(675, 186, 415, 36);
		add(supplierIdLabel, 0);
		
		supplierIdField = new JTextField();
		supplierIdField.setBorder(new LineBorder(Color.WHITE, 1, true));
		supplierIdField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		supplierIdField.setHorizontalAlignment(SwingConstants.CENTER);
		supplierIdField.setBounds(675, 224, 415, 36);
		add(supplierIdField, 0);
		
		supplierNameLabel = new JLabel("Nombre del proveedor");
		supplierNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supplierNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		supplierNameLabel.setForeground(Color.WHITE);
		supplierNameLabel.setBounds(675, 270, 415, 36);
		add(supplierNameLabel, 0);
		
		supplierNameField = new JTextField();
		supplierNameField.setBorder(new LineBorder(Color.WHITE, 1, true));
		supplierNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		supplierNameField.setHorizontalAlignment(SwingConstants.CENTER);
		supplierNameField.setBounds(675, 308, 415, 36);
		add(supplierNameField, 0);
		
		sellerNameLabel = new JLabel("Nombre del vendedor");
		sellerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sellerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sellerNameLabel.setForeground(Color.WHITE);
		sellerNameLabel.setBounds(675, 354, 415, 36);
		add(sellerNameLabel, 0);
		
		sellerNameField = new JTextField();
		sellerNameField.setBorder(new LineBorder(Color.WHITE, 1, true));
		sellerNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sellerNameField.setHorizontalAlignment(SwingConstants.CENTER);
		sellerNameField.setBounds(675, 392, 415, 36);
		add(sellerNameField, 0);
		
		phoneLabel = new JLabel("Telefono");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setBounds(675, 438, 415, 36);
		add(phoneLabel, 0);
		
		phoneField = new JTextField();
		phoneField.setBorder(new LineBorder(Color.WHITE, 1, true));
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phoneField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneField.setBounds(675, 476, 415, 36);
		add(phoneField, 0);
		
		createButton = new JButton("Crear");
		createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createButton.setForeground(Color.WHITE);
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		createButton.setBorder(new LineBorder(greenButton, 1, true));
		createButton.setBackground(greenButton);
		createButton.setBounds(675, 544, 415, 36);
		createButton.setActionCommand("create");
		createButton.addActionListener(this);
		add(createButton, 0);
		
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
		if(e.getActionCommand().equals(sectionButton.getActionCommand())) {
			event.goToSectionFromCreateSupplier();
		}
		if(e.getActionCommand().equals(productButton.getActionCommand())) {
			event.goToProductFromCreateSupplier();
		}
		if(e.getActionCommand().equals(supplierButton.getActionCommand())) {
			event.goToSupplierFromCreateSupplier();
		}
		if(e.getActionCommand().equals(billButton.getActionCommand())) {
			event.goToBillFromCreateSupplier();
		}
		if(e.getActionCommand().equals(orderButton.getActionCommand())) {
			event.goToOrderFromCreateSupplier();
		}
		
		if(e.getActionCommand().equals(createButton.getActionCommand())) {
			boolean isFormValid = true;
			
			String supplierId = supplierIdField.getText();
			if(validateNumberField(supplierIdField)) {				
				supplierIdField.setBorder(new LineBorder(Color.WHITE, 1, true));
			}else {
				isFormValid = false;
				supplierIdField.setText("");
				supplierIdField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			
			String supplierName = supplierNameField.getText();
			if(supplierName.isEmpty()) {
				isFormValid = false;
				supplierNameField.setBorder(new LineBorder(Color.RED, 3, true));
			}else {
				supplierNameField.setBorder(new LineBorder(Color.WHITE, 1, true));
			}
			
			String sellerName = sellerNameField.getText();
			
			String phone = phoneField.getText();
			if(validateNumberField(phoneField)) {				
				phoneField.setBorder(new LineBorder(Color.WHITE, 1, true));
			}else {
				isFormValid = false;
				phoneField.setText("");
				phoneField.setBorder(new LineBorder(Color.RED, 3, true));
			}
			if(isFormValid) {
				event.createSupplier(supplierId, supplierName, sellerName, phone);
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
}

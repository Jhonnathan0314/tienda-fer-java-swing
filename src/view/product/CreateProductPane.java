package view.product;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.CustomEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateProductPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaracion de variables
	private JLabel logo;
	private JLabel background;
	private JLabel footerLbl;
	private JLabel containerLbl;
	
	private JLabel nameLabel;
	private JLabel quantityAvailableLabel;
	private JLabel saleValueLabel;
	private JLabel packagingLabel;
	private JLabel quantityPackagingLabel;
	private JLabel sectionLabel;
	
	private JTextField nameField;
	private JTextField quantityAvailableField;
	private JTextField saleValueField;
	private JTextField packagingField;
	private JTextField quantityPackagingField;
	
	private JComboBox<String> sectionField;

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
	public CreateProductPane() {
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
		productButton.setBorder(new LineBorder(greenButton, 1, true));
		productButton.setBackground(greenButton);
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
		orderButton.setBorder(new LineBorder(blueContainer, 1, true));
		orderButton.setBackground(blueContainer);
		orderButton.setBounds(29, 520, 234, 49);
		add(orderButton, 0);
		
		containerLbl = new JLabel("<html><body><center>Crear producto</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 600, (int) dim.getHeight() - 250);
		containerLbl.setLocation(420, 40);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);
		
		nameLabel = new JLabel("Nombre");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(675, 96, 415, 36);
		add(nameLabel, 0);
		
		nameField = new JTextField();
		nameField.setBorder(new LineBorder(Color.WHITE, 1, true));
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setBounds(675, 134, 415, 36);
		add(nameField, 0);
		
		quantityAvailableLabel = new JLabel("Cantidad disponible");
		quantityAvailableLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quantityAvailableLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		quantityAvailableLabel.setForeground(Color.WHITE);
		quantityAvailableLabel.setBounds(675, 180, 415, 36);
		add(quantityAvailableLabel, 0);
		
		quantityAvailableField = new JTextField();
		quantityAvailableField.setBorder(new LineBorder(Color.WHITE, 1, true));
		quantityAvailableField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		quantityAvailableField.setBounds(675, 218, 415, 36);
		add(quantityAvailableField, 0);
		
		saleValueLabel = new JLabel("Valor venta");
		saleValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saleValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		saleValueLabel.setForeground(Color.WHITE);
		saleValueLabel.setBounds(675, 264, 415, 36);
		add(saleValueLabel, 0);
		
		saleValueField = new JTextField();
		saleValueField.setBorder(new LineBorder(Color.WHITE, 1, true));
		saleValueField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		saleValueField.setBounds(675, 302, 415, 36);
		add(saleValueField, 0);
		
		packagingLabel = new JLabel("Empaque");
		packagingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		packagingLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		packagingLabel.setForeground(Color.WHITE);
		packagingLabel.setBounds(675, 348, 415, 36);
		add(packagingLabel, 0);
		
		packagingField = new JTextField();
		packagingField.setBorder(new LineBorder(Color.WHITE, 1, true));
		packagingField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		packagingField.setBounds(675, 386, 415, 36);
		add(packagingField, 0);
		
		quantityPackagingLabel = new JLabel("Cantidad empaque");
		quantityPackagingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quantityPackagingLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		quantityPackagingLabel.setForeground(Color.WHITE);
		quantityPackagingLabel.setBounds(675, 432, 415, 36);
		add(quantityPackagingLabel, 0);
		
		quantityPackagingField = new JTextField();
		quantityPackagingField.setBorder(new LineBorder(Color.WHITE, 1, true));
		quantityPackagingField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		quantityPackagingField.setBounds(675, 470, 415, 36);
		add(quantityPackagingField, 0);
		
		sectionLabel = new JLabel("Seccion");
		sectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sectionLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sectionLabel.setForeground(Color.WHITE);
		sectionLabel.setBounds(675, 516, 415, 36);
		add(sectionLabel, 0);
		
		sectionField = new JComboBox<String>();
		sectionField.setModel(new DefaultComboBoxModel<String>(new String[] {"Comida", "Bebida", "Prueba"}));
		sectionField.setBorder(new LineBorder(Color.WHITE, 1, true));
		sectionField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sectionField.setBounds(675, 554, 415, 36);
		add(sectionField, 0);
		
		createButton = new JButton("Crear");
		createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createButton.setForeground(Color.WHITE);
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		createButton.setBorder(new LineBorder(greenButton, 1, true));
		createButton.setBackground(greenButton);
		createButton.setBounds(675, 600, 415, 36);
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

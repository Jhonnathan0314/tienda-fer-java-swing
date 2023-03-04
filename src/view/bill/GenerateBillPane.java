package view.bill;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.CustomEvent;
import view.ImageCellRenderer;

public class GenerateBillPane extends JPanel {
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

	private JButton sectionButton;
	private JButton productButton;
	private JButton supplierButton;
	private JButton billButton;
	private JButton orderButton;
	private JButton searchButton;
	private JButton addButton;
	private JButton cancelButton;
	private JButton generateButton;
	
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
		searchField.setBounds(440, 190, 863, 40);
		add(searchField, 0);
		
		searchButton = new JButton("Consultar");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		searchButton.setBackground(greenButton);
		searchButton.setBounds(1243, 190, 109, 40);
		add(searchButton, 0);
		
		stockLbl = new JLabel("Stock disponible: {variable}");
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
		add(addButton, 0);
		
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null}
			},
			new String[] {
				"Producto", "Cantidad", "Valor unitario", "Valor total", "Eliminar"
			}
		));
		table.getColumnModel().getColumn(4).setCellRenderer(new ImageCellRenderer(deleteRoot));
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		scrollPane.setViewportView(table);
		
		totalValueLbl = new JLabel("Valor total: ${variable}");
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
		add(cancelButton, 0);
		
		generateButton = new JButton("Generar");
		generateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generateButton.setForeground(Color.WHITE);
		generateButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		generateButton.setBorder(new LineBorder(Color.GRAY, 1, true));
		generateButton.setBackground(greenButton);
		generateButton.setBounds(1200, 530, 129, 40);
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

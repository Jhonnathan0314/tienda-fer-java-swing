package view.basic;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.CustomEvent;
import model.Product;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HomePane extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Declaracion de variables
	private JLabel logo;
	private JLabel background;
	private JLabel footerLbl;
	private JLabel containerLbl;

	private JButton sectionButton;
	private JButton productButton;
	private JButton supplierButton;
	private JButton billButton;
	private JButton orderButton;

	private JScrollPane scrollPane;
	private JTable table;

	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";

	private Dimension dim;

	private Color greenButton = new Color(14, 150, 89);
	private Color blueContainer = new Color(15, 51, 66);
	private Color lightGray = new Color(218, 218, 218);

	List<Product> products = new ArrayList<>();

	private CustomEvent event;

	/**
	 * Create the panel.
	 */
	public HomePane() {
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
		supplierButton.setBackground(blueContainer);
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

		containerLbl = new JLabel("<html><body><center>Productos escasos</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 360, (int) dim.getHeight() - 280);
		containerLbl.setLocation(310, 70);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 150, 1072, 450);
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
		if(e.getActionCommand().equals(sectionButton.getActionCommand())) {
			event.goToSectionFromHome();
		}
		if(e.getActionCommand().equals(productButton.getActionCommand())) {
			event.goToProductFromHome();
		}
		if(e.getActionCommand().equals(supplierButton.getActionCommand())) {
			event.goToSupplierFromHome();
		}
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] { },
				new String[] {
						"Nombre", "Empaque", "Candidad disponible", "Precio", "Seccion"
				}
		) {
			private static final long serialVersionUID = 1L;

			@Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
		};
		for(Product product : products) {
			model.addRow(new Object[] {
					product.getName(), product.getPackaging(), product.getQuantityAvailable(), "$ " + ((int) product.getSaleValue()), product.getSection().getName()
			});
		}
		table.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
		scrollPane.setViewportView(table);
	}

}

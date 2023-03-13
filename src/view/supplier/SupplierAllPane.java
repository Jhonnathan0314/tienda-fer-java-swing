package view.supplier;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.CustomEvent;
import model.Supplier;
import view.ButtonCellRenderer;

public class SupplierAllPane extends JPanel implements ActionListener, MouseListener {
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
	private JButton searchButton;
	private JButton createButton;
	
	private JTextField searchField;

	private JScrollPane scrollPane;
	private JTable table;

	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";
	private String updateRoot = "src/img/update.png";
	private String deleteRoot = "src/img/delete.png";

	private Dimension dim;
	
	private Color greenButton = new Color(14, 150, 89);
	private Color blueContainer = new Color(15, 51, 66);
	private Color lightGray = new Color(218, 218, 218);
	
	private List<Supplier> suppliers = new LinkedList<>();
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public SupplierAllPane() {
		setLayout(null);
		dim = super.getToolkit().getScreenSize();
		
		background = new JLabel("");
		background.setSize(dim);
		setImageLabel(background, backgroundRoot);
		add(background, 0);
		
		logo = new JLabel("");
		logo.setBounds(109, 80, 80, 80);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setImageLabel(logo, logoRoot);
		logo.addMouseListener(this);
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
		
		containerLbl = new JLabel("<html><body><center>Proveedores</center></body></html>");
		containerLbl.setBackground(blueContainer);
		containerLbl.setOpaque(true);
		containerLbl.setForeground(Color.WHITE);
		containerLbl.setSize((int) dim.getWidth() - 360, (int) dim.getHeight() - 280);
		containerLbl.setLocation(310, 70);
		containerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		containerLbl.setVerticalAlignment(SwingConstants.TOP);
		containerLbl.setFont(new Font("Tahoma", Font.PLAIN, 38));
		add(containerLbl, 0);
		
		searchField = new JTextField();
		searchField.setBorder(new LineBorder(Color.WHITE, 1, true));
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchField.setHorizontalAlignment(SwingConstants.CENTER);
		searchField.setBounds(360, 140, 903, 40);
		add(searchField, 0);
		
		searchButton = new JButton("Consultar");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		searchButton.setBorder(new LineBorder(greenButton, 1, true));
		searchButton.setBackground(greenButton);
		searchButton.setBounds(1263, 140, 169, 40);
		searchButton.setActionCommand("search");
		searchButton.addActionListener(this);
		add(searchButton, 0);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 200, 1072, 350);
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
		
		createButton = new JButton("Crear");
		createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		createButton.setForeground(Color.WHITE);
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		createButton.setBorder(new LineBorder(greenButton, 1, true));
		createButton.setBackground(greenButton);
		createButton.setBounds(800, 580, 169, 40);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(sectionButton.getActionCommand())) {
			event.goToSectionFromSupplier();
		}
		if(e.getActionCommand().equals(productButton.getActionCommand())) {
			event.goToProductFromSupplier();
		}
		if(e.getActionCommand().equals(billButton.getActionCommand())) {
			event.goToBillFromSupplier();
		}
		if(e.getActionCommand().equals(orderButton.getActionCommand())) {
			event.goToOrderFromSupplier();
		}
		
		if(e.getActionCommand().equals(searchButton.getActionCommand())) {
			String searchName = searchField.getText();
			event.udpateFilterSuppliers(searchName);
		}
		if(e.getActionCommand().equals(createButton.getActionCommand())) {
			event.goToCreateSupplier();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		event.goToHomeFromSupplier();
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

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] { },
				new String[] {
						"Id", "Nombre proveedor", "Nombre vendedor", "Telefono", "Actualizar", "Eliminar"
				}
		) {
			private static final long serialVersionUID = 1L;

			@Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
		};
		
		table.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		ButtonCellRenderer updateButtonRenderer = new ButtonCellRenderer(updateRoot);
		ButtonCellRenderer deleteButtonRenderer = new ButtonCellRenderer(deleteRoot);
		for(int i = 0; i < suppliers.size(); i++) {
			model.addRow(new Object[] {
					suppliers.get(i).getId(), suppliers.get(i).getSupplierName(), suppliers.get(i).getSellerName(), suppliers.get(i).getPhone(), updateButtonRenderer, deleteButtonRenderer
			});
		};
		table.getColumn("Actualizar").setCellRenderer(updateButtonRenderer);
		table.getColumn("Eliminar").setCellRenderer(deleteButtonRenderer);
		scrollPane.setViewportView(table);
	}
}

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
import model.Bill;
import view.table.RenderTable;

/**
 * @author JONATAN FRANCO
 * @author WILLIAM ROA
 * @apiNote RF4
 * @version V1 -> 20-04-2023
 */
public class BillAllPane extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variables declaration
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
	private JButton generateButton;
	private JButton detailButton;
	private JButton deleteButton;
	
	private ImageIcon image;
	private Icon icon;
	
	private JTextField searchField;

	private JScrollPane scrollPane;
	private JTable table;

	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";
	private String viewRoot = "src/img/view.png";
	private String deleteRoot = "src/img/delete.png";

	private Dimension dim;
	
	private Color greenButton = new Color(14, 150, 89);
	private Color blueContainer = new Color(15, 51, 66);
	private Color lightGray = new Color(218, 218, 218);
	
	private List<Bill> bills = new LinkedList<>();
	
	private int column, row, idSelected;
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public BillAllPane() {
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
		supplierButton.setActionCommand("suppliers");
		supplierButton.addActionListener(this);
		add(supplierButton, 0);

		billButton = new JButton("Facturas");
		billButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		billButton.setForeground(Color.WHITE);
		billButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		billButton.setBorder(new LineBorder(blueContainer, 1, true));
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
		orderButton.setActionCommand("orders");
		orderButton.addActionListener(this);
		add(orderButton, 0);
		
		containerLbl = new JLabel("<html><body><center>Facturas</center></body></html>");
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
		add(searchButton, 0);
		
		detailButton = new JButton();
		detailButton.setBackground(lightGray);
		detailButton.setBorder(null);
		image = new ImageIcon(viewRoot);
		icon = new ImageIcon(
			image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)
		);
		detailButton.setIcon(icon);
		detailButton.setName("view");
		
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
		table.addMouseListener(this);
		
		generateButton = new JButton("Generar");
		generateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		generateButton.setForeground(Color.WHITE);
		generateButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		generateButton.setBorder(new LineBorder(greenButton, 1, true));
		generateButton.setBackground(greenButton);
		generateButton.setBounds(800, 580, 169, 40);
		generateButton.setActionCommand("generate");
		generateButton.addActionListener(this);
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
		if(e.getActionCommand().equals(sectionButton.getActionCommand())) {
			event.goToSectionFromBill();
		}
		if(e.getActionCommand().equals(productButton.getActionCommand())) {
			event.goToProductFromBill();
		}
		if(e.getActionCommand().equals(supplierButton.getActionCommand())) {
			event.goToSupplierFromBill();
		}
		if(e.getActionCommand().equals(orderButton.getActionCommand())) {
			event.goToOrderFromBill();
		}
		
		if(e.getActionCommand().equals(generateButton.getActionCommand())) {
			event.goGenerateBill();
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
				if(botones.getName().equals("view")) {
					idSelected = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0)));
					event.viewDetailBill(idSelected);
				}
				if(botones.getName().equals("delete")) {
					idSelected = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0)));
					event.deleteBillById(idSelected);
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

	//Get and sets methods
	public CustomEvent getEvent() {
		return event;
	}

	public void setEvent(CustomEvent event) {
		this.event = event;
	}

	public List<Bill> getBills() {
		return bills;
	}

	/**
	 * Method that put into the table bills received
	 * @param bills -> Bills received
	 */
	public void setBills(List<Bill> bills) {
		this.bills = bills;
		
		table.setDefaultRenderer(Object.class, new RenderTable());
		
		DefaultTableModel model = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		model.setColumnIdentifiers(new String[] {"Id", "Fecha", "Valor total", "Detalle", "Eliminar"});

		for(int i = 0; i < bills.size(); i++) {
			Object struct[] = { bills.get(i).getId(), bills.get(i).getDate(), bills.get(i).getTotalValue(), detailButton, deleteButton };
			model.addRow(struct);
		};

		table.setModel(model);

		scrollPane.setViewportView(table);
	}
}

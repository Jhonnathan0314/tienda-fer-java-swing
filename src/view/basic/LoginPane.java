package view.basic;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.CustomEvent;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;

public class LoginPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Declaracion de variables
	private JLabel logo;
	private JLabel background;
	private JLabel userLbl;
	private JLabel passwordLbl;
	private JLabel footerLbl;
	
	private JTextField userField;
	private JPasswordField passwordField;

	private JButton loginButton; 
	
	private String logoRoot = "src/img/logoTienda.png";
	private String backgroundRoot = "src/img/fondoPrincipal.png";

	private Dimension dim;
	
	private Color greenButton = new Color(14, 150, 89);
	private Color footer = new Color(15, 51, 66);
	
	private CustomEvent event;
		
	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setLayout(null);
		dim = super.getToolkit().getScreenSize();
		
		background = new JLabel("");
		background.setSize(dim);
		System.out.println(dim.toString());
		setImageLabel(background, backgroundRoot);
		add(background, 0);
		
		logo = new JLabel("");
		logo.setBounds(706, 100, 150, 150);
		setImageLabel(logo, logoRoot);
		add(logo, 0);
		
		userLbl = new JLabel("Usuario");
		userLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		userLbl.setBounds(660, 264, 241, 37);
		add(userLbl, 0);
		
		userField = new JTextField();
		userField.setBorder(new LineBorder(Color.WHITE, 1, true));
		userField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userField.setHorizontalAlignment(SwingConstants.CENTER);
		userField.setBounds(641, 320, 279, 49);
		add(userField, 0);
		
		passwordLbl = new JLabel("Contraseña");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordLbl.setBounds(660, 389, 241, 37);
		add(passwordLbl, 0);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		passwordField.setBounds(641, 445, 279, 49);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		add(passwordField, 0);
		
		loginButton = new JButton("Ingresar");
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		loginButton.setBorder(new LineBorder(greenButton, 1, true));
		loginButton.setBackground(greenButton);
		loginButton.setBounds(641, 532, 279, 49);
		add(loginButton, 0);
		
		footerLbl = new JLabel("<html><body><center>Creado por: <br>Jonatan Fernando Franco Cardenas<br>William Fernando Roa Vargas</center></body></html>");
		footerLbl.setBackground(footer);
		footerLbl.setOpaque(true);
		footerLbl.setForeground(Color.WHITE);
		footerLbl.setSize((int) dim.getWidth(), 150);
		footerLbl.setLocation(0, 644);
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

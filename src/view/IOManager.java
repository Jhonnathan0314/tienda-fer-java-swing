package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Control;
import view.basic.HomePane;
import view.basic.LoginPane;
import view.section.CreateSectionPane;
import view.section.SectionAllPane;
import view.section.UpdateSectionPane;

public class IOManager extends JFrame implements CustomEventAnswer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension dim;
	
	private LoginPane loginPane;
	private HomePane homePane;
	
	private SectionAllPane sectionAllPane;
	private CreateSectionPane createSectionPane;
	private UpdateSectionPane updateSectionPane;

	/**
	 * Create the frame.
	 */
	public IOManager() {
		Control control = new Control();
		control.setAnswer(this);
		
		dim = super.getToolkit().getScreenSize();
		
		setTitle("Tienda doña Lola");
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(dim);
		
		loginPane = new LoginPane();
		loginPane.setSize(dim);
		((LoginPane) loginPane).setEvent(control);
//		add(loginPane);
		
		homePane = new HomePane();
		homePane.setSize(dim);
		((HomePane) homePane).setEvent(control);
//		add(homePane);
		
		sectionAllPane = new SectionAllPane();
		sectionAllPane.setSize(dim);
		((SectionAllPane) sectionAllPane).setEvent(control);
//		add(sectionAllPane);
		
		createSectionPane = new CreateSectionPane();
		createSectionPane.setSize(dim);
		((CreateSectionPane) createSectionPane).setEvent(control);
//		add(createSectionPane);
		
		updateSectionPane = new UpdateSectionPane();
		updateSectionPane.setSize(dim);
		((UpdateSectionPane) updateSectionPane).setEvent(control);
		add(updateSectionPane);
	}

}

/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author JONATAN FRANCO
 *
 */
public class ImageCellRenderer extends DefaultTableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JLabel label = new JLabel();
    private String imageRoot;
    
    public ImageCellRenderer(String imageRoot) {
    	this.imageRoot = imageRoot;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        
    	label.setSize(30, 30);
    	setImageLabel();
    	return label;
    }
    
	private void setImageLabel() {
		ImageIcon image = new ImageIcon(imageRoot);
		Icon icon = new ImageIcon(
			image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)
		);
		label.setIcon(icon);
		label.repaint();
	}
	
}

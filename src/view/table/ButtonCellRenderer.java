/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * @author JONATAN FRANCO
 *
 */
public class ButtonCellRenderer extends JButton implements TableCellRenderer {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String imageRoot;
    
    public ButtonCellRenderer(String imageRoot) {
    	this.imageRoot = imageRoot;
    	setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // Configurar el botón
    	setSize(30, 30);
        setText("");
        setBorderPainted(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
        setImageLabel();
        return this;
    }
    
    private void setImageLabel() {
		ImageIcon image = new ImageIcon(imageRoot);
		Icon icon = new ImageIcon(
			image.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)
		);
		setIcon(icon);
		repaint();
	}
}

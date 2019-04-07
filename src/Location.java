
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class Location extends JLabel implements MouseMotionListener{
	
	public Location(MyCanvas cv) {
		cv.addMouseMotionListener(this);
		setText(" ");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setText("¸¶¿ì½º ÁÂÇ¥ [ " + e.getX() + " , "+ e.getY() + " ]");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setText("¸¶¿ì½º ÁÂÇ¥ [ " + e.getX() + " , "+ e.getY() + " ]");
	}
}

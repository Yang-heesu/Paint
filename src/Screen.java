import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame{

	static int f_width = 1024;
	static int f_height = 720;
	
	JFrame frame = this; 
	
	public Screen() {
		init();
	}
	
	public void init() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Draw_Icon.png");
		setIconImage(img);
		
		setTitle("±×¸²ÆÇ"); 
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(f_width,f_height));
		setLocationRelativeTo(null);
		
		JPanel cp = new JPanel();
		cp.setBackground(Color.lightGray);
		cp.setLayout(null);
		MyCanvas cv = new MyCanvas(cp);
		
		Menubar mb = new Menubar(cv);
		Toolbar tb = new Toolbar(cv);
		Location ln = new Location(cv);
		
		add(cp);
		add(mb,BorderLayout.NORTH);
		add(ln,BorderLayout.SOUTH);
		add(tb,BorderLayout.WEST);
		
		pack();
		setVisible(true);
	}
	
}

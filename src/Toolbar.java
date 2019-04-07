import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Toolbar extends JPanel{
	ImageIcon T_pen = new ImageIcon("img/Pen.png");
	ImageIcon T_line = new ImageIcon("img/Line.png");
	ImageIcon T_oval = new ImageIcon("img/Oval.png");
	ImageIcon T_rect = new ImageIcon("img/Rect.png");
	ImageIcon T_eraser = new ImageIcon("img/Eraser.png");
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	MyCanvas cv;
	
	public Toolbar(MyCanvas cv) {
		this.cv = cv;
		setLayout(gbl);
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(5,3,5,3); //top, left, bottom, right
//		gbc.weightx = 1.0;
//		gbc.weighty = 1.0;
		
		JLabel tool = new JLabel("Tool");
		
		JButton pen = new JButton(T_pen);
		pen.setPreferredSize(new Dimension(35, 35));
		kind_change(pen, 1);
		
		JButton line = new JButton(T_line);
		line.setPreferredSize(new Dimension(35, 35));
		kind_change(line, 2);
		
		JButton oval = new JButton(T_oval);
		oval.setPreferredSize(new Dimension(35, 35));
		kind_change(oval, 3);
		
		JButton rect = new JButton(T_rect);
		rect.setPreferredSize(new Dimension(35, 35));
		kind_change(rect, 4);
		
		JButton eraser = new JButton(T_eraser);
		eraser.setPreferredSize(new Dimension(35, 35));
		kind_change(eraser, 5);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner pen_size = new JSpinner(sm);
		pen_size.setPreferredSize(new Dimension(50, 20));
		size_change(pen_size);
		
		g_add(tool,0,0,1,1);
		g_add(pen, 0,1,1,1);
		g_add(line, 1,1,1,1);
		g_add(oval, 0,2,1,1);
		g_add(rect,1,2,1,1);
		g_add(eraser,0,3,1,1);
		g_add(pen_size,0,4,2,1);
		
		JLabel color = new JLabel("Color");
		
		JButton red = new JButton();
		red.setPreferredSize(new Dimension(25, 25));
		red.setBackground(Color.RED);
		color_change(red, Color.RED);
		
		JButton orange = new JButton();
		orange.setPreferredSize(new Dimension(25, 25));
		orange.setBackground(Color.ORANGE);
		color_change(orange, Color.ORANGE);
		
		JButton magenta = new JButton();
		magenta.setPreferredSize(new Dimension(25, 25));
		magenta.setBackground(Color.MAGENTA);
		color_change(magenta, Color.MAGENTA);
		
		JButton pink = new JButton();
		pink.setPreferredSize(new Dimension(25, 25));
		pink.setBackground(Color.PINK);
		color_change(pink, Color.PINK);
		
		JButton yellow = new JButton();
		yellow.setPreferredSize(new Dimension(25, 25));
		yellow.setBackground(Color.YELLOW);
		color_change(yellow, Color.YELLOW);
		
		JButton blue = new JButton();
		blue.setPreferredSize(new Dimension(25, 25));
		blue.setBackground(Color.BLUE);
		color_change(blue, Color.BLUE);
		
		JButton cyan = new JButton();
		cyan.setPreferredSize(new Dimension(25, 25));
		cyan.setBackground(Color.CYAN);
		color_change(cyan, Color.CYAN);
		
		JButton green = new JButton();
		green.setPreferredSize(new Dimension(25, 25));
		green.setBackground(Color.GREEN);
		color_change(green, Color.GREEN);
		
		JButton black = new JButton();
		black.setPreferredSize(new Dimension(25, 25));
		black.setBackground(Color.BLACK);
		color_change(black, Color.BLACK);
		
		JButton gray = new JButton();
		gray.setPreferredSize(new Dimension(25, 25));
		gray.setBackground(Color.GRAY);
		color_change(gray, Color.GRAY);
		
		JButton lightgray = new JButton();
		lightgray.setPreferredSize(new Dimension(25, 25));
		lightgray.setBackground(Color.LIGHT_GRAY);
		color_change(lightgray, Color.LIGHT_GRAY);
		
		JButton darkgray = new JButton();
		darkgray.setPreferredSize(new Dimension(25, 25));
		darkgray.setBackground(Color.DARK_GRAY);
		color_change(darkgray, Color.DARK_GRAY);
		
		JButton other = new JButton("´Ù¸¥ »ö");
		other.setPreferredSize(new Dimension(80, 25));
		other.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser Colorchooser = new JColorChooser();
				Color selectedColor = Colorchooser.showDialog(null, "Color",
						Color.YELLOW);
				cv.pen_color_change(selectedColor);
				
			}
		});
		
		g_add(color,0,5,1,1);
		g_add(red,0,6,1,1);
		g_add(magenta,1,6,1,1);
		g_add(pink,0,7,1,1);
		g_add(orange,1,7,1,1);
		g_add(yellow,0,8,1,1);
		g_add(green,1,8,1,1);
		g_add(blue,0,9,1,1);
		g_add(cyan,1,9,1,1);
		g_add(black,0,10,1,1);
		g_add(darkgray,1,10,1,1);
		g_add(gray,0,11,1,1);
		g_add(lightgray,1,11,1,1);
		g_add(other,0,12,2,1);
		g_weight_add(new JLabel("¡¡"),0,13,1,1,1,1);
	}
	
	public void kind_change(JButton obj, int num) {
		obj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cv.pen_kind_change(num);
				cv.pen_kind();
			}
		});
	}
	
	public void size_change(JSpinner obj) {
		obj.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = (int)obj.getValue();
				cv.pen_size_change(value);
				cv.pen_size();
			}
		});
	}
	
	public void color_change(JButton obj, Color color) {
		obj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cv.pen_color_change(color);
				cv.pen_color();
			}
		});
	}
	
	public void g_add(Component obj, int x, int y, int width, int height) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		add(obj,gbc);
	}
	
	public void g_weight_add(Component obj, int x, int y, int width, int height, int weightx, int weighty) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		add(obj,gbc);
	}
}

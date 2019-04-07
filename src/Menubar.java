
import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Menubar extends JMenuBar{
	private MyCanvas cv;
	
	private String fileFilters[][]= {
			{".jpg", "jpg"},
			{".png", "png"},
			{".gif", "gif"}
	};
	

	JFileChooser chooser = new JFileChooser();
	String filename = null;
	
	public Menubar(MyCanvas cv) {
		this.cv = cv;
		
		 for(int i=0; i<fileFilters.length; i++){
               chooser.addChoosableFileFilter(new FileNameExtensionFilter(fileFilters[i][0], fileFilters[i][1]));
           }
		 
		New_Dialog dialog = new New_Dialog(cv);
		Info_Dialog dialog2 = new Info_Dialog();
		
		
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
		
		JMenu file = new JMenu("파일");
		JMenuItem f_new = new JMenuItem("새로만들기");
		JMenuItem f_save = new JMenuItem("저장");
		JMenuItem f_load = new JMenuItem("열기");
		JMenuItem f_exit = new JMenuItem("닫기");
		file.add(f_new);
		file.add(f_save);
		file.add(f_load);
		file.addSeparator();
		file.add(f_exit);
		
		f_new.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.pack();
				dialog.setVisible(true);
			}
		});
		
		f_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.setMultiSelectionEnabled(false);
				int ret = chooser.showSaveDialog(cv);
				if (ret != JFileChooser.APPROVE_OPTION) {
					return;
				}
				File f1 = chooser.getSelectedFile();
				String des = chooser.getFileFilter().getDescription();
				System.out.println(des);
				String Ext = null;
				String fullPath = f1.getAbsolutePath();
				
				if(des == fileFilters[0][0]) Ext = "jpg";
				else if(des== fileFilters[1][0]) Ext = "png";
				else Ext = "gif";
				
				File f2 = new File(fullPath+"."+Ext);
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(f2);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		f_load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser.setMultiSelectionEnabled(false);
				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();
				ImageIcon img = new ImageIcon(filePath);
				cv.setIcon(img);
				cv.setSize(img.getIconWidth(), img.getIconHeight());
			}
		});
		
		f_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cv.repaint();
				cv.revalidate();
				cv.setVisible(false);
			}
		});
		
		JMenu creater = new JMenu("제작자");
		creater.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {

				dialog2.pack();
				dialog2.setVisible(true);
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(file);
		add(creater);
	}

}

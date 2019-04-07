import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

class Size_Dialog extends JDialog {
	private Size_Dialog dialog;
	
	public Size_Dialog(MyCanvas cv) {
		super();

		dialog = this;
		
		int cv_width = cv.getWidth();
		int cv_height = cv.getHeight();
		
		System.out.println("ũ��ٲٴ� â �� ��");
		
		setLayout(new GridLayout(4, 3)); // Dialog�� ���̾ƿ� ����
		setPreferredSize(new Dimension(320, 200));
		setResizable(false);

		JLabel info = new JLabel("���� �ִ�  1500, ");
		JLabel info2 = new JLabel("���� �ִ�  900");
		JLabel info3 = new JLabel(" ���� ����");
		
		JLabel text_width = new JLabel("����");
		JLabel text_height = new JLabel("����");
	
		JLabel px = new JLabel("  px");
		JLabel px2 = new JLabel("  px");
		
		SpinnerModel x_sm = new SpinnerNumberModel(cv_width, 1, 1500, 1);
		SpinnerModel y_sm = new SpinnerNumberModel(cv_height, 1, 900, 1);
		JSpinner width = new JSpinner(x_sm);
		JSpinner height = new JSpinner(y_sm);
		
		JLabel left = new JLabel("��");
		JLabel right = new JLabel("��");
		JButton button = new JButton("�ٲٱ�");
		
		add(info); add(info2); add(info3); 
		add(text_width); add(width); add(px);
		add(text_height); add(height); add(px2);
		add(left); add(button); add(right);
		
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = (int)width.getValue();
				int y = (int)height.getValue();
				
				cv.setVisible(true);
				cv.setSize(x,y);
				dispose();
			}
		});
	}
}
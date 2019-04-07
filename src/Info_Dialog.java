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
import javax.swing.SwingConstants;

class Info_Dialog extends JDialog {
	private Info_Dialog dialog;
	
	public Info_Dialog() {
		super();

		dialog = this;
		
		System.out.println("ªı√¢∂‰ §ª");
		
		setLayout(new GridLayout(4, 1)); // Dialog¿« ∑π¿Ãæ∆øÙ º≥¡§
		setPreferredSize(new Dimension(320, 200));
		setResizable(false);

		JLabel info1 = new JLabel("°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·");
		JLabel info2 = new JLabel("°·°·°·°·°·°·°·°·°·¡¶¿€¿⁄ : æÁ»Òºˆ°·°·°·°·°·°·°·°·°·");
		JLabel info3 = new JLabel("°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·°·");
		
		JButton button = new JButton("¥›±‚");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setVerticalAlignment(SwingConstants.CENTER);
		
		add(info1); add(info2); add(info3); 
		add(button);
		
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
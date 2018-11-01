package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements ActionListener {
	JButton btnStart=new JButton("시작");
	JButton btnInfo=new JButton("설명");
	
	public MainFrame() {
		setTitle("Catch Minions!");
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JLabel lbl = new JLabel("Catch Minions!", JLabel.CENTER);
		JLabel lbl2 =new JLabel(new ImageIcon("imgs/mino.gif"));
		JLabel lbl3 =new JLabel("");
		JLabel lbl4 =new JLabel("");
		pan.setBackground(new Color(10,117,188));
		pan2.setBackground(new Color(10,117,188));
		pan3.setBackground(new Color(10,117,188));
		lbl.setFont(new Font("Calibri", Font.BOLD, 110));
		lbl.setForeground(new Color(252,224,41));
		pan3.add(lbl);
		add(pan3,"North");
		add(pan,"Center");
		pan.setLayout(new GridLayout(1, 2));
		pan2.setLayout(new GridLayout(4, 2, 30, 20));
		pan.add(lbl2);
		pan.add(pan2);
		pan2.add(lbl3);
		pan2.add(lbl4);
		pan2.add(btnStart);
		pan2.add(btnInfo);
		
		btnStart.setBackground(new Color(252,224,41));
		btnStart.setFont(new Font("고딕", Font.BOLD, 40));
		btnStart.setForeground(new Color(10,117,188));
		btnStart.addActionListener(this);
		
		btnInfo.setBackground(new Color(252,224,41));
		btnInfo.setFont(new Font("고딕", Font.BOLD, 40));
		btnInfo.setForeground(new Color(10,117,188));
		btnInfo.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 100, 800, 700);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eBtn=e.getSource();
		if(eBtn==btnStart){
			setVisible(false);
			new CatchFrame(MainFrame.this);
		}else {
			new SendAlert();
		}
	}

}
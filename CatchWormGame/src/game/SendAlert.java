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


public class SendAlert extends JFrame implements ActionListener {
	JButton btnOk=new JButton("확인");
	JButton btnOk2=new JButton("확인");
	MainFrame mainFrame;
	
	public SendAlert() {
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JLabel lbl = new JLabel("게임방법!", JLabel.CENTER);
		JLabel lbl2 = new JLabel("마우스로 미니언을 잡는 게임 입니다.", JLabel.CENTER);
		JLabel lbl3 =new JLabel(new ImageIcon("imgs/item0.png"));
		JLabel lbl4 = new JLabel("시간 5초 추가 아이템", JLabel.CENTER);
		JLabel lbl5 =new JLabel(new ImageIcon("imgs/item1.png"));
		JLabel lbl6 = new JLabel("미니언 속도를 감소하는 아이템", JLabel.CENTER);
		setTitle("게임방법!");
		pan.setBackground(new Color(10,117,188));
		pan2.setBackground(new Color(10,117,188));
		pan3.setBackground(new Color(10,117,188));
		lbl.setFont(new Font("고딕", Font.BOLD, 25));
		lbl.setForeground(new Color(252,224,41));
		lbl2.setFont(new Font("고딕", Font.BOLD, 25));
		lbl2.setForeground(new Color(252,224,41));
		lbl4.setFont(new Font("고딕", Font.BOLD, 20));
		lbl4.setForeground(new Color(252,224,41));
		lbl6.setFont(new Font("고딕", Font.BOLD, 20));
		lbl6.setForeground(new Color(252,224,41));
		pan.setLayout(new GridLayout(2, 1));
		pan.add(lbl);
		pan.add(lbl2);
		pan2.setLayout(new GridLayout(2, 2));
		pan2.add(lbl3);
		pan2.add(lbl4);
		pan2.add(lbl5);
		pan2.add(lbl6);
		pan3.add(btnOk2);
		add(pan,"North");
		add(pan2);
		add(pan3,"South");
		btnOk2.setBackground(new Color(252,224,41));
		btnOk2.setFont(new Font("고딕", Font.BOLD, 20));
		btnOk2.setForeground(new Color(10,117,188));
		btnOk2.addActionListener(this);
		setBounds(600, 100, 800, 700);
		setVisible(true);
	}
	
	public SendAlert(String title,String send_Str,MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel(title, JLabel.CENTER);
		JLabel lbl2 = new JLabel(send_Str, JLabel.CENTER);
		JLabel lbl3 =new JLabel("");
		setTitle(title);
		pan.setBackground(new Color(10,117,188));
		pan2.setBackground(new Color(10,117,188));
		lbl.setFont(new Font("고딕", Font.BOLD, 20));
		lbl.setForeground(new Color(252,224,41));
		lbl2.setFont(new Font("고딕", Font.BOLD, 20));
		lbl2.setForeground(new Color(252,224,41));
		pan.setLayout(new GridLayout(4, 1));
		pan.add(lbl3);
		pan.add(lbl3);
		pan.add(lbl);
		pan.add(lbl2);
		pan2.add(btnOk);
		add(pan);
		add(pan2,"South");
		btnOk.setBackground(new Color(252,224,41));
		btnOk.setFont(new Font("고딕", Font.BOLD, 18));
		btnOk.setForeground(new Color(10,117,188));
		btnOk.addActionListener(this);
		setBounds(800, 300, 300, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object eBtn=e.getSource();
		if(eBtn==btnOk){
			mainFrame.setVisible(true);
			dispose();
		}else {
			dispose();
		}
	}

}
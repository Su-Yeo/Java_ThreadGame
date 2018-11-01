package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CatchPaper extends JPanel implements Runnable{

	String imgName="minion1";
	ArrayList<Worm> Worm_List = new ArrayList<Worm>();
	ArrayList<Item> Item_List = new ArrayList<Item>();
	Worm worm;
	Item item;
	JLabel jl;
	Score score;
	int wormCnt=10;
	
	public CatchPaper(Score score ) {
		this.score = score;
		setLayout(null);
		jl = new JLabel(new ImageIcon("imgs/m.gif"));
		add(jl);
		
		addMouseListener(listener);
		Random random = new Random();
		for (int i = 0; i < wormCnt; i++) {
			int x=random.nextInt(400);
			int y=random.nextInt(400);
			int rl=random.nextInt(2);
			int ud=random.nextInt(2);
			worm = new Worm(x, y, rl, ud, imgName);
			Worm_List.add(worm);
		}
		for (int i = 0; i < 1; i++) {
			int x=random.nextInt(400);
			int y=random.nextInt(400);
			int f=random.nextInt(2);
			item = new Item(x, y, f);
			Item_List.add(item);
		}
	}
	
	MouseAdapter listener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			for (int i = 0; i < Worm_List.size(); ++i ){ 
				worm = (Worm)(Worm_List.get(i));
				if(e.getX()<=worm.getX()+124&&e.getX()>=worm.getX()) {
					if(e.getY()<=worm.getY()+133&&e.getY()>=worm.getY()) {
						removeWram(i, e.getX(), e.getY());
						score.setWormCnt(wormCnt-(Worm_List.size()));
					}
				}
			}
			for (int i = 0; i < Item_List.size(); ++i ){ 
				item = (Item)(Item_List.get(i));
				if(e.getX()<=item.getX()+80&&e.getX()>=item.getX()) {
					if(e.getY()<=item.getY()+80&&e.getY()>=item.getY()) {
						Item_List.remove(i);
						if(item.getFlag()==0) {
							score.setF(true);
						}else {
							score.setSpeed(600);
						}
					}
				}
			}
		}
	};

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("imgs/"+imgName+".gif");
		Image bg = tool.getImage("imgs/bg.jpg");
		g.drawImage(bg, 0, 0, null);
		for (int i = 0 ; i < Worm_List.size() ; ++i ){
			worm = (Worm)(Worm_List.get(i));
			g.drawImage(img, worm.getX(), worm.getY(), this);
		}
		Image img2 = tool.getImage("imgs/item"+item.getFlag()+".png");
		for (int i = 0 ; i < Item_List.size() ; ++i ){
			item = (Item)(Item_List.get(i));
			g.drawImage(img2, item.getX(), item.getY(), this);
		}
	}
	public void removeWram(int i, int x, int y) {
		//jl.setBounds(x, y, 50, 50);
		Worm_List.remove(i);
	}
	public void WormProcess(){
		for (int i = 0 ; i < Worm_List.size() ; ++i ){ 
			worm = (Worm)(Worm_List.get(i));
			worm.move();
		}
	}
		
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(score.getSpeed());
				
				WormProcess();
				if(Worm_List.isEmpty()) { 
					jl.setVisible(false);
					return;
				}
				if(score.getTime()==0) {
					return;
				}
				
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

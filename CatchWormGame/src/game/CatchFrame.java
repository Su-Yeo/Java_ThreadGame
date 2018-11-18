package game;


import javax.swing.JFrame;


public class CatchFrame extends JFrame{
	MainFrame mainFrame;
	public CatchFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		Score score = new Score();
		StopWatch st = new StopWatch(10,score, CatchFrame.this, mainFrame);
		add(st,"North");
		CatchPaper paper = new CatchPaper(score);
		add(paper,"Center");
		setTitle("Catch Minions!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(600, 100, 800, 700);
		setVisible(true);
		setResizable(false);
		Thread t1 = new Thread(paper);
		t1.start();  
	}

}

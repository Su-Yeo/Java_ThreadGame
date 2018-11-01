package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatch extends JPanel{

	int sec;
	JLabel jl;
	JLabel jl2;
	Score score;
	CatchFrame catchFrame;
	MainFrame mainFrame;
	
	public StopWatch(int second, Score score, CatchFrame catchFrame, MainFrame mainFrame) {
		this.score = score;
		this.catchFrame = catchFrame;
		this.mainFrame = mainFrame;
		sec = second*10;
		JPanel jp = new JPanel();
		setBackground(new Color(10,117,188));
		jp.setBackground(new Color(10,117,188));
		jp.setLayout(new GridLayout(1, 2, 200, 0));
		jl = new JLabel("남은 시간 : "+Integer.toString(sec/10)+"초");
		jl2 = new JLabel("잡은 수 : "+Integer.toString(score.getWormCnt()));
		jp.add(jl);
		jp.add(jl2);
		add(jp);
		jl.setFont(new Font("고딕", Font.BOLD, 25));
		jl.setForeground(new Color(252,224,41));
		jl2.setForeground(new Color(252,224,41));
		jl2.setFont(new Font("고딕", Font.BOLD, 25));
		timer();
	}
	
	public void timer() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				if(score.isF()) {
					sec+=50;
					score.setF(false);
				}
				sec-=1;
				score.setTime(sec/10);
				jl.setText("남은 시간 : "+Integer.toString(sec/10)+"초");
				int cnt = score.getWormCnt();
				jl2.setText("잡은 수 : "+Integer.toString(cnt));
				score.setTime(sec/10);
				if(cnt==10) {
					timer.cancel();
					score.setTime(sec/10);
					new SendAlert("GAME CLEAR!",score.toString(),mainFrame);
					catchFrame.setVisible(false);
					return;
				}
				if(sec==0) {
					timer.cancel();
					new SendAlert("TIME OVER! ",score.toString(),mainFrame);
					catchFrame.setVisible(false);
					return;
				}
			}
		};
		timer.schedule(task, 1000, 100);
	}
}

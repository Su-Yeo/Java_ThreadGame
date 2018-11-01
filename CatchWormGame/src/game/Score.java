package game;

public class Score {

	private int wormCnt=0;
	private int time=999;
	private int speed=300;
	private boolean f;
	
	public int getWormCnt() {
		return wormCnt;
	}
	public void setWormCnt(int wormCnt) {
		this.wormCnt = wormCnt;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isF() {
		return f;
	}
	public void setF(boolean f) {
		this.f = f;
	}
	@Override
	public String toString() {
		int score = wormCnt*10+time*10;
		return "Score : " + score;
	}
	
}

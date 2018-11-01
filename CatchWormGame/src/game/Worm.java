package game;

public class Worm {
	private String imgName;
	private int x, y;
	private int flagRL,flagUD;
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Worm(int x, int y, int flagRL, int flagUD, String imgName){
		this.x = x;
		this.y = y;
		this.flagRL=flagRL;
		this.flagUD=flagUD;
		this.imgName=imgName;
	}
	public void move(){
		if(x<=0) {
			flagRL=0;
		}else if(x>=680) {
			flagRL=1;
		}else if(y<=0) {
			flagUD=0;
		}else if(y>=480) {
			flagUD=1;
		}
			
		if(flagRL==0) {
			x+=10;
		}else if(flagRL==1){
			x-=10;
		}
		if(flagUD==0) {
			y+=10;
		}else if(flagUD==1){
			y-=10;
		}
	}
}

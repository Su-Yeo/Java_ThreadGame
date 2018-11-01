package game;

public class Item {
	private int x, y, flag;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getFlag() {
		return flag;
	}

	public Item(int x, int y, int flag){
		this.x = x;
		this.y = y;
		this.flag = flag;
	}
}

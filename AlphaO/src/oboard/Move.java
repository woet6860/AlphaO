package oboard;
import otypes.Point;

public class Move {
    public Point point;
	public boolean is_play;
	public boolean is_pass;
	public boolean is_resign;	
	
	public	 Move(){
		
		assert (point != null ) ^ is_pass ^ is_resign;
		this.point = null;
		this.is_play = (this.point != null);
		this.is_pass = false;
		this.is_resign = false;
	
	}
	public void play(Point point){
		this.point = point;
	}
	
	public void pass_turn(){
		this.is_pass = true;
	}
	
	public void resign() {
		this.is_resign = true;
	}
	 

}

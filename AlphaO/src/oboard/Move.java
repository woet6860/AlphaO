package oboard;
import otypes.Point;

public class Move {
    public Point point = null;
	public boolean is_play;
	public boolean is_pass = false;
	public boolean is_resign = false;	
	
	public Move(Point point, boolean is_pass, boolean is_resign){
		
		assert (point != null ) ^ is_pass ^ is_resign;
		this.point = point;
		this.is_play = (this.point != null);
		this.is_pass = is_pass;
		this.is_resign = is_resign;
	
	}

	public Move play(Point points){
		Move move = new Move(points, false, false);
		return move;
          

	}
	
	public Move pass_turn(){
		Move move = new Move(null, true ,false);
		return move;
	}
	
	public Move resign() {
		Move move = new Move(null, false, true);
        return move;
	}
	 

}

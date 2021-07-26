package oboard;
import otypes.Point;
import otypes.Player;
import oboard.Ostring;
import java.util.ArrayList;

public class Board {
	int num_raws;
	int num_cols;
	
	private Board() {
		this.num_raws = num_raws;
		this.num_cols = num_cols;
		
	}
	
	public void place_stone(Player player, Point point) {
		assert this.is_on_grid(point);
		assert Point._grid.get(point) == null;
		ArrayList<Point> adjacent_same_color = new ArrayList<>();
        ArrayList<Point> adjacent_opposite_color = new ArrayList<>();
        
		//URLL
		for(Point neighbor:point.neighbor_URLL) {
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
		    Integer neighbor_URLL_String = Point._grid.get(neighbor);
		    if(neighbor_URLL_String == Player.stone.value){
		    	adjacent_same_color.add(neighbor);
		    }
		  Ostring new_string_URLL = new Ostring(Player.stone.value,adjacent_same_color );
		
		}
		////////
		
		////////
		
		
		
	}
   public boolean is_on_grid(Point point) {
	  return 1 <= point.raw && point.raw<= this.num_raws && 1 <= point.col && point.col<= this.num_cols;
   }
}

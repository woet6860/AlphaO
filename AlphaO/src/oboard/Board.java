package oboard;
import otypes.Point;
import otypes.Player;
import oboard.Ostring;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public class Board {
	int num_raws;
	int num_cols;
    public Map<Point, Player>_grid = new HashMap<>();	
	private Board() {
		this.num_raws = num_raws;
		this.num_cols = num_cols;
		this._grid = _grid;
		
	}
	
	public void place_stone(Player player, Point point) {
		assert this.is_on_grid(point);
		assert this._grid.get(point) == null;
		
		
        //HashSet<Point> adjacent_same_color_ULRL = new HashSet<>();
    	HashSet<Point> adjacent_same_color_URLL = new HashSet<>();
    
    	//adjacent_same_color_ULRL.add(point);
    	HashSet<Point> liberties_URLL = new HashSet<>(); 
    	
    	///Ostring ostring_ULRL;// '\'
		//URLL
		for(Point neighbor:point.neighbor_URLL) {
			
		    
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
			Ostring neighbor_string = new Ostring(Player, );
			
            neighbor_string.color = this._grid.get(neighbor);
			
			if(neighbor_string.color == null) {
				liberties_URLL.add(neighbor);
			}
			else if(neighbor_string.color == player) {
				if(adjacent_same_color_URLL.contains(neighbor_string) == false) {			
             adjacent_same_color_URLL.addAll(neighbor_string.stones);}                
			}
		}
		
		HashSet<Point> URLL_Point = new HashSet<>();
		Ostring ostring_URLL = new Ostring(player,URLL_Point ,liberties_URLL);
		Ostring same_color_string;
		
		while(adjacent_same_color_URLL.contains(same_color_string.stones)){
			ostring_URLL = ostring_URLL.merged_with(same_color_string);
		}
			
		
	

		
		////////////
		
		////////
		
	
		
	}
	public Player get(Point point) {
        Player string = this._grid.get(point) ;
		if(string == null) {
			return null;
		}
		return string;
		
	}
	
    public Ostring get_ostring(Point point) {
    	Ostring string = this._grid
    }
	
	
	
   public boolean is_on_grid(Point point) {
	  return 1 <= point.raw && point.raw<= this.num_raws && 1 <= point.col && point.col<= this.num_cols;
   }
}

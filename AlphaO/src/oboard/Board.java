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
    public Map<Point, Integer>_grid = new HashMap<>();	
	private Board() {
		this.num_raws = num_raws;
		this.num_cols = num_cols;
		this._grid = _grid;
		
	}
	
	public void place_stone(Player player, Point point) {
		assert this.is_on_grid(point);
		assert this._grid.get(point) == null;
		
		
        HashSet<Point> adjacent_same_color_ULRL = new HashSet<>();
    	HashSet<Point> adjacent_same_color_URLL = new HashSet<>();
    
    	adjacent_same_color_ULRL.add(point);
    	HashSet<Point> liberties_URLL = new HashSet<>(); 
    	
    	Ostring ostring_ULRL;// '\'
		//URLL
		for(Point neighbor:point.neighbor_URLL) {
			
		    
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
            Integer neighbor_URLL_Point = this._grid.get(neighbor);
			
			if(neighbor_URLL_Point == null) {
				liberties_URLL.add(neighbor);
			}
			else if(neighbor_URLL_Point == Player.stone.value) {
				
             adjacent_same_color_URLL.add(neighbor);
             
                 
			}
		}
		HashSet<Point> URLL_Point = new HashSet<>();
		Ostring ostring_URLL = new Ostring(Player.stone.value,URLL_Point ,liberties_URLL);
		for(Point x: adjacent_same_color_URLL) {
			
		}
			
		
	

		
		////////////
		
		////////
		
	
		
	}
	public Integer get_value(Point point) {
		Integer string = this._grid.get(point) ;
		if(string == null) {
			return null;
		}
		return string;
		
	}
	
    public Ostring get_ostring(Point point) {
    	Ostring string = this._grid.
    }
	
	
	
   public boolean is_on_grid(Point point) {
	  return 1 <= point.raw && point.raw<= this.num_raws && 1 <= point.col && point.col<= this.num_cols;
   }
}

package oboard;
import otypes.Point;
import otypes.Player;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public class Board implements Cloneable {
	public int num_rows;
	int num_cols;
    public static Map<Point, Ostring[]>_grid = new HashMap<>();
    
    public Board(int num_rows, int num_cols) {
    	this.num_rows = num_rows;
    	this.num_cols = num_cols;
    }
    
    @Override
    protected Board clone() throws CloneNotSupportedException{
    	return (Board) super.clone();
    } 
	
	public void place_stone(Player player, Point point) {
		assert this.is_on_grid(point);
		assert get_Player(point) == null;
		
		HashSet<Ostring> adjacent_same_color_URLL = new HashSet<>();
		HashSet<Ostring> adjacent_same_color_ULRL = new HashSet<>();
        HashSet<Ostring> adjacent_same_color_HORIZON = new HashSet<>();
        HashSet<Ostring> adjacent_same_color_VERTICAL = new HashSet<>();
    	
    
    	HashSet<Point> liberties_URLL = new HashSet<>();
    	HashSet<Point> liberties_ULRL = new HashSet<>(); 
    	HashSet<Point> liberties_HORIZON = new HashSet<>(); 
    	HashSet<Point> liberties_VERTICAL = new HashSet<>(); 
    	
    	HashSet<Ostring> adjacent_opposite_color_URLL = new HashSet<>();
    	HashSet<Ostring> adjacent_opposite_color_ULRL = new HashSet<>();
    	HashSet<Ostring> adjacent_opposite_color_HORIZON = new HashSet<>();
    	HashSet<Ostring> adjacent_opposite_color_VERTICAL = new HashSet<>();

		//URLL
		for(Point neighbor:point.neighbor_URLL) {
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
			Ostring neighbor_string = _grid.get(neighbor)[0];		
			if(neighbor_string.color == null) {
				liberties_URLL.add(neighbor);
			}
			else if(neighbor_string.color == player) {
			if(adjacent_same_color_URLL.contains(neighbor_string) == false) {
             adjacent_same_color_URLL.add(neighbor_string);}                
			}
	     	else {if(adjacent_opposite_color_URLL.contains(neighbor_string) == false) {
	     		adjacent_opposite_color_URLL.add(neighbor_string);
	        	}
		    	
		    }
		}
		HashSet<Point> new_stones_URLL = new HashSet<>();
		new_stones_URLL.add(point);
        Ostring new_string_URLL = new Ostring(player,new_stones_URLL, liberties_URLL);	
		for(Ostring same_color_string : adjacent_same_color_URLL) {
        	new_string_URLL = new_string_URLL.merged_with(same_color_string);
        }
		for(Ostring opposite_string:adjacent_opposite_color_URLL) {
			opposite_string.remove_liberty(point);
		}
		
		//URLL-END
		
		//ULRL
		for(Point neighbor:point.neighbor_ULRL){
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
			Ostring neighbor_string = _grid.get(neighbor)[1];		
			if(neighbor_string.color == null) {
				liberties_ULRL.add(neighbor);
			}
			else if(neighbor_string.color == player) {
			if(adjacent_same_color_ULRL.contains(neighbor_string) == false) {
             adjacent_same_color_ULRL.add(neighbor_string);}                
			}
	     	else {if(adjacent_opposite_color_ULRL.contains(neighbor_string) == false) {
	     		adjacent_opposite_color_ULRL.add(neighbor_string);
		    	
		        }
		    }
		}
		HashSet<Point> new_stones_ULRL = new HashSet<>();
		new_stones_ULRL.add(point);
        Ostring new_string_ULRL = new Ostring(player,new_stones_ULRL, liberties_ULRL);	
		for(Ostring same_color_string : adjacent_same_color_ULRL) {
        	new_string_ULRL = new_string_ULRL.merged_with(same_color_string);
        }
		for(Ostring opposite_string : adjacent_opposite_color_ULRL) {
			opposite_string.remove_liberty(point);
		}
		//ULRL-END
		
		//HORIZON
		for(Point neighbor:point.neighbor_HORIZON) {
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
			Ostring neighbor_string = _grid.get(neighbor)[2];		
			if(neighbor_string.color == null) {
				liberties_HORIZON.add(neighbor);
			}
			else if(neighbor_string.color == player) {
			if(adjacent_same_color_HORIZON.contains(neighbor_string) == false) {
             adjacent_same_color_HORIZON.add(neighbor_string);}                
			}
	     	else {if(adjacent_opposite_color_HORIZON.contains(neighbor_string) == false) {
	     		adjacent_opposite_color_HORIZON.add(neighbor_string);
		    	
		        }
	    	}
		}
		HashSet<Point> new_stones_HORIZON = new HashSet<>();
		new_stones_HORIZON.add(point);
        Ostring new_string_HORIZON = new Ostring(player,new_stones_HORIZON, liberties_HORIZON);	
		for(Ostring same_color_string : adjacent_same_color_HORIZON) {
        	new_string_HORIZON = new_string_HORIZON.merged_with(same_color_string);
        }
		for(Ostring opposite_string : adjacent_opposite_color_HORIZON) {
			opposite_string.remove_liberty(point);
		}
		//HORIZON-END
		
		//VERTICAL
		for(Point neighbor:point.neighbor_VERTICAL) {
			if(this.is_on_grid(neighbor) == false) {
				continue;
			}
			Ostring neighbor_string = _grid.get(neighbor)[3];		
			if(neighbor_string.color == null) {
				liberties_VERTICAL.add(neighbor);
			}
			else if(neighbor_string.color == player) {
			if(adjacent_same_color_VERTICAL.contains(neighbor_string) == false) {
             adjacent_same_color_VERTICAL.add(neighbor_string);}                
			}
	     	else {if(adjacent_opposite_color_VERTICAL.contains(neighbor_string) == false) {
	     		adjacent_opposite_color_VERTICAL.add(neighbor_string);
		    	
		        }
	    	}
		}
		HashSet<Point> new_stones_VERTICAL = new HashSet<>();
		new_stones_URLL.add(point);
        Ostring new_string_VERTICAL = new Ostring(player,new_stones_VERTICAL, liberties_VERTICAL);	
		for(Ostring same_color_string : adjacent_same_color_VERTICAL) {
        	new_string_VERTICAL = new_string_VERTICAL.merged_with(same_color_string);
        }
		for(Ostring opposite_string : adjacent_opposite_color_VERTICAL) {
			opposite_string.remove_liberty(point);
		}
		//VERTIVAL-END
		
		
		
       
	    Ostring[] new_value = {new_string_URLL,new_string_ULRL, new_string_HORIZON, new_string_VERTICAL};///나머지 추가	
        for(Point new_string_URLL_point:new_string_URLL.stones) {
             _grid.put(new_string_URLL_point,new_value);
        }
        for(Point new_string_ULRL_point:new_string_ULRL.stones) {
            _grid.put(new_string_ULRL_point,new_value);
       }
        for(Point new_string_HORIZON_point:new_string_HORIZON.stones) {
            _grid.put(new_string_HORIZON_point,new_value);
       }
        for(Point new_string_VERTICAL_point:new_string_VERTICAL.stones) {
            _grid.put(new_string_VERTICAL_point,new_value);
       }
		
	

		
		//////////
		//////////
		
	
		
	}
	public static Player get_Player(Point point) {
        Ostring string =_grid.get(point)[1] ;
		if(string == null) {
			return null;
		}
		return string.color;
		
	}
	

	
   public boolean is_on_grid(Point point) {
	  return 1 <= point.row && point.row<= this.num_rows && 1 <= point.col && point.col<= this.num_cols;
   }
}

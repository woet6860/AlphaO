package oboard;

import java.util.HashSet;
import otypes.Player;

import otypes.Point;

public class Ostring {
	public Player color;
	public HashSet<Point> stones = new HashSet<Point>();
	public HashSet<Point> liberties = new HashSet<Point>();


    Ostring(Player color ,HashSet<Point> stones,HashSet<Point> liberties){
    	 this.color = color;
    	 this.stones = stones; 
    	 this.liberties = liberties;
    	 
     }
     
     public Ostring merged_with(Ostring ostring) {
    	 assert ostring.color == this.color;
    	 this.stones.addAll(ostring.stones);
    	 this.liberties.addAll(ostring.liberties);
     	 this.liberties.removeAll(ostring.stones);
     	 Ostring Ostring = new Ostring(color,stones,this.liberties); 	
    	 return Ostring;
     }
     public void remove_liberty(Point point) {
    	 liberties.remove(point);
     }
      
     public void add_liberty(Point point) {
    	 liberties.add(point);
     }
      
     public int len_string(){
    	 return stones.size();
     }
     
     public boolean string_5(){
    	 if(this.len_string()==5) {
    		 return true;
    	 }
    	 return false;
     }
     
      
      
     
}
     

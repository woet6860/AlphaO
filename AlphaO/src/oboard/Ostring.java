package oboard;

import java.util.ArrayList;

import otypes.Player;
import otypes.Point;

public class Ostring {
	Integer color;
	ArrayList<Point> stones = new ArrayList<Point>();


      Ostring(Integer color ,ArrayList<Point> stones){
    	 this.color = color;
    	 this.stones = stones; 
     }
     
      Ostring merged_with(Ostring ostring) {
    	 assert ostring.color == this.color;
    	 this.stones.addAll(ostring.stones);
    	 Ostring Ostring = new Ostring(color,stones); 	
    	 return Ostring;
     }
     
}
     

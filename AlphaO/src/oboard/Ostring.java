package oboard;
import java.util.Set;

import otypes.Player;


public class Ostring {
	int color;
	Set stones;
	Set liberties;
	
     private Ostring(int color, Set stones, Set liberties){
    	 this.color = color;
    	 this.stones = stones;
    	 this.liberties = liberties;
     }
}

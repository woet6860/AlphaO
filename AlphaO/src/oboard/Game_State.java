package oboard;
import otypes.*;


public class Game_State{
	 Board board;
	 Move move;
	 Ostring ostring;
	 Player next_player;
	 Integer previous;
	 	
      Game_State(Board board,Player next_player,Integer previous ,Move move){
    	  this.board = board;
    	  this.next_player = next_player;
    	  this.previous = previous;
    	  this.move = move;
      }	
}

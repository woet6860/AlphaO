package oboard;
import otypes.*;



public class GameState{
	 Board board;
	 Move last_move;
	 Ostring ostring;
	 Player next_player;
	 GameState previous_state;
	 	
     private GameState(Board board,Player next_player,GameState previous ,Move move){
    	  this.board = board;
    	  this.next_player = next_player;
    	  this.previous_state = previous;
    	  this.last_move = move;
      }	
      
      public GameState apply_move(Move move) throws CloneNotSupportedException{
    	  Board next_board = null;
    	  try {
    		  next_board = this.board.clone();
    	  } catch(CloneNotSupportedException e){
    		  e.printStackTrace();
    	  }
    	  if(move.is_play) {
    		 next_board.place_stone(next_player, move.point); 
         }
    	  else { 
    	     next_board = this.board;
    	  }
    	  GameState GameState = new GameState(next_board, this.next_player.other(), this, move);
    	  return GameState;
    	  
      }
}

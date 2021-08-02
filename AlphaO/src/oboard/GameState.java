package oboard;
import otypes.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;


public class GameState{
	 Board board;
	 Move last_move;
	 Ostring ostring;
	 Player next_player;
	 HashSet<GameState> simulate_boards ;

     private GameState(Board board,Player next_player,HashSet<GameState> simulate_boards ,Move move){
    	  this.board = board;
    	  this.next_player = next_player;
    	  this.simulate_boards =  simulate_boards;
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
    	  GameState GameState = new GameState(next_board, this.next_player.other(), null, move);
    	  return GameState;
     }
      
      public GameState new_game(int BOARD_SIZE) {
    	  Board board =new Board(BOARD_SIZE,BOARD_SIZE);
    	  GameState GameState = new GameState(board, Player.BLACK, null, null );
    	  return GameState;
      }
      
      public boolean five_string(Ostring ostrimg) {
    	  if(ostring.len_string() == 5) {
    		  return true;
    	  }
    	  else {
    		  return false;
    	  }
      }
      
      
      
      public void simulation(Point point) {
    	  assert next_player == Player.BLACK;
    	  Board simulation_board = null;
    	  try {
    		  simulation_board = this.board.clone();
    	  } catch(CloneNotSupportedException e){
    		  e.printStackTrace();
    	  }
    	 
    	  simulation_board.place_stone(next_player, point);
    	  GameState simulate_GameState = new GameState(simulation_board, Player.BLACK, null, last_move );
    	  this.simulate_boards.add(simulate_GameState);
    	  
    	  
      }
      
      public void simulate_all(Board board) {
    	ArrayList<Point> empty_points = new ArrayList<>();
    	for(Point point:board._grid.keySet()) {
    		if(board._grid.get(point) == null) {
    			empty_points.add(point);
    		}
    	}
    	
    	for(Point point:empty_points) {
    		simulation(point);
    	}
    	
      }
      
      public boolean check_4x4_string() {
    	int count4x4 = 0;
    	int count3x3 = 0;
    	for(GameState GameState : this.simulate_boards) {
    		for(Ostring ostring: GameState.board._grid.get(GameState.last_move.point)) {
    			for(Point point:ostring.liberties) {
    				int x = 0;
    			GameState.board.place_stone(next_player, point);
    				for(Ostring ostring2 : GameState.board._grid.get(point)) {
    					if(five_string(ostring2)) {
    							x += 1;}
    				}
    				if(x==1) { count4x4 += x; continue;}
    			}
    		}
    	}
    	
    	if((count4x4 >= 2) || (count3x3 >=2)) {
    		return true;
    	}
    	else {return false;}
      }
         
     
      
      
      public boolean open_4_string(Ostring ostring) {
    	  if((ostring.len_string()) == 4 && (ostring.liberties.size() == 2) 
    		  ) {
    		  return true;
    	  }
    	  else {
    		  return false;
    	  }
    	  
      }
      
      public boolean check_3x3_string(){
    	  int count = 0;
      	for(GameState GameState : this.simulate_boards) {
      		for(Ostring ostring: GameState.board._grid.get(GameState.last_move.point)) {
      			for(Point point:ostring.liberties) {
      			GameState.board.place_stone(Player.BLACK, point);
      				for(Ostring ostring2 : GameState.board._grid.get(point)) {
      					if((ostring2.len_string() == 4) && (ostring2.liberties.size() == 2)) {
      						for(Point point2 : ostring2.liberties) {
      							GameState.board.place_stone(Player.BLACK, point2);
      							for(Ostring ostring3 : board._grid.get(point2)) {
      								if(five_string(ostring3)) {
      									
      								}
      							}
      						}
      					}
      				}
      			}
      		}
      	}
      	
      	if(count >= 2) {
      		return true;
      	}
      	else {return false;}
    	  
      }
      
      public boolean check_too_long_string(){
    	  
      }
      
      public Player is_win() {
    	  
      }
      
      
}

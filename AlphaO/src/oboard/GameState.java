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
     HashSet<Point> illegal_points;
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
      
      public void check_4x4_string() {
    	int count4x4 = 0;
    	for(GameState GameState : this.simulate_boards) {
    		for(Ostring ostring: GameState.board._grid.get(GameState.last_move.point)) {
    			for(Point point:ostring.liberties) {
    			GameState.board.place_stone(next_player, point);
    				for(Ostring ostring2 : GameState.board._grid.get(point)) {
    					if(five_string(ostring2)) {
    							count4x4 += 1;
    							break;}
    				}
    			}
    		}
    		if((count4x4 >= 2)) {if(this.illegal_points.contains(GameState.last_move.point) == false) {
				this.illegal_points.add(GameState.last_move.point);}
    		}	
    	}
      }
         
     

      
      public void check_3x3_string(){
    	  int count = 0;
      	for(GameState GameState : this.simulate_boards) {
      		for(Ostring ostring: GameState.board._grid.get(GameState.last_move.point)) {
      			for(Point point:ostring.liberties) {
      			GameState.board.place_stone(Player.BLACK, point);
      				for(Ostring ostring2 : GameState.board._grid.get(point)) {
      					int x = 0;
      					if((ostring2.len_string() == 4) && (ostring2.liberties.size() == 2)) {
      						for(Point point2 : ostring2.liberties) {
      							GameState.board.place_stone(Player.BLACK, point2);
      							for(Ostring ostring3 : board._grid.get(point2)) {
      								if(five_string(ostring3)) {
      							        x += 1;
      								}
      								if(x==2) {
      									count += 1;
      									
      								}
      							}
      						}
      					}
      				}
      			}
      		}
      		if(count >= 2)  {if(this.illegal_points.contains(GameState.last_move.point) == false){
      			this.illegal_points.add(GameState.last_move.point);
      		}
      	}
      }
      }
      
      public void check_too_long_string(){
    	  int count = 0;
    	 for(GameState GameState : this.simulate_boards) {
    		 for(Ostring ostring:GameState.board._grid.get(GameState.last_move.point)) {
    			 if(ostring.len_string()>5) {
    				 count += 1;
    				 break;
    			 }
    			 if(count==1) {if(this.illegal_points.contains(GameState.last_move.point)) {
    				 illegal_points.add(GameState.last_move.point);
    			 }
    		 }
    	 }
      }
      }
      
      public Player is_win() {
    	  Player winner = null;
    	 if(this.last_move.is_play) {
    		  for(Ostring ostring:this.board._grid.get(this.last_move.point)) {
    			  if(ostring.len_string() >= 5 ) {
    				  winner = this.next_player.other();
    			  }
    			 
    			  
    		  }
    	  }
    	  else if (this.last_move.is_resign){
    		  winner =  this.next_player.other();
    	  }
    	  
    	 return winner;
      }

}

      
  
      
      


package oboard;
import otypes.*;

import java.util.ArrayList;
import java.util.HashSet;


public class GameState{
	 public Board board;
	 public Move last_move;
	 Ostring ostring;
	 public Player next_player;
	 public HashSet<GameState> simulate_boards ;
     public HashSet<Point> illegal_points;
     public GameState(Board board,Player next_player,HashSet<GameState> simulate_boards ,Move move){
    	  this.board = board;
    	  this.next_player = next_player;
    	  this.simulate_boards =  simulate_boards;
    	  this.last_move = move;
      }	
     public GameState(int BOARD_SIZE) {
          this.board = new Board(BOARD_SIZE,BOARD_SIZE);
          this.next_player = Player.BLACK;
          this.simulate_boards = null;
          this.last_move = null;
     }

      
      public GameState apply_move(Move move) throws CloneNotSupportedException{
    	  Board next_board = null;
    	  try {
    		  next_board = this.board.clone();
    	  } catch(CloneNotSupportedException e){
    		  e.printStackTrace();
    	  }
    	  if(move.is_play) {
    		 next_board.place_stone(this.next_player, move.point); 
         }
    	  else { 
    	     next_board = this.board;
    	  }
    	  GameState GameState = new GameState(next_board, this.next_player.other(), null, move);
    	  return GameState;
     }
      
     

      
      
      public static void simulation(GameState gamestate, Point point) {
    	  
    	  Board simulation_board = null;
    	  try {
    		  simulation_board = gamestate.board.clone();
    	  } catch(CloneNotSupportedException e){
    		  e.printStackTrace();
    	  }
    	 
    	  simulation_board.place_stone(Player.BLACK, point);
    	  GameState simulate_GameState = new GameState(simulation_board, Player.BLACK, null, gamestate.last_move);
    	  gamestate.simulate_boards.add(simulate_GameState);
    	  check_3x3_string(gamestate);
    	  check_4x4_string(gamestate);
          check_too_long_string(gamestate);
    	  
    	  
      }
      
      public void simulate_all(GameState gamestate) {
     	ArrayList<Point> empty_points = new ArrayList<>();
    	for(Point point:gamestate.board._grid.keySet()) {
    		if(gamestate.board._grid.get(point) == null) {
    			empty_points.add(point);
    		}
    	}
    	
    	for(Point point:empty_points) {
    		simulation(gamestate,point);
    	}	
    	
      }
      
      public static void check_4x4_string(GameState gamestate) {
    	int count4x4 = 0;
    	for(GameState GameState : gamestate.simulate_boards) {
    		for(Ostring ostring: gamestate.board._grid.get(GameState.last_move.point)) {
    			for(Point point:ostring.liberties) {
    			GameState.board.place_stone(gamestate.next_player, point);
    				for(Ostring ostring2 : gamestate.board._grid.get(point)) {
    					if(ostring2.string_5()) {
    							count4x4 += 1;
    							break;}
    				}
    			}
    		}
    		if((count4x4 >= 2)) {if(gamestate.illegal_points.contains(GameState.last_move.point) == false) {
			gamestate.illegal_points.add(gamestate.last_move.point);}
    		}	
    	}
      }
         
     

      
      public static void check_3x3_string(GameState gamestate){
    	  int count = 0;
      	for(GameState GameState : gamestate.simulate_boards) {
      		for(Ostring ostring: gamestate.board._grid.get(GameState.last_move.point)) {
      			for(Point point:ostring.liberties) {
      				if(gamestate.illegal_points.contains(point)) {
							continue;
						}
      			GameState.board.place_stone(Player.BLACK, point);
      				for(Ostring ostring2 : gamestate.board._grid.get(point)) {
      					int x = 0;
      					if((ostring2.len_string() == 4) && (ostring2.liberties.size() == 2)) {
      						for(Point point2 : ostring2.liberties) {
      							GameState.board.place_stone(Player.BLACK, point2);
      							for(Ostring ostring3 : gamestate.board._grid.get(point2)) {
      								if(ostring3.string_5()) {
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
      		if(count >= 2)  {if(gamestate.illegal_points.contains(GameState.last_move.point) == false){
      		gamestate.illegal_points.add(GameState.last_move.point);
      		}
      	}
      }
      }
      
      public static void check_too_long_string(GameState gamestate){
    	  int count = 0;
    	 for(GameState GameState : gamestate.simulate_boards) {
    		 for(Ostring ostring:gamestate.board._grid.get(GameState.last_move.point)) {
    			 if(ostring.len_string()>5) {
    				 count += 1;
    				 break;
    			 }
    			 if(count==1) {if(gamestate.illegal_points.contains(GameState.last_move.point)) {
    				 gamestate.illegal_points.add(GameState.last_move.point);
    			 }
    		 }
    	 }
      }
      }
      
      
      public boolean is_over() {
    	  if(this.last_move == null) {
    		  return false;
    	  }
    	  
    	  if(this.last_move.is_play) {
    		  for(Ostring ostring:board._grid.get(this.last_move.point)) {
    			  if(ostring.string_5()) {
    				  return true;
    			  }
    			  else {return false;}
    		  }
    	  }
    	  
    	  else if(this.last_move.is_pass) {
    		  return false;
    	  }
    	  
    	  else if(this.last_move.is_resign) {
    		  return true;
    	  }
    	  
    	 return false;
      }
      
}

      
  
      
      


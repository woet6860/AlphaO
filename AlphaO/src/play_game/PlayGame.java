package play_game;
import oboard.*;
import otypes.*;
import utils.Utils;

import static utils.Utils.*;
import java.util.Scanner;

public class PlayGame {
     public static void main(String[] args) throws CloneNotSupportedException {
    	 GameState game = new GameState(null,null,null,null) ;
    	 int BOARD_SIZE = 13;
    	 game = game.new_game(BOARD_SIZE);
    	 Scanner scan =new Scanner(System.in);
    	 while(game.is_over() == false) {
    		 
        	 
        	  print_board(game.board);

    	      if(game.next_player == Player.BLACK) {
    	    	  game.simulate_boards = null;
    	    	  game.simulate_all(game.board);
    			  System.out.print("Player_BLACK:");
    			  String Player_move = scan.next();
    			  Point point = point_from_coords(Player_move);
    			  System.out.println(point.col);
    			  System.out.println(point.row);
    			  System.out.println(Utils.COLS.getClass().getName());
    			  Move move = Move.play(point);
    			  if(GameState.illegal_points != null) {while(GameState.illegal_points.contains(point)) { 
    				 System.out.printf("%s is illegal point" , Player_move);
    			  }}
                  print_move(game.next_player,Move.play(point));  
                  game = game.apply_move(move);
                  }
    		  else {
    			  System.out.print("Player_WHITE:");
    			  String Player_move = scan.next();
    			  Point point = point_from_coords(Player_move);
    			  
    			  Move move = Move.play(point);
    			  print_move(game.next_player,Move.play(point));  
                  game = game.apply_move(move);
        	     
    	 }   
    	      
    	 }
    	 scan.close(); 
     }
}

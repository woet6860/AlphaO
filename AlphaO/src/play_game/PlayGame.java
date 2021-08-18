package play_game;
import oboard.*;
import otypes.*;
import static utils.Utils.*;
import java.util.Scanner;

public class PlayGame {
     public static void main(String[] args) throws CloneNotSupportedException {
    	 int BOARD_SIZE = 13;
         GameState game = new GameState(BOARD_SIZE);
    	 Scanner scan =new Scanner(System.in);
    	 while(game.is_over() == false) {
    		 
        	 
        	  print_board(game);

    	      if(game.next_player == Player.BLACK) {
    	    	  GameState.simulate_all(game);
    	    	  
    			  System.out.print("Player_BLACK:");
    			  String Player_move = scan.next();
    			  Point point = point_from_coords(Player_move);
    			  System.out.println(point.col);
    			  System.out.println(point.row);
    			  Move move = new Move(null,false,false);
    			  move = move.play(point);
    			 // if(game.illegal_points != null) {while(game.illegal_points.contains(point)) { 
    			//	 System.out.printf("%s is illegal point" , Player_move);
    			 // }}
    		
                  print_move(game.next_player,move);  
                  game = game.apply_move(move);
                  }
    	      
    	      
    		  else {
    			  System.out.print("Player_WHITE:");
    			  String Player_move = scan.next();
    			  Point point = point_from_coords(Player_move);
    			  Move move = new Move(null,false,false);
    			  move = move.play(point);
    			  print_move(game.next_player,move);  
                  game = game.apply_move(move);
        	     
    	 }   
    	      
    	 }
    	 scan.close(); 
     }
}

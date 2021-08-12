package play_game;
import oboard.*;
import otypes.*;
import static utils.Utils.*;
import java.util.Scanner;

public class PlayGame {
     public static void main(String[] args) throws CloneNotSupportedException {
    	 GameState game = new GameState(null,null,null,null) ;
    	 int BOARD_SIZE = 13;
    	 game.new_game(BOARD_SIZE);
    	 while(game.is_over()) {
    		 
    	      print_board(game.board);
    	      Scanner scan =new Scanner(System.in);
    	      if(game.next_player == Player.BLACK) {
    			  System.out.print("Player_BLACK:");
    			  String Player1_move;
    			  Player1_move = scan.next();
    			  Point point = point_from_coords(Player1_move);
    			  Move move = Move.play(point);
    			  while(GameState.illegal_points.contains(point) == false) {
    				  System.out.printf("%s is illegal point" , Player1_move);
    			  }
                  print_move(game.next_player,Move.play(point));  
                  game = game.apply_move(move);
    		  }
    		  else {
    			  System.out.print("Player_WHITE:");
    			  String Player2_move;
    			  Player2_move = scan.next();
    			  Point point = point_from_coords(Player2_move);
    			  Move move = Move.play(point);
    			  print_move(game.next_player,Move.play(point));  
                  game = game.apply_move(move);
    	 }   
    	      scan.close(); 
    	 }
    	 
    	 
     }
}

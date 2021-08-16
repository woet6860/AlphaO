package utils;
import otypes.Player;
import otypes.Point;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import oboard.GameState;
import oboard.Move;

public class Utils {
	public static String COLS = "ABCDEFGHJKLMNOPQRST";
	//public static String[] COLS = {"A","B","C","D","E","F","G","H","J","K","L","M","N","O","P","Q","R","S","T"};
    static String COLS_str = "A,B,C,D,E,F,G,H,J,K,L,M,N,O,P,Q,R,S,T";
   // public static List<String> COLS = Arrays.asList(COLS_str.split(","));
    static HashMap<Point, String> STONE_TO_CHAR = new HashMap<>();
    
    public static void stone_to_char(GameState gamestate,Point point){
    	if(gamestate.illegal_points != null) {
            if(gamestate.illegal_points.contains(point)) {
    	STONE_TO_CHAR.put(point, "X");
    	}}
    	  else if(gamestate.board._grid.get(point) == null){
          	STONE_TO_CHAR.put(point, ".");
          }
        else if(gamestate.board.get_Player(point) == Player.BLACK) {
        	STONE_TO_CHAR.put(point, "●");
        }
        else if(gamestate.board.get_Player(point) ==Player.WHITE) {
        	STONE_TO_CHAR.put(point, "○");
        }
      
    	
    }
    	
    
   
   public static void print_move(Player player, Move move) {
	   String move_str=null;
	   if(move.is_pass) {
		   move_str = "passes";
	   }
	   else if(move.is_resign) {
		   move_str = "resigns";
	   }
	   else if(move.point.col>0){
		   move_str = String.format("%s%d" , COLS.substring(((move.point.col)-1),move.point.col) , move.point.row);
	   }
	   
	   System.out.println(String.format("%s %s", move_str, player));
	   System.out.println();
   }
   
   public static void print_board(GameState gamestate) {
	   for(int row = gamestate.board.num_rows; row>=1; row-- ) {
		   String bump;
		   if(row>9) {
			   bump = "";
		   }
		   else {
			   bump = " ";
		   }
		   List<String> Line = new ArrayList<>();
		  
		   for(int col = 1; col <=gamestate.board.num_rows;col++) {
			   Point stone = new Point(row,col);////stone_to_char (MAP)의 키를 이용해야한다 .....
			   stone_to_char(gamestate,stone);			   
			   Line.add(STONE_TO_CHAR.get(stone));
			}
		   System.out.println(bump + row +" " + String.join(" ",Line));  
	   }
	   
	   System.out.printf("   " + String.join(" ",COLS.substring(0,gamestate.board.num_rows)));
	   System.out.println();
   }
   
   public static Point point_from_coords(String coord) {
	   int col = (COLS.indexOf(coord.substring(0,1))) + 1;
	   int row = Integer.parseInt(coord.substring(1));
	   Point point = new Point(row,col) ;
	   
	   return point;
   }
}
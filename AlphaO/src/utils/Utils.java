package utils;
import otypes.Player;
import otypes.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import oboard.GameState;
import oboard.Board;
import oboard.Move;

public class Utils {
    String COLS_str = "A,B,C,D,E,F,G,H,J,K,L,M,N,O,P,Q,R,S,T";
    List<String> COLS = Arrays.asList(COLS_str.split(","));
    HashMap<Point, String> STONE_TO_CHAR = new HashMap<>();
    public void stone_to_char(){
    	for(Point point : GameState.illegal_points) {
    	STONE_TO_CHAR.put(point, "X");
        if(Board.get_Player(point) == Player.BLACK) {
        	STONE_TO_CHAR.put(point, "●");
        }
        if(Board.get_Player(point) ==Player.WHITE) {
        	STONE_TO_CHAR.put(point, "○");
        }
        if(Board._grid.get(point)[1] == null) {
        	STONE_TO_CHAR.put(point, ".");
        }
    	
    }
    	
    }
   
   public void print_move(Player player, Move move) {
	   String move_str;
	   if(move.is_pass) {
		   move_str = "passes";
	   }
	   else if(move.is_resign) {
		   move_str = "resigns";
	   }
	   else {
		   move_str = String.format("%s%d" , COLS.get(move.point.col-1) , move.point.row);
	   }
	   
	   System.out.print(String.format("%s %s", move_str, player));
	   
   }
   
   public void print_board(Board board) {
	   for(int row = board.num_rows; row==1; row-=1 ) {
		   String bump;
		   if(row>9) {
			   bump = "";
		   }
		   else {
			   bump = " ";
		   }
		   List<String> Line = new ArrayList<>();
		   for(int col = 0; col <= board.num_rows;col+=1) {
			   Point stone = new Point(row,col);////stone_to_char (MAP)의 키를 이용해야한다 .....
			   Line.add(STONE_TO_CHAR.get(stone));
			}
		   System.out.printf("%s%d %s" ,bump,row,String.join(" ",Line));   
	   }
	   
	   System.out.printf("   " + "  " + String.join(" ",COLS.subList(0,board.num_rows)));
   }
   
   public Point point_from_coords(String coord) {
	   int col = COLS.indexOf(coord.substring(0)) + 1;
	   int row = Integer.parseInt(coord.substring(1));
	   Point point = new Point(row ,col);
	   return point;
   }
}
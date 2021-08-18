package otypes;
import java.util.HashSet;


public class Point {
    public int row;
    public int col;
   
	public Point(int row, int col){
		this.row = row;
		this.col = col;
	} 
	public HashSet<Point> neighbor_URLL_point(){
	  HashSet<Point>neighbor_URLL = new HashSet<>();
      Point neighbor_URLL_point0 = new Point(this.row+1,this.col+1);
      Point neighbor_URLL_point1 = new Point(this.row-1,this.col-1);
      neighbor_URLL.add(neighbor_URLL_point0);
      neighbor_URLL.add(neighbor_URLL_point1);
      return neighbor_URLL;
	}
	public HashSet<Point> neighbor_ULRL_point(){
	  HashSet<Point>neighbor_ULRL = new HashSet<>();
      Point neighbor_URLL_point0 = new Point(this.row-1,this.col+1);
      Point neighbor_URLL_point1 = new Point(this.row+1,this.col-1);
      neighbor_ULRL.add(neighbor_URLL_point0);
	  neighbor_ULRL.add(neighbor_URLL_point1);
	  return neighbor_ULRL;
		}
	public HashSet<Point> neighbor_HORIZON_point(){
		HashSet<Point>neighbor_HORIZON = new HashSet<>();
		Point neighbor_URLL_point0 = new Point(this.row,this.col+1);
	  Point neighbor_URLL_point1 = new Point(this.row,this.col-1);
	  neighbor_HORIZON.add(neighbor_URLL_point0);
	  neighbor_HORIZON.add(neighbor_URLL_point1);
	  return neighbor_HORIZON;
			}
	public HashSet<Point> neighbor_VERTICAL_point(){
		HashSet<Point>neighbor_VERTICAL = new HashSet<>();
		Point neighbor_URLL_point0 = new Point(this.row+1,this.col);
      Point neighbor_URLL_point1 = new Point(this.row-1,this.col);
	  neighbor_VERTICAL.add(neighbor_URLL_point0);
	  neighbor_VERTICAL.add(neighbor_URLL_point1);
	  return neighbor_VERTICAL;
				}
}


       

package otypes;
import java.util.HashSet;


public class Point {
    public int row;
    public int col;
    public HashSet<Point>neighbor_URLL = new HashSet<>();
    public HashSet<Point>neighbor_ULRL = new HashSet<>();
    public HashSet<Point>neighbor_HORIZON = new HashSet<>();
    public HashSet<Point>neighbor_VERTICAL = new HashSet<>();

	public Point(int row, int col){
		this.row = row;
		this.col = col;

	} 
	public void neighbor_URLL_point(){
      Point neighbor_URLL_point0 = new Point(this.row+1,this.col+1);
      Point neighbor_URLL_point1 = new Point(this.row-1,this.col-1);
      neighbor_URLL.add(neighbor_URLL_point0);
      neighbor_URLL.add(neighbor_URLL_point1);
	}
	public void neighbor_ULRL_point(){
      Point neighbor_URLL_point0 = new Point(this.row-1,this.col+1);
      Point neighbor_URLL_point1 = new Point(this.row+1,this.col-1);
      neighbor_URLL.add(neighbor_URLL_point0);
	  neighbor_URLL.add(neighbor_URLL_point1);
		}
	public void neighbor_HORIZON_point(){
      Point neighbor_URLL_point0 = new Point(this.row,this.col+1);
	  Point neighbor_URLL_point1 = new Point(this.row,this.col-1);
	  neighbor_URLL.add(neighbor_URLL_point0);
	  neighbor_URLL.add(neighbor_URLL_point1);
			}
	public void neighbor_VERTICAL_point(){
	  Point neighbor_URLL_point0 = new Point(this.row+1,this.col);
      Point neighbor_URLL_point1 = new Point(this.row-1,this.col);
	  neighbor_URLL.add(neighbor_URLL_point0);
	  neighbor_URLL.add(neighbor_URLL_point1);
				}
}


       

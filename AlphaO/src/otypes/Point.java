package otypes;
import java.util.HashSet;


public class Point {
    public int raw;
    public int col;
    public HashSet<Point>neighbor_URLL = new HashSet<>();;

	public Point(int raw, int col){
		this.raw = raw;
		this.col = col;

	} 
	public void neighbor_URLL_point(){
      Point neighbor_URLL_point0 = new Point(this.raw+1,this.col+1);
      Point neighbor_URLL_point1 = new Point(this.raw-1,this.col-1);
      neighbor_URLL.add(neighbor_URLL_point0);
      neighbor_URLL.add(neighbor_URLL_point1);
	}
}


       

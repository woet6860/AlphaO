package otypes;
import java.util.HashMap;
import java.util.Map;

public class Point {
    public int raw;
    public int col;
    public Point[] neighbor_URLL= new Point[2];
    public static Map<Point, Integer>_grid = new HashMap<>();
	public Point(int raw, int col){
		this.raw = raw;
		this.col = col;

	} 
	public void neighbors() {
    Point neighbor_URLL_point0 = new Point(this.raw+1,this.col+1);
    Point neighbor_URLL_point1 = new Point(this.raw-1,this.col-1);
    this.neighbor_URLL[0] = neighbor_URLL_point0;
    this.neighbor_URLL[1] = neighbor_URLL_point1;
    
    
    
	
	
	}
}

       

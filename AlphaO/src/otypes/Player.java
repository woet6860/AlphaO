package otypes;


public enum  Player{
   BLACK(1),
   WHITE(2);
	
	public final Integer color;
	
	Player(Integer color){
		this.color = color;
	}
	
	public Player other() {
		if(this.color == 1) {
			return WHITE;
		}
		else {return BLACK;}
	}
}

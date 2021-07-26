package otypes;
public class  Player{
	static enum Stone{
		BLACK(1)
		,WHITE(2);
		public final int value;
		private Stone(int value) {
			this.value = value;
		}
	}
	
    public Player(Stone stone) {
    	Player.stone = stone;
    }
    
    static Stone stone;
    static Player player = new Player(stone);
    
    public static int other(int value) {
    	if(Player.stone.value == 1) {return Player.Stone.WHITE.value;}
    	else {return Player.Stone.BLACK.value;}
          
    }
}

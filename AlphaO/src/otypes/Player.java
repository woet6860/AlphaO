package otypes;
public class  Player{
	static enum Stone{
		BLACK(0)
		,WHITE(1);
		public final int value;
		
		private Stone(int value) {
			this.value = value;
		}
	}
	static Stone stone;
    public Player(Stone stone) {
    	Player.stone = stone;
    }
    
    static Player player = new Player(stone);
    public static int othe(int value) {
    	if(Player.stone.value == 0) {return Player.Stone.WHITE.value;}
    	else {return Player.Stone.BLACK.value;}
          
    }
}

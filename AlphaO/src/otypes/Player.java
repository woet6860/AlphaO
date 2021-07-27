package otypes;


public class  Player{
	public static enum Stone{
		BLACK(1)
		,WHITE(2);
		public final Integer value;
		private Stone(Integer value) {
			this.value = value;
		}
	}
	
    public Player(Stone stone) {
    	Player.stone = stone;
    }
    
    public static Stone stone;
    static Player player = new Player(stone);
    
    public static Integer other(Integer value) {
    	if(Player.stone.value == 1) {return Player.Stone.WHITE.value;}
    	else {return Player.Stone.BLACK.value;}
          
    }
}

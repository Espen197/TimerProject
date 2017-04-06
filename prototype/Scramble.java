package prototype;

public class Scramble {

	private String[] moves = {"R", "R2", "R'", "L", "L2", "L'", "U", "U2", "U'", "D", "D2", "D'", "F", "F2", "F'", "B", "B2", "B'"};
	
	public String generateScramble(){
		int counter = 0;
		String scramble = "Scramble: ";
		String lastSide = "";
		
		while (counter < 20){
			int index = (int) (Math.random() * 18);
			
			String move = moves[index];
			String side = move.substring(0,1);
			if(! side.equals(lastSide)){
				scramble += move + " ";
				lastSide = side;
				counter += 1;	
			}
			
		}
		
		return scramble;
	}

}

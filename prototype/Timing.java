package prototype;


import prototype.Stats;

public class Timing {
	
	private boolean running;
	private long startTime;
	private long stopTime;
	private long usedTime;
	private String timeString;
	private int timerCounter = 0;
	
	Stats stats = new Stats();
	
	public void startTime(){
		if(!running){
			running = true;
			startTime = System.currentTimeMillis();
		}
	}
	
	public boolean shouldStart(){
		boolean check;
		if(timerCounter % 2 == 0){
			check = true;
		}
		else{
			check = false;
		}
		timerCounter += 1;
		return check;
	}
	
	public void stopTime(){
		if(running){
			running = false;
			stopTime = System.currentTimeMillis();
		}
	}
	
	public String getTime(){
		this.usedTime = this.stopTime - this.startTime;
		timeString = Stats.formatTime(usedTime);
		Stats.addTime(usedTime);
		return timeString;
	}
	
	public boolean getRunning(){
		return this.running;
	}
	
	public void calculateStats(long time){
		
		
	}
	


}

package prototype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Stats {
	
	private static Collection<Long> times = new ArrayList<Long>(); 
	
	
	public static void addTime(long time){
		times.add(time);
	}
	
	public String getTimes(){
		String timesString = "";
		for(Long time : times){
			timesString += formatTime(time) + ", ";
		}
		if(times.size() != 0){
			timesString = timesString.substring(0, (timesString.length() -2));
		}
		
		return timesString;
	}
	
	public String getAverage() {
		  Long sum = (long) 0;
		  String average = " DNF";
		  if(times.size() > 2) {
		    for (Long time : times) {
		        sum += time;
		    }
		     average = formatTime((sum - Collections.max(times) - Collections.min(times)) / (times.size()-2));
		  } 
		  return average;
		}
	
	public int getTimeNumber(){
		return times.size();
	}
	
	public void resetStats(){
		times.clear();
	}
	
	public static String formatTime(long milliseconds){
		String timeString;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
		long seconds = (TimeUnit.MILLISECONDS.toSeconds(milliseconds)) - TimeUnit.MINUTES.toSeconds(minutes);
		long millis = (milliseconds - TimeUnit.MINUTES.toMillis(minutes) - TimeUnit.SECONDS.toMillis(seconds))/10;
		
		if (minutes != 0){
			timeString = String.format("%2d:%02d.%02d", minutes, seconds, millis);
		}
		else{
			timeString = String.format("%2d.%02d", seconds, millis);
		}
		return timeString;
	}
	
}

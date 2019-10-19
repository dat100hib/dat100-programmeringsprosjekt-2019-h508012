package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	// OPPGAVE - START
	
	public static int toSeconds(String timestr) {
		
		int secs; 
		int hr, min, sec;
		
		sec = Integer.parseInt(timestr.substring(17, 19));
		min = Integer.parseInt(timestr.substring(14, 16));
		hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX, 13));
		
		secs = (hr * (60 * 60)) + (min * 60) + sec;
		return secs;

		// OPPGAVE - SLUTT
	}

	public static GPSPoint convert(String time, String latitude, String longitude, String elevation) {
		
		GPSPoint gpspoint;
		
		// TODO - START ;
		
		double breddegrad, lengdegrad, hoyde;

		int secs = toSeconds(time);
		breddegrad = Double.parseDouble(latitude);
		lengdegrad = Double.parseDouble(longitude);
		hoyde = Double.parseDouble(elevation);
		
		gpspoint = new GPSPoint(secs, breddegrad, lengdegrad, hoyde);
		return gpspoint;
		
		// OPPGAVE - SLUTT ;
	    
	}
	
}

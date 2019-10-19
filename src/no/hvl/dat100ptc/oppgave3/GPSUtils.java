package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
	
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latArray = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			latArray[i] = gpspoints[i].getLatitude();
		}
		return latArray;
		
		// TODO - SLUTT
	}
	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longArray = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			longArray[i] = gpspoints[i].getLongitude();
		}
		return longArray;
	
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());

		double latDiff = latitude2 - latitude1;
		double longDiff = longitude2 - longitude1;
		
		double a = Math.pow(Math.sin(latDiff/2), 2) + (cos(latitude1) * cos(latitude2) * Math.pow(sin((longDiff / 2)), 2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt((1-a)));
		d = R * c;
		
		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		double timeDiff = gpspoint2.getTime() - gpspoint1.getTime();
		
		speed = distance(gpspoint1, gpspoint2) / timeDiff;
		speed = speed * 3.6;
		
		return speed;
		
		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int s = secs % 60 % 60;
		int m = secs / 60 % 60;
		int h = secs / 3600;
		
		String hTxt = String.format("%02d", h);
		String mTxt = String.format("%02d", m);
		String sTxt = String.format("%02d", s);
		
		String ut = hTxt + TIMESEP + mTxt + TIMESEP + sTxt;
		timestr = String.format("%10s", ut);
		
		return timestr;
		// TODO - SLUTT

	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		str = String.format("%.2f", d);
		//System.out.print(str);
		return String.format("%10s", str);
		// TODO - SLUTT
		
	}
}

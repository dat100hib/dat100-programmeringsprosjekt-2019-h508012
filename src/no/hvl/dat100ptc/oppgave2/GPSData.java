package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class GPSData {

	private GPSPoint[] gpspoints; 
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		antall = 0;
		
		gpspoints = new GPSPoint[n];
	
		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if(antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;
		
		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		boolean sattInn = false;
		
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		if(insertGPS(gpspoint)) {
			sattInn = true;
		}
		return sattInn;
		
		// TODO - SLUTT
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		for(int i = 0; i < gpspoints.length; i++) {
			System.out.print(gpspoints[i].toString());
		}
		
		// TODO - SLUTT
		
		// System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}

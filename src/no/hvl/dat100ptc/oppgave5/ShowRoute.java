package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.*;
import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {
		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon));
		return xstep;
		
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		return ystep;
		
		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		int radius = 3;
		int x, y, x2=0, y2=0;
		
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		
		for (int i = 0; i < gpspoints.length; i++) {
			x = MARGIN + (int) ((gpspoints[i].getLongitude() - minlon) * xstep());
			y = (int) (ybase - (gpspoints[i].getLatitude() - minlat) * ystep());
			setColor(0, 255, 0);
			
			if (i == 0) {
				x2=x;
				y2=y;
			}
			
			drawLine(x, y, x2, y2);
			x2 = x;
			y2 = y;
			fillCircle(x, y, radius);
		}
		
		// TODO - SLUTT
	}

	public void showStatistics() {


		setColor(0,0,0);
		setFont("Courier",20);
		
		// TODO - START
		
		String distance = String.format("%.2f", gpscomputer.totalDistance() / 1000);
		String elevation = String.format("%.2f", gpscomputer.totalElevation());
		String maxspeed = String.format("%.2f", gpscomputer.maxSpeed());
		String avspeed = String.format("%.2f", gpscomputer.averageSpeed());
		String energy = String.format("%.2f", gpscomputer.totalKcal(80));
		
		
		drawString("Total distance :      " + distance + " km", 0, 20);
		drawString("Total elevation:      " + elevation + " m", 0, 40);
		drawString("Max speed      :      " + maxspeed + " km/t", 0, 60);
		drawString("Average speed  :      " + avspeed + " km/t", 0, 80);
		drawString("Energy         :      " + energy + " kcal", 0, 100);
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

}
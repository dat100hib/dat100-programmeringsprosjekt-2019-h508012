	package no.hvl.dat100ptc.oppgave5;
	
	import javax.swing.JOptionPane;
	
	import easygraphics.EasyGraphics;
	import no.hvl.dat100ptc.TODO;
	import no.hvl.dat100ptc.oppgave1.GPSPoint;
	import no.hvl.dat100ptc.oppgave2.*;
	import no.hvl.dat100ptc.oppgave3.GPSUtils;
	import no.hvl.dat100ptc.oppgave4.*;
	import no.hvl.dat100ptc.TODO.*;
	
	public class ShowSpeed extends EasyGraphics {
				
		private static int MARGIN = 50;
		private static int BARHEIGHT = 200; // assume no speed above 200 km/t
	
		private GPSComputer gpscomputer;
		private GPSPoint[] gpspoints;
		
		public ShowSpeed() {
	
			String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
			gpscomputer = new GPSComputer(filename);
	
			gpspoints = gpscomputer.getGPSPoints();
			
		}
		
		// read in the files and draw into using EasyGraphics
		public static void main(String[] args) {
			launch(args);
		}
	
		public void run() {
	
			int N = gpspoints.length-1; // number of data points
			
			makeWindow("Speed profile", MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
			
			showSpeedProfile(MARGIN + BARHEIGHT,N);
		}
		public void showSpeedProfile(int ybase, int N) {
			
			System.out.println("Angi tidsskalering i tegnevinduet ...");
			int timescaling = Integer.parseInt(getText("Tidsskalering"));
			
			// TODO - START
			int minX = MARGIN;
			setColor(0, 255, 0);
			drawLine(minX, (ybase - (int) gpscomputer.averageSpeed()),  1050, (ybase - (int) gpscomputer.averageSpeed()));
			setColor(0, 0, 0);
			int Xstart = 0;
			
			for(int i = 0; i < N - 1; i++) {
				
				double speed = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
				int fart = (int) speed; 
				//if(speed < 0) {
				//	fart = 0;
				//}
				drawLine(Xstart, ybase, Xstart, (MARGIN+BARHEIGHT) - fart);
				Xstart += 2;
		
			// TODO - SLUTT
		}
		}
	
	}

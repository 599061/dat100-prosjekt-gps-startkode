package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
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
		double[] latitudes = new double[gpspoints.length];

		for ( int i = 0; i < gpspoints.length; i++) {
			
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		
		// TODO - START
		double lat1 = toRadians(gpspoint1.getLatitude());
		double lat2 = toRadians(gpspoint2.getLatitude());
		double deltaLat = lat2 - lat1;
		double deltaLamb = toRadians(gpspoint2.getLongitude()) - toRadians(gpspoint1.getLongitude());
		double a;
		double c;
		
		a = pow((sin(deltaLat/2)), 2) + cos(lat1) * cos(lat2) * pow((sin(deltaLamb/2)), 2);
		c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = R * c;

		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		double distance = distance(gpspoint1, gpspoint2);
		
		// TODO - START
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		speed = (distance / secs) * 3.6;
		
		return speed;
		

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		
		int hh = secs / 3600;
		int hhrest = secs % 3600;
		int mm = hhrest / 60;
		int ss = hhrest % 60;
		
		String hhStr = String.format("%02d", hh);
		String mmStr = String.format("%02d", mm);
		String ssStr = String.format("%02d", ss);
		
		timestr = hhStr + TIMESEP + mmStr + TIMESEP + ssStr;
		
		timestr = String.format("%10s", timestr);
		
		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		str = String.format(Locale.UK, "%.2f", d);
		
		str = String.format("%" + TEXTWIDTH + "s", str);
		
		return str;

		// TODO - SLUTT
		
	}
}

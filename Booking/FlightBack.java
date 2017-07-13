package Plane;

import java.util.Scanner;

public class FlightBack {
	BookBack bk = new BookBack();

	Scanner sc = new Scanner(System.in);
	int i = 0;
	String swap;
	String next;
	String PG222[] = new String[5];
	String PG216[] = new String[5];
	String PG224[] = new String[5];
	String PG907[] = new String[5];
	String PG226[] = new String[5];
	String PG220[] = new String[5];
	String PG228[] = new String[5];
	String[][] all = { PG222, PG216, PG224, PG907, PG226, PG220, PG228 };

	
	public int add(int x, int y,String[] a,int flight) {
		
		int l = a.length;
		for (int j = 0; j < l; j++) {
			 if(bk.Allobj2[x][y].all[flight][j]==null){
					bk.Allobj2[x][y].all[flight][j] = a[j];
					i++;}
				else{
					for(int count =0;count<5;count++)
						if(bk.Allobj2[x][y].all[flight][count]==null){
							bk.Allobj2[x][y].all[flight][count] = a[j];
							break;
						}
				}
			if (i >= 5) {
				System.out.println("FULL");
				for (String s : bk.Allobj2[x][y].all[flight]) {
					System.out.println(s);
				}
				return i;
			} 
			
		}
		for (String s : bk.Allobj2[x][y].all[flight]) {
			System.out.println(s);
		}
		return i;
	}

	public static void flightline() {
		System.out.println("PG222 / out 06:55 / arrive 08:15");
		System.out.println("PG216 / out 10:10 / arrive 11:30");
		System.out.println("PG224 / out 12:00 / arrive 13:20");
		System.out.println("PG907 / out 14:40 / arrive 16:00");
		System.out.println("PG226 / out 16:40 / arrive 18:00");
		System.out.println("PG220 / out 19:00 / arrive 20:20");
		System.out.println("PG228 / out 21:05 / arrive 22:25");
	}

}

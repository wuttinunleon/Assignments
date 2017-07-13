package Plane;

import Plane.BookMain;
import java.util.Scanner;
public class Cancel {
String swap;
int flight,number,day1;
int flightB,numberB,day1B;

Scanner sc = new Scanner(System.in);
  void Canc(){
	System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
	System.out.print("Enter the day you want to cancel (GO) : ");
	day1=sc.nextInt();
	System.out.println("PG215(1),PG270(2),PG217(3),PG906(4),PG219(5),PG268(6),PG221(7)");
	System.out.print("Enter the flight : ");
	flight=sc.nextInt();
	System.out.print("Enter the number of seat : ");
	number = sc.nextInt();
	System.out.println("in seat is : "+BookMain.Allobj[day1-1][flight-1].all[flight-1][number-1]);
	System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
	System.out.print("Enter the day you want to cancel (BACK) : ");
	day1B=sc.nextInt();
	System.out.println("PG222(1),PG216(2),PG224(3),PG907(4),PG226(5),PG220(6),PG228(7)");
	System.out.print("Enter the flight : ");
	flightB=sc.nextInt();
	System.out.print("Enter the number of seat : ");
	numberB = sc.nextInt();
	System.out.println("in seat is : "+	BookBack.Allobj2[day1B-1][flightB-1].all[flightB-1][numberB-1]);
	if(BookMain.Allobj[day1-1][flight-1].all[flight-1][number-1].equals(BookBack.Allobj2[day1B-1][flightB-1].all[flightB-1][numberB-1])){
	BookMain.Allobj[day1-1][flight-1].all[flight-1][number-1]=null;
	BookBack.Allobj2[day1B-1][flightB-1].all[flightB-1][numberB-1]=null;
	System.out.println("CANCEL SUCCESS!!!");
	}
	else 
		System.out.println("wrong people!!!");
}
}

package Plane;

import java.util.Scanner;
public  class BookBack {	
	Scanner sc = new Scanner(System.in);
	int l,m;
	int check;
	String swap;
	int count1,count2;

static	FlightBack[] mon2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] tues2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] wed2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] thurs2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] fri2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] sat2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static	FlightBack[] sun2 = new FlightBack[]{new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack(),new FlightBack()};
static FlightBack[][] Allobj2 = {mon2,tues2,wed2,thurs2,fri2,sat2,sun2};
	 void mon2() {
		Schedule.preface2();
		day=sc.next().toUpperCase();
		if(day.equals("MONDAY")){count1=0;}
		if(day.equals("TUESDAY")){count1=1;}
		if(day.equals("WEDNESDAY")){count1=2;}
		if(day.equals("THURSDAY")){count1=3;}
		if(day.equals("FRIDAY")){count1=4;}
		if(day.equals("SATURDAY")){count1=5;}
		if(day.equals("SUNDAY")){count1=6;}

		FlightBack.flightline();
		i = sc.next().toUpperCase();
		if(i.equals("PG222")){count2=0;}
		if(i.equals("PG216")){count2=1;}
		if(i.equals("PG224")){count2=2;}
		if(i.equals("PG907")){count2=3;}
		if(i.equals("PG226")){count2=4;}
		if(i.equals("PG220")){count2=5;}
		if(i.equals("PG228")){count2=6;}
	
			check =Allobj2[count1][count2].add(count1,count2,Flight.a,count2);
			if (check >5){
				System.out.println("Next ?? ( yes , no ) : ");
				i=sc.next().toUpperCase();
				if(i.equals("YES")){
					if(count2==6&&count1!=6){
						count1++;
						count2=0;
					}
					if(count2==6&&count1==6){
					count1=count2;	
					}
					else count2++;

					mon2[2].add(count1,count2,Flight.a,count2);
				
			}
		}
		////////////////////////////////////////////////////
	 }
}



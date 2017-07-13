package Plane;


import java.util.Scanner;

public  class BookMain {	
	Scanner sc = new Scanner(System.in);
	int max;
	int l,m;
	int check;
	String i;
	String swap;
	int count1,count2;
	String day;
static	Flight[] mon = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] tues = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] wed = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] thurs = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] fri = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] sat = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static	Flight[] sun = new Flight[]{new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight(),new Flight()};
static  Flight[][] Allobj = {mon,tues,wed,thurs,fri,sat,sun};

		void mon() {
		day = sc.next().toUpperCase();
		if(day.equals("MONDAY")){count1=0;}
		else if(day.equals("TUESDAY")){count1=1;}
		else if(day.equals("WEDNESDAY")){count1=2;}
		else if(day.equals("THURSDAY")){count1=3;}
		else if(day.equals("FRIDAY")){count1=4;}
		else if(day.equals("SATURDAY")){count1=5;}
		else if(day.equals("SUNDAY")){count1=6;}
		else {count1=100;}
		Flight.flightline();
		i = sc.next().toUpperCase();
		 if(i.equals("PG215")){count2=0;}
		 else if(i.equals("PG270")){count2=1;}
		 else if(i.equals("PG217")){count2=2;}
		 else if(i.equals("PG906")){count2=3;}
		 else if(i.equals("PG219")){count2=4;}
		 else if(i.equals("PG268")){count2=5;}
		 else if(i.equals("PG221")){count2=6;}
		 else{count2 =199;}
		 if(count1==100||count2==199){
			 System.out.println("error please try again ");
			 Schedule.preface2();
			 mon();
			 return;
		 }
		check=	Allobj[count1][count2].add(count1,count2,count2);max++;
		if (check <0&&max!=1){			
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

				mon[2].add(count1,count2,count2);
			
		}
			if(i.equals("NO"))
				Schedule.main(null);	
	  }
    }
  }




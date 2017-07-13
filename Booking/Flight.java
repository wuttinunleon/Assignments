package Plane;


import java.util.Scanner;


public class Flight {
	BookMain st = new BookMain();
	
	BookMain book = new BookMain();
	Scanner sc = new Scanner(System.in);
	String name ;
//	int i = 0;
	String swap;
	String next;
	String yesNo;
	public static String a[];
	String PG215[] = new String[5];
	String PG270[] = new String[5];
	String PG217[] = new String[5];
	String PG906[] = new String[5];
	String PG219[] = new String[5];
	String PG268[] = new String[5];
	String PG221[] = new String[5];
	String[][] all = { PG215, PG270, PG217, PG906, PG219, PG268, PG221 };

	public  int add(int x, int y,int max) {
		int i=0;
		
		System.out.print("Enter the name : ");
		 Flight.a = sc.nextLine().split(" ");
		int l = a.length;
		if(l>5){
			System.out.println("Can't book (maximun number for booking is 5 )");
			System.out.println("Please try again ");
			add(x,y,y);
			return i;
		}
		for(int count = 0 ; count<5;count++){
			if(st.Allobj[x][y].all[max][count]==null){
			i++;
			}
			
		}
		if(i-a.length<0){
			System.out.println("now have empty seat : "+i+".\nbut you insert :"+a.length+" seats.");
			return i-a.length;
		}
		
		for (int j = 0; j < l; j++) {
			 if(st.Allobj[x][y].all[max][j]==null){
					st.Allobj[x][y].all[max][j] = a[j];
					i++;}
				else{
					for(int count =0;count<5;count++)
						if(st.Allobj[x][y].all[max][count]==null){
							st.Allobj[x][y].all[max][count] = a[j];
							break;
						}
				}
			
		}
		for (String s : st.Allobj[x][y].all[max]) {
			System.out.println(s);
		}
		i=0;
		for(int count = 0 ; count<5;count++){
			if(st.Allobj[x][y].all[max][count]==null){
				i++;
			}
		}
			
		return i;
	}



public static  void flightline() {
		System.out.println("PG215 / out 06:55 / arrive 08:15");
		System.out.println("PG270 / out 10:10 / arrive 11:30");
		System.out.println("PG217 / out 12:00 / arrive 13:20");
		System.out.println("PG906 / out 14:40 / arrive 16:00");
		System.out.println("PG219 / out 16:40 / arrive 18:00");
		System.out.println("PG268 / out 19:00 / arrive 20:20");
		System.out.println("PG221 / out 21:05 / arrive 22:25");
	}

}


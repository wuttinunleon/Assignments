package Plane;

import java.util.Scanner;

public class Change {
	BookMain change = new BookMain();
	BookBack change2 = new BookBack();
	Scanner sc = new Scanner(System.in);
	int iii,jjj,kkk,lll,day1,day2;

	String swap;
	

	void swap1(){
		System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
		System.out.print("Enter the day : ");
		day1 =sc.nextInt();
		System.out.println("PG215(1),PG270(2),PG217(3),PG906(4),PG219(5),PG268(6),PG221(7)");
		System.out.print("Enter the flight : ");
		iii = sc.nextInt();
		System.out.print("Enter the number which  you want to change (1-5) : ");
		jjj = sc.nextInt();
		System.out.println("That is : "+change.Allobj[day1-1][iii-1].all[iii-1][jjj-1]);
		////////////////////////////
		System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
		System.out.print("Enter the new day : ");
		day2=sc.nextInt();
		System.out.println("PG215(1),PG270(2),PG217(3),PG906(4),PG219(5),PG268(6),PG221(7)");
		System.out.print("Enter the flight : ");
		kkk = sc.nextInt();
		System.out.print("Enter the number which  you want to change (1-5) : ");
		lll = sc.nextInt();
		System.out.println("That is : "+change.Allobj[day2-1][kkk-1].all[kkk-1][lll-1]);
		System.out.println("CHANGE SUCCESS!!!!");

		///////////////////////
		swap = change.Allobj[day1-1][iii-1].all[iii-1][jjj-1];
		change.Allobj[day1-1][iii-1].all[iii-1][jjj-1]=change.Allobj[day2-1][kkk-1].all[kkk-1][lll-1];
		change.Allobj[day2-1][kkk-1].all[kkk-1][lll-1]=swap;
	}
	void swap2(){
		System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
		System.out.print("Enter the day : ");
		day1 =sc.nextInt();
		System.out.println("PG222(1),PG216(2),PG224(3),PG907(4),PG226(5),PG220(6),PG228(7)");
		System.out.print("Enter the flight : ");
		iii = sc.nextInt();
		System.out.print("Enter the number which  you want to change (1-5) : ");
		jjj = sc.nextInt();
		System.out.println("That is : "+change2.Allobj2[day1-1][iii-1].all[iii-1][jjj-1]);
		////////////////////////////
		System.out.println("MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7)");
		System.out.print("Enter the new day : ");
		day2=sc.nextInt();
		System.out.println("PG222(1),PG216(2),PG224(3),PG907(4),PG226(5),PG220(6),PG228(7)");
		System.out.print("Enter the flight : ");
		kkk = sc.nextInt();
		System.out.print("Enter the number which  you want to change (1-5) : ");
		lll = sc.nextInt();
		System.out.println("That is : "+change2.Allobj2[day2-1][kkk-1].all[kkk-1][lll-1]);
		System.out.println("CHANGE SUCCESS!!!!");

		///////////////////////
		swap = change2.Allobj2[day1-1][iii-1].all[iii-1][jjj-1];
		change2.Allobj2[day1-1][iii-1].all[iii-1][jjj-1]=change2.Allobj2[day2-1][kkk-1].all[kkk-1][lll-1];
		change2.Allobj2[day2-1][kkk-1].all[kkk-1][lll-1]=swap;
	}


}

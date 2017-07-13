package Plane;


import java.util.Scanner;

public class Schedule {
	
	public static void main(String[] args) {
		BookMain BookMain = new BookMain();
		Change ch = new Change();
		Cancel canc = new Cancel();
		BookBack bk = new BookBack();
		String n;
		Scanner sc = new Scanner(System.in);
		for (int z = 0;; z++) {
			preface1();
			n = sc.next().toUpperCase();
			if (n.equals("BOOK")){
				preface2();
				BookMain.mon();
				bk.mon2();
			}
			else if(n.equals("CHANGE")){
				System.out.print("Go or Back : ");
				n=sc.next().toUpperCase();
				if(n.equals("GO"))
				ch.swap1();
				else if (n.equals("BACK"))
				ch.swap2();
			}
			else if(n.equals("CANCEL")){
				canc.Canc();
			}
		}
	}
	public static void preface2() {
		System.out.println("CHOOSE DAY : ");
		System.out.println("MONDAY , TUESDAY , WEDNESDAY , THURSDAY , FRIDAY , SATURDAY , SUNDAY");
	}

	public static void preface1() {
		System.out.println("///CHOOSE/// ");
		System.out.println("-BOOK");
		System.out.println("-CHANGE");
		System.out.println("-CANCEL");

	}

}


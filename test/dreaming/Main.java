package dreaming;

import java.util.Scanner;

public class Main {
	private static Scanner cin = new Scanner(System.in) ;
	public static void main(String[] args) {
		int N = cin.nextInt() ;
		if(N <= 3){
			System.out.println("NO");
			return ;
		}
		System.out.println("YES");
		if(N % 2 == 0){
			System.out.println("1 * 2 = 2");
			System.out.println("2 * 3 = 6");
			System.out.println("4 * 6 = 24");
			for(int i = 5 ; i <= N ; i += 2){
				System.out.println((i + 1) + " - " + i + " = " + "1" );
				System.out.println("1 * 24 = 24");
			}
		}else{
			System.out.println("2 * 4 = 8");
			System.out.println("3 * 5 = 15");
			System.out.println("8 + 15 = 23");
			System.out.println("1 + 23 = 24");
			for(int i = 6 ; i <= N ; i += 2){
				System.out.println( (i + 1) + " - " + i + " = 1" );
				System.out.println("1 * 24 = 24");
			}
		}
	}
}

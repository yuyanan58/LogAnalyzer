package LogTree;

import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = null;
		System.out.println("请输入您想输入的字符串：");
		str = s.nextLine();
		Fenci Fen = new Fenci();
		String[] i = Fen.fenci(str);
	}
}
package LogTree;

import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String str = null;
		System.out.println("����������������ַ�����");
		str = s.nextLine();
		Fenci Fen = new Fenci();
		String[] i = Fen.fenci(str);
	}
}
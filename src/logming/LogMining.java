package logming;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import logtree.LogTree;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.pku.yhf.EclatRelease;

/**
 * LogMining
 * 
 * @author onion
 * 
 */

public class LogMining {
	private String[] logMiningString ;
	private JSONObject logMinJsonObject;
	private String logPath = null ;
	private File file = null;
	private static final boolean DEBUG = false ;
	/**
	 * 得到分析后的日志的JSON字符串。
	 * 
	 * @return
	 */
	public String[] getLogMiningString(){
		return this.logMiningString;
	}
	public String getLogMinJson() {
		return logMinJsonObject.toString();
	}

	/**
	 * 构造方法，传入一个日志的路径。
	 * 
	 * @param path
	 */
	public LogMining(String path) {
		System.out.println(path);
		this.logPath = path;
		file = new File(this.logPath);
		gao();
		System.out.println(LogMining.class.getResource("/"));
	}

	private void gao() {
		System.err.println("gao is BEGIN");
		LogTree t = new LogTree();
		String str[][] = t.logtree(file);
		String An[][] = new String[50][2];
		int numm = 0;
		for (int i = 0; i < str.length; i++) {
			int cout = 1;
			for (int j = 0; j < numm; j++) {
				if (An[j][0].contentEquals(str[i][1])) {
					cout = 0;
				}
			}
			if (cout == 1) {
				An[numm][0] = str[i][1];
				An[numm++][1] = str[i][0];
			}
		}
		for (int i = 0; i < numm; i++) {
			System.out.print("R : ");
			System.out.println(An[i][1]);
		}

		try {
			logMinJsonObject = new JSONObject();
			{
				logMinJsonObject.put("Count", numm);
				logMiningString = new String[numm] ;
				JSONArray logMinArray = new JSONArray();
				for (int i = 0; i < numm; i++) {
					logMinArray.add(i, An[i][1]);
					logMiningString[i] = An[i][1] ; 
				}
				logMinJsonObject.accumulate("resList", logMinArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(logMinJsonObject.toString());
		System.err.println("gao is END");
	}

	public void test() throws IOException {
		File file = new File("a.log");
		LogTree t = new LogTree();
		String str[][] = t.logtree(file);
		String An[][] = new String[50][2];
		int numm = 0;
		for (int i = 0; i < str.length; i++) {
			int cout = 1;
			for (int j = 0; j < numm; j++) {
				if (An[j][0].contentEquals(str[i][1])) {
					cout = 0;
				}
			}
			if (cout == 1) {
				An[numm][0] = str[i][1];
				An[numm++][1] = str[i][0];
			}
		}
		for (int i = 0; i < numm; i++) {
			System.out.print("R : ");
			System.out.println(An[i][1]);
		}

		File tempFile = new File("mushroom.dat.txt");
		if (tempFile.exists()) {
			tempFile.delete();
		}
		tempFile.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		int num = 0, hour = 0, minute = 0, second = 0;

		do {
			String f[] = str[num][0].split(" ");
			int nu = 0;
			while (f[nu].indexOf(":") == -1) {
				nu++;
			}
			String ti[] = f[nu].split(":");
			if (hour == 0 && minute == 0 && second == 0) {
				hour = Integer.parseInt(ti[0]);
				minute = Integer.parseInt(ti[1]);
				second = Integer.parseInt(ti[2]);
				bw.write(str[num][1] + " ");
				num++;
			} else {
				if (((hour + 1) % 24 - Integer.parseInt(ti[0]) == 1)
						|| (((hour + 1) % 24 - Integer.parseInt(ti[0]) == 0) && (minute
								- Integer.parseInt(ti[1]) > 0))
						|| (((hour + 1) % 24 - Integer.parseInt(ti[0]) == 0)
								&& (minute - Integer.parseInt(ti[1]) == 0) && (second
								- Integer.parseInt(ti[2]) >= 0))) {
					bw.write(str[num][1] + " ");
					num++;
				} else {
					bw.write("\r\n");
					bw.write(str[num][1] + " ");
					hour = Integer.parseInt(ti[0]);
					minute = Integer.parseInt(ti[1]);
					second = Integer.parseInt(ti[2]);
					num++;
				}
			}
		} while (num < str.length);

		bw.flush();
		EclatRelease ec = new EclatRelease();
		ec.eclat(tempFile);

		RandomAccessFile raf = new RandomAccessFile("mushroom.dat.txt.dat", "r");
		long len = raf.length();
		String lastLine = "";
		if (len != 0L) {
			long pos = len - 1;
			while (pos > 0) {
				pos--;
				raf.seek(pos);
				if (raf.readByte() == '\n') {
					lastLine = raf.readLine();
					break;
				}
			}
		}
		raf.close();
		System.out.println(lastLine);
		String lL[] = lastLine.split(" ");
		/*
		 * 频繁事件数目
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < numm; j++) {
				if (An[j][0].contentEquals(lL[i])) {
					System.out.print("T : ");
					System.out.println(An[j][1]);
				}
			}
		}

	}
}
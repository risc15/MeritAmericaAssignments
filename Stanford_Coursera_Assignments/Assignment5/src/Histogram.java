import java.io.*;

public class Histogram {
	private static int[] scores = new int[11];
	private static String tempString = "";
	
	public static void main(String[] args) {
		try {
			File midtermScores = new File("MidtermScores.txt");
			FileReader fileScan = new FileReader(midtermScores);
			BufferedReader bufferRead = new BufferedReader(fileScan);
			
			while ((tempString = bufferRead.readLine()) != null) {
				int score = Integer.parseInt(tempString);

				if (score < 10) {
					scores[0]++;
				} else if (score < 20) {
					scores[1]++;
				} else if (score < 30) {
					scores[2]++;
				} else if (score < 40) {
					scores[3]++;
				} else if (score < 50) {
					scores[4]++;
				} else if (score < 60) {
					scores[5]++;
				} else if (score < 70) {
					scores[6]++;
				} else if (score < 80) {
					scores[7]++;
				} else if (score < 90) {
					scores[8]++;
				} else if (score < 100) {
					scores[9]++;
				} else if (score == 100) {
					scores[10]++;
				}
			} 
			
			System.out.println("00-09: " + scoreString(scores[0]));
			System.out.println("10-09: " + scoreString(scores[1]));
			System.out.println("20-09: " + scoreString(scores[2]));
			System.out.println("30-09: " + scoreString(scores[3]));
			System.out.println("40-09: " + scoreString(scores[4]));
			System.out.println("50-09: " + scoreString(scores[5]));
			System.out.println("60-09: " + scoreString(scores[6]));
			System.out.println("70-79: " + scoreString(scores[7]));
			System.out.println("80-89: " + scoreString(scores[8]));
			System.out.println("90-99: " + scoreString(scores[9]));
			System.out.println("100  : " + scoreString(scores[10]));
			bufferRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Incorrect type.");
		}
	}
	
	public static String scoreString(int x) {
		String scoreList = "";
		for (int i = 0; i < x; i++) {
			scoreList += "*";
		}
		return scoreList;
	}
	
}

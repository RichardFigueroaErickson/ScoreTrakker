import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		int score = 0;
		students =new ArrayList<Student>();
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine();
			String scoreStr = in.nextLine();
			try {
				score = Integer.parseInt(scoreStr);
				Student pat = new Student(name, score);
				students.add(pat);
			} catch(NumberFormatException e) {
				System.out.println("Error, the Student " + name + " does not have a valid score (" + scoreStr + ")");
			}
		}
		in.close();
	}

	public void printInOrder() {
		Collections.sort(students);
		for(Student s: students) {
			System.out.println(s);
		}
	}

	public void processFiles(){
		for(String a: files) {
			try {
				loadDataFromFile(a);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("File " + a + " not found");
			}
		}
	}

	public static void main(String[] args) {
		ScoreTrakker results = new ScoreTrakker();
		results.processFiles();
	}


}

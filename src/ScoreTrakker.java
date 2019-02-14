/*
 * @authors: Richard Figueroa Erickson, Dalton Blanchard
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	public void loadDataFromFile(String fileName) throws FileNotFoundException {//Throw clause will throw any exceptions 
																				//back to ProcessFiles if a files is not found.
		int score = 0;
		students = new ArrayList<Student>(); //Clears the array with each new file
		FileReader reader = new FileReader(fileName); //Opens the file
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String name = in.nextLine(); //takes in the name of the student from one line
			String scoreStr = in.nextLine();//takes in the score from another
			try {
				score = Integer.parseInt(scoreStr);
				Student pat = new Student(name, score);//new student made and added to ArrayList
				students.add(pat);
			} catch(NumberFormatException e) {
				System.out.println("Error, the Student " + name + " does not have a valid score (" + scoreStr + ") \n");
			}
		}
		in.close();
	}

	public void printInOrder() {
		Collections.sort(students); // sort the students by name
		System.out.println("Student Score List" );
		for(Student s: students) {
			System.out.println(s);//loops and prints all students
		}
		System.out.println();
	}

	public void processFiles(){
		for(String a: files) {
			try {
				loadDataFromFile(a);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("File " + a + " not found \n");
			}
		}
	}

	public static void main(String[] args) {
		ScoreTrakker results = new ScoreTrakker();
		results.processFiles();
	}


}

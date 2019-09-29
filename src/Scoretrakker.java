import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scoretrakker {
	private ArrayList <Student> students;
	private String[] fileNames;
	public Scoretrakker() {
		super();
		students = new ArrayList<Student>();
		fileNames = new String[] {"scores.txt", "badscore.txt", "nofile.txt"};
		// TODO Auto-generated constructor stub
	}
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException{
		FileReader reader = new FileReader(fileName);
		Scanner scan = new Scanner(reader);
		
		String line = "";
		String score = "";
		
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			score = scan.nextLine();
			try {
				students.add(new Student(line, Integer.parseInt(score)));
			}
			catch (NumberFormatException e) {
				System.out.println("Error: " + line + "has an invalid score: " + score);
			}
			
		}
		scan.close();
		
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		for(String fileName: fileNames) {
			System.out.println("\n File begin \n");
			try {
			loadDataFromFile(fileName);
			printInOrder();
			}
			catch(FileNotFoundException e){
				System.out.println("could not find file");
			}
		
		}
	}

	public static void main(String[] args) {
		Scoretrakker tracker = new Scoretrakker();
		tracker.processFiles();
	}
}

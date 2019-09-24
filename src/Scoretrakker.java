import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scoretrakker {
	private ArrayList <Student> students;
	public Scoretrakker() {
		super();
		students = new ArrayList<Student>();
		// TODO Auto-generated constructor stub
	}
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException{
		FileReader reader = new FileReader(fileName);
		Scanner scan = new Scanner(reader);
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			int score = scan.nextInt();
			students.add(new Student(line, score));
		}
		
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		loadDataFromFile("scores.txt");
		printInOrder();
	}

	public static void main(String[] args) {
		Scoretrakker tracker = new Scoretrakker();
		tracker.processFiles();
	}
}

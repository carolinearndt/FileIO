
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	public Student (String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int compareTo(Student student2) {
		return this.score - student2.getScore();
	}

	@Override
	public String toString() {
		return name +" "+ score;
	}
	
	
}

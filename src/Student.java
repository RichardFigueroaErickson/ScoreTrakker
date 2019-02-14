
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	@Override
	public String toString() {
		return name + " " + score;
	}
	@Override
	public int compareTo(Student arg0) {
		return this.name.compareTo(arg0.getName());
	}
	public String getName() {
		return name;
	}
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
		
	}


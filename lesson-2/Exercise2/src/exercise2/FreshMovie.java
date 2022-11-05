package exercise2;

import java.util.ArrayList;
import java.util.List;

public class FreshMovie implements Movie {

	public String title;
	private String author;
	private List<Double> grades = new ArrayList<>();
	
	public FreshMovie(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String giveGrade(double grade) {

		grades.add(grade);
		
		// ADDING SOME GRADES SO THE APPLICATION HAS DATA TO CALCULATE AVERAGE GRADE
		grades.add(6.0);
		grades.add(7.0);
		grades.add(9.0);
		grades.add(4.0);
		grades.add(5.0);
		
		double tmp = 0;
		double average = 0;
		if(grades.size() > 0) {
			for (int i=0; i<grades.size(); i++) {
				if(i == 0)
					tmp = grades.get(i);
				else
					tmp += grades.get(i);
			}
			average = tmp/grades.size();
		}
		
		return "Movie: " + this.title 
				+ "\nAuthor: " + this.author 
				+ "Your grade: " + grade 
				+ "\nAverage grade for this movie: " + average;
	}

}

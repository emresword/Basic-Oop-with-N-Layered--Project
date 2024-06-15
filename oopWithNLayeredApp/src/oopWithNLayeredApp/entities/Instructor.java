package oopWithNLayeredApp.entities;

public class Instructor {
 private String instructorName;
 private String instructorSurname;
 private int instructorAge;

 
public Instructor() {

}

public Instructor(String instructorName, String instructorSurname, int instructorAge) {
	
	this.instructorName = instructorName;
	this.instructorSurname = instructorSurname;
	this.instructorAge = instructorAge;
}

public String getInstructorName() {
	return instructorName;
}
public void setInstructorName(String instructorName) {
	this.instructorName = instructorName;
}
public String getInstructorSurname() {
	return instructorSurname;
}
public void setInstructorSurname(String instructorSurname) {
	this.instructorSurname = instructorSurname;
}
public int getInstructorAge() {
	return instructorAge;
}
public void setInstructorAge(int instructorAge) throws Exception {
	if(this.instructorAge<18) {
		throw new Exception("Instructor's age isnt lower than 18"); 
	}
	this.instructorAge = instructorAge;
}
}
 


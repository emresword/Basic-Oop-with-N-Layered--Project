package oopWithNLayeredApp.entities;

public class Course {
private int courseTime;
private int coursePrice;
private String courseName;
private String courseType;

public Course() {
	
}

public Course(int courseTime, int coursePrice, String courseName, String courseType) {
	
	this.courseTime = courseTime;
	this.coursePrice = coursePrice;
	this.courseName = courseName;
	this.courseType = courseType;
}

public int getCourseTime() {
	return courseTime;
}

public void setCourseTime(int courseTime) {
	this.courseTime = courseTime;
}

public int getCoursePrice() {
	return coursePrice;
}

public void setCoursePrice(int coursePrice) throws Exception {
	if(this.coursePrice<0) {
		throw new Exception("price of course isn't lower than '0' ");
	}
	this.coursePrice = coursePrice;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getCourseType() {
	return courseType;
}

public void setCourseType(String courseType) {
	this.courseType = courseType;
}



}

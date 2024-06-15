package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Course;

public class CourseDao {
public void add(Course course) {
	System.out.println(course.getCourseName()+ " course was added");
}
public void delete(Course course) {
	System.out.println(course.getCourseName()+ " course was deleted");
}
public void update(Course course) {
	System.out.println(course.getCourseName()+ " course was updated");
}
}

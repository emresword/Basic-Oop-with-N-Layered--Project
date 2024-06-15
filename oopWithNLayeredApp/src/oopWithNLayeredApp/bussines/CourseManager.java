package oopWithNLayeredApp.bussines;

import java.util.ArrayList;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.CourseDao;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.tools.Orm;

public class CourseManager {
private CourseDao courseDao;
private ArrayList<Logger> loggers;
private Orm orm;
private ArrayList<Course> courses;
public CourseManager(CourseDao courseDao,ArrayList<Logger> loggers,Orm orm,ArrayList<Course> courses) {
	this.courseDao=courseDao;
	this.courses=courses;
	this.loggers=loggers;
	this.orm=orm;
}
//instructor classına uygulanan add delete ve udate metotdalarını aynı şekilde burayada uygulanır
public void add(Course course) throws Exception {
	for(Course course2:courses) {
		if(course2.getCourseName()==course.getCourseName()) {
			throw new Exception("this course was already added");
		}
	}
		orm.add();
		courses.add(course);
		courseDao.add(course);
	
	for(Logger logger:loggers) {
	logger.log(course.getCourseName());
	}
}
public void delete(Course course) {
	for(Course course2:courses) {
		if(course2.getCourseName()==course.getCourseName()) {
		 courseDao.delete(course);
		 courses.remove(course);
		 break;
		}
		
	}
}
}

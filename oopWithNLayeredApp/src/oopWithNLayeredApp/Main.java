package oopWithNLayeredApp;

import java.util.ArrayList;
import java.util.List;

import oopWithNLayeredApp.bussines.CourseManager;
import oopWithNLayeredApp.bussines.InstructorManager;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.CourseDao;
import oopWithNLayeredApp.dataAccess.InstructorDao;
import oopWithNLayeredApp.entities.Instructor;
import oopWithNLayeredApp.tools.Jdbc;
import oopWithNLayeredApp.tools.Orm;
import oopWithNLayeredApp.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Logger>loggers=new ArrayList<>();
		loggers.add(new MailLogger());
		loggers.add(new FileLogger());
		Orm orm=new Jdbc();
		
		
		Course course1 = new Course();
  		course1.setCourseName("Java");
  		course1.setCoursePrice(2);
  		course1.setCourseTime(250);
  		course1.setCourseType("Yazılım Geliştirme");

  		Course course2 = new Course();
  		course2.setCourseName("JS");
  		course2.setCoursePrice(3);
  		course2.setCourseTime(250);
  		course2.setCourseType("Yazılım Geliştirme");
  		
  		CourseDao courseDao=new CourseDao();
  		
  		
  		ArrayList<Course>courses=new ArrayList<>();
  		
  		
  		
  		//CourseDao courseDao,ArrayList<Logger> loggers,Orm orm,ArrayList<Course> courses
  		
		Instructor instructor=new Instructor("emre", "kılıc", 21 );
		Instructor instructor1=new Instructor("emo", "kılıc", 20);
		Instructor instructor2=new Instructor("silinen", "kılıc", 12);
		InstructorDao instructorDao=new InstructorDao();
		
		
		List<Instructor>instructors=new ArrayList<>();
		
		InstructorManager instructorManager=new InstructorManager(instructors,orm,loggers , instructorDao);
		instructorManager.add(instructor1);
		instructorManager.add(instructor);
		
		instructorManager.delete(instructor1);
		instructorManager.update(instructor1);

	}

}

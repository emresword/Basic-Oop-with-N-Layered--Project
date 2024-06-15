package oopWithNLayeredApp.dataAccess;

import java.util.Scanner;

import oopWithNLayeredApp.entities.Instructor;

public class InstructorDao  {

	public void add(Instructor instructor) {
		System.out.println(instructor.getInstructorName()+" instructor was added");
	}
	public void delete(Instructor instructor) {
		System.out.println(instructor.getInstructorName()+" instructor was deleted");
		
	}
	public void update(Instructor instructor) throws Exception  {
		System.out.println("Instructor is update. new Instructor is"+instructor.getInstructorName());
		
	}
	
	
}

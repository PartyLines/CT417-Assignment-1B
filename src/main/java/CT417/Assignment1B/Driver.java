package CT417.Assignment1B;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import CT417.Assignment1A.*;

public class Driver {
	private static DateTimeFormatter dateTimeOut = DateTimeFormat.forPattern("dd MMM yyyy");
	
	public static void main(String[] args) {
		Course mockCourseOne = new Course();
		mockCourseOne.setStartDate(new DateTime(0).withDate(2000, 9, 1));
		mockCourseOne.setEndDate(new DateTime(0).withDate(2004, 4, 30));
		mockCourseOne.setName("Computer Science and Information Technology");
		
		Course mockCourseTwo = new Course();
		mockCourseTwo.setStartDate(new DateTime(0).withDate(2000, 9, 1));
		mockCourseTwo.setEndDate(new DateTime(0).withDate(2004, 5, 2));
		mockCourseTwo.setName("Computer Maintenance and Engineering");
		
		Module moduleOne = new Module();
		moduleOne.setId("CSIT1");
		moduleOne.setName("Software Engineering");
		
		Module moduleTwo = new Module();
		moduleTwo.setId("CSIT2");
		moduleTwo.setName("Hardware Engineering");
		
		Module moduleThree = new Module();
		moduleThree.setId("CSIT3");
		moduleThree.setName("Firmware Engineering");
		
		Student firstStudent = new Student();
		firstStudent.setId("1");
		firstStudent.setName("Wally Walker");
		firstStudent.setDateOfBirth(new DateTime(0).withDate(1980, 6, 11));
		
		Student secondStudent = new Student();
		secondStudent.setId("2");
		secondStudent.setName("April Mason");
		secondStudent.setDateOfBirth(new DateTime(0).withDate(1981, 4, 30));
		
		Student thirdStudent = new Student();
		thirdStudent.setId("3");
		thirdStudent.setName("Briain Gleeson");
		thirdStudent.setDateOfBirth(new DateTime(0).withDate(1979, 12, 9));
		
		Student fourthStudent = new Student();
		fourthStudent.setId("4");
		fourthStudent.setName("Maisie May");
		fourthStudent.setDateOfBirth(new DateTime(0).withDate(1980, 5, 5));
		
		Student fifthStudent = new Student();
		fifthStudent.setId("5");
		fifthStudent.setName("Gary Gray");
		fifthStudent.setDateOfBirth(new DateTime(0).withDate(1981, 10, 20));
		

		moduleOne.addStudents(firstStudent, secondStudent, fourthStudent);
		moduleTwo.addStudents(secondStudent, fourthStudent, fifthStudent);
		moduleThree.addStudents(thirdStudent, fourthStudent);
		
		mockCourseOne.addModules(moduleOne, moduleTwo);
		mockCourseTwo.addModules(moduleTwo, moduleThree);
		
		mockCourseOne.addStudents(firstStudent, secondStudent, fourthStudent);
		mockCourseTwo.addStudents(thirdStudent, fourthStudent, fifthStudent);
		
		//Printing out the produced objects
		
		System.out.println("Created the following Courses:");
		printCourse(mockCourseOne);
		printCourse(mockCourseTwo);
		
		System.out.println("Created the following Students:");
		printStudent(firstStudent);
		printStudent(secondStudent);
		printStudent(thirdStudent);
		printStudent(fourthStudent);
		printStudent(fifthStudent);
		

	}
	
	private static void printCourse(Course c) {
		//prints out course with respective modules
		System.out.printf("Course name: %s\n" +
				"Starts %s\n" +
				"Ends %s\n" +
				"Has the following modules:\n",
				c.getName(), dateTimeOut.print(c.getStartDate()), dateTimeOut.print(c.getEndDate()));
		
		for(Module m : c.getModules()) {
			System.out.println("\t-" + m.getName() + " (ID: " + m.getId() + ")");
		}
		System.out.println();
	}
	
	private static void printStudent(Student s) {
		//Print out student with modules and Courses
		System.out.printf("Student username: %s\n" +
				"Has the following modules:\n",
				s.getUsername());
		
		for(Module m : s.getModules()) {
			System.out.println("\t-" + m.getName() + " (ID: " + m.getId() + ")");
		}
		System.out.println("Enrolled in the following course(s)");
		for(Course c: s.getCourses()) {
			System.out.println("\t-" + c.getName());
		}
		System.out.println();
	}
}

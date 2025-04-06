import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CourseDBManager_STUDENT_Test {
	
	private CourseDBManager cdb;
	private ArrayList<String> courses;
	
	@BeforeEach
	public void setUp() throws Exception {
		cdb = new CourseDBManager();
		courses = new ArrayList<String>();
	}
	

	@AfterEach
	public void tearDown() throws Exception {
		cdb = null;
		courses = null;
	}

	@Test
	public void testAdd() {
		cdb.add("TEST101", 12345, 3,"SC100", "Mr.Test");
		courses = cdb.showAll();
		assertEquals(1,courses.size());
		cdb.add("CHEM131", 20567, 4,"SC323", "Zues De los Santos");
		cdb.add("MATH182", 21104, 3,"SW114", "Benjamin Tsai");
		courses = cdb.showAll();
		assertEquals(3,courses.size());
	}
	
	@Test
	public void testGet() {
		cdb.add("TEST101", 56934, 3,"SC100", "Mr.Test");
		cdb.add("JAPN101", 43256, 4, "REMOTE", "Nobue Yamabayashi");
		try {
			assertEquals(56934,cdb.get(56934).getCRN());
			assertEquals(43256,cdb.get(43256).getCRN());
			} catch(Exception e) {
			fail("Should have not thrown an exception");
		}
	}
	
	@Test
	public void testReadFile() {
		File studentCourses = new File("StudentCourses.txt");
		File nonExStudentCourses = new File("nonExStudentCourses.txt");

		try {
			cdb.readFile(nonExStudentCourses);
			fail("should have thrown FileNotFoundException");
		} catch(FileNotFoundException e) {
			assertTrue("Succesfully threw FileNotFoundException",true);
		}
		
		try {
			PrintWriter writer = new PrintWriter(studentCourses);
			writer.println("CMSC204 20106 4 SW204 David Kuijt");
			writer.println("MATH284 20143 4 HS314 Stephen Wheatly");
			writer.println("POLI101 35608 3 Distance-Learning Barack Obama");
			writer.println("POLI101 35607 3 Distance Learning Donald J. Trump");
			writer.println("LGST106 35655 3 HS108 Saul Goodmen"); 
			writer.print("ENGL101 20451 3 PK102 Jorinde van den Berg");
			writer.close();
			cdb.readFile(studentCourses);
			assertEquals("CMSC204",cdb.get(20106).getID());
			assertEquals("Saul Goodmen",cdb.get(35655).getInstructor());
			assertEquals("Distance-Learning",cdb.get(35608).getRoomNum());
			assertEquals("PK102",cdb.get(20451).getRoomNum());
			assertEquals("Jorinde van den Berg",cdb.get(20451).getInstructor());
			assertEquals("Distance-Learning",cdb.get(35608).getRoomNum());
			assertEquals("Distance Learning",cdb.get(35607).getRoomNum());
			assertEquals(4,cdb.get(20143).getCredits());
			assertEquals("MATH284",cdb.get(20143).getID());
	
		} catch (FileNotFoundException e) {
			fail("Should have not thrown an exception");
		}
		
		
	}
	
	@Test
	public void testShowAll() {
		cdb.add("POLI101", 35607, 3, "Distance Learning", "Donald J. Trump");
		cdb.add("POLI101" ,35608, 3 ,"Distance-Learning", "Barack Obama");
		courses = cdb.showAll();
		assertEquals(2,courses.size());
		assertEquals("\nCourse:POLI101 CRN:35608 Credits:3 Instructor:Barack Obama Room:Distance-Learning",courses.get(1));
		assertEquals("\nCourse:POLI101 CRN:35607 Credits:3 Instructor:Donald J. Trump Room:Distance Learning",courses.get(0));
		cdb.add("CMSC204", 20106, 4, "SW204", "David Kuijt");
		courses = cdb.showAll();
		assertEquals(3,courses.size());
		assertEquals("\nCourse:CMSC204 CRN:20106 Credits:4 Instructor:David Kuijt Room:SW204",courses.get(2));
	}

}

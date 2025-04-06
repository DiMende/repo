import java.io.*;
import java.util.*;
/**
 * This class manages the CourseDBStuctor class so that the user
 * can input files and courses to the data base with a UI.
 * 
 * CourseDBManager has one attribute which acts as the data base of the 
 * course.
 * - cdb(CourseDBStructure)
 * 
 * {@code CourseDBManager} implements {@code CourseDBManagerInterface}
 * @author Diego Mendez
 */
public class CourseDBManager implements CourseDBManagerInterface{
	
	private CourseDBStructure cdb;
	
	/**
	 * Initializes cdb with a default size of ten.
	 * 
	 */
	public CourseDBManager() {
		cdb = new CourseDBStructure(10);
	}
	
	/**
	 * Initializes cdb with a specified integer which will be the size
	 * of the course data base
	 * @param n the size of the course data base
	 */
	public CourseDBManager(int n) {
		cdb = new CourseDBStructure(n);
	}
	
	/**
	 * creates a {@code CourseDBElement} object then adds it to the cdb using the cbd's add method.
	 * 
	 * @param id course ID of the course
	 * @param crn unique CRN number of the course 
	 * @param credits the amount of credits the course is worth
	 * @param roomNum the room number of the course
	 * @param instructor the instructor of the course
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement course = new CourseDBElement(id,crn,credits,roomNum,instructor);
		cdb.add(course);
	}
	
	
	/**
	 * Using the cdb getter method to retrieve the course with the exact crn. If there is none, then the getter method
	 * throws an exception which is handled in the CourseDBManager getter method and returns null.
	 * 
	 * @return course the course that was fetch, if there is no such course, then the get method will throw
	 * an exception, which will be caught so that the method returns null. 
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			CourseDBElement course = cdb.get(crn);
			return course;
		}catch(IOException e) {
			return null;
		}
	}
	
	/**
	 * Reads course data from the given input file and adds it to the cdb.	
	 * 
	 * The method first checks if the input file exists, if not,
	 * FileNotFoundException is thrown.
	 * 
	 * If the file exist, then the file is read line by line using BufferedReader
	 * to extract each of the five course attributes.
	 * 
	 * Using a while loop, the reader calls readLine and stores the file line in a string
	 * variable called line. If the line is null, the while loop breaks.
	 * 
	 * As the reader goes through the file line by line, the index of the spaces
	 * are used to find each of the 5 attributes that make up a course.
	 * 
	 *Using j as a counter for how many times the loop has passed over a space,
	 *the loop adds each one of the attributes to their respective since the file format 
	 *will always have the attributes in the same order: course id, crn,credits, room number, then
	 *instructor.
	 *
	 *The line, using the substring method, pushes over the space to continue reading through the line. 
	 * 
	 *Since crn and credits are integers, the strings are converted back to their integer state
	 *so that they can be created as a CourseDBElement and added to the cdb.
	 *
	 *If after the 4 space there is "learning" word, meaning in the line has "Distance learning" 
	 *as the room number, so it is stored in the roomNum variable. 
	 *
	 *If not, then the last few words are added as the instructors name.
	 *
	 * After the inner while loop is passed, the a CourseDBElement created and stored in the cdb with the variables that have the 
	 * 5 attributes.
	 * Instructor is rest to an empty string, so is room number, and j is set back to 0.
	 * 
	 * After the entire outter while loop is done, reader is closed.
	 * 
	 * If there are any IOExceptions are thrown within the loop, then the exception is caught 
	 * and FileNotFoundException is thrown instead.
	 * 
	 * 
	 * 
	 * @param input the file that contains course data
	 * @throws FileNotFoundException if the file is null or cannot be open
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		
		if(input == null)
			throw new FileNotFoundException();
		
		BufferedReader reader = new BufferedReader( new FileReader(input)); 
		
		String courseID = "",instructor = "",roomNum = "";
		int crn = 0,credits = 0,j = 0;
		
		try {
			String line = "";
			while((line = reader.readLine()) != null) {
				while(line.indexOf(" ") != -1){
					if(j == 0)
						courseID = line.substring(0,line.indexOf(" "));
					else if(j == 1)
						crn = Integer.valueOf( line.substring(0,line.indexOf(" ")) );
					else if(j == 2)
						credits = Integer.valueOf(line.substring(0,line.indexOf(" ")));
					else if(j == 3)
						roomNum = line.substring(0,line.indexOf(" "));
					else {
						if(line.substring(0,line.indexOf(" ")).toLowerCase().equals("learning") )
							roomNum += " " + line.substring(0,line.indexOf(" "));
						else 
							instructor += line.substring(0,line.indexOf(" ")) + " ";
					}
					
					line = line.substring(line.indexOf(" ")+1);
					j++;
				}
				instructor += line.substring(0);
				cdb.add(new CourseDBElement(courseID,crn,credits,roomNum,instructor));
				instructor = "";
				roomNum = "";
				j = 0;
			}
			
			reader.close();	
			
		} catch(IOException e) {
			throw new FileNotFoundException();
		}
		
	}
	/**
	 * calls the cdb showAll method to return a string array list of the
	 * courses in the cdb.
	 * 
	 * @return cdb.showAll() a list of courses in the cdb.
	 */
	@Override
	public ArrayList<String> showAll() {
		return cdb.showAll();
	}

}

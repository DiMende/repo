/**
 * Represents a course with 5 attributes: 
 * - courseID: The course ID (String).
 * - roomNum: The room number (String).
 * - instructor: The instructor's name (String).
 * - crn: The unique course registration number (int).
 * - credits: The number of credits the course is worth (int).
 * CourseDBElement implements the {@code Comparable} interface. 
 * @author Diego Mendez
 * 
 */
public class CourseDBElement implements Comparable<CourseDBElement> {
	
	private String courseID,roomNum,instructor;
	private int crn,credits;
	
	/**
	 * Constructs a {@code CourseDBElement} object with the 5 specified attributes: the courseID,crn,credits, roomNum, and instructor
	 *  
	 * @param courseID course ID of the course
	 * @param crn unique CRN number of the course 
	 * @param credits the amount of credits the course is worth
	 * @param roomNum the room number of the course
	 * @param instructor the instructor of the course
	 */
	public CourseDBElement(String courseID, int crn,int credits,String roomNum,String instructor) {
		this.courseID = courseID;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	/**
	 * Initializes a {@code CourseDBElement} object with default values 
	 */
	public CourseDBElement() {
		courseID = null;
		roomNum = null;
		instructor = null;
		crn = 0;
		credits = 0;
	}
	/**
	 * sets the unique crn of the course of this {@code CourseDBElement}  
	 * @param n crn of the course
	 */
	public void setCRN(int n) {
		crn = n;
	}
	/**
	 * sets the number credits the course is worth of this {@code CourseDBElement} 
	 * @param n the number of credits for the course
	 */
	public void setCredits(int n) {
		credits = n;
	}
	/**
	 * sets the course ID of the course of this {@code CourseDBElement}
	 * @param s courseID of the course
	 */
	public void setCourseID(String s) {
		courseID = s;
	}
	/**
	 * sets the room number of the course of this {@code CourseDBElement}
	 * @param s room number of the course 
	 */
	public void setRoomNum(String s) {
		roomNum = s;
	}
	/**
	 * sets the instructor of the course of this {@code CourseDBElement}
	 * @param s the instructor of the course
	 */
	public void setInstructor(String s) {
		instructor = s;
	}
	
	/**
	 * returns the crn of the course 
	 * @return crn the crn of the course
	 */
	public int getCRN() {
		return crn;
	}
	/**
	 * returns the course ID of the course 
	 * @return courseID the course ID of the course
	 */
	public String getID() {
		return courseID;
	}
	/**
	 * returns the amount of credits the course is worth
	 * @return credits the credits of the course
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * returns the room number of the course 
	 * @return roomNum the room number of the course
	 */
	public String getRoomNum() {
		return roomNum; 
	}
	/**
	 * returns the instructor of the course 
	 * @return instructor returns the instructor of the course
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * compareTo overrides the comparable compareTo Method.
	 * the method checks through each attribute of this {@code CourseDBElement} and the specified {@code CourseDBElement}
	 * if both {@code CourseDBElement} objects are exactly the same, the method will return 0, otherwise the method will return
	 * an integer > 0 or < 0 depending if the specified {@code CourseDBElement} is larger or smaller than this {@code CourseDBElement}
	 */
	@Override
	public int compareTo(CourseDBElement o) {
		
		int courseIDCompare = this.courseID.compareTo(o.courseID);
		if(courseIDCompare != 0) 
			return courseIDCompare;
		int crnCompare = this.crn-o.crn;
		if(crnCompare != 0)
			return crnCompare;
		int creditsCompare = this.credits-o.credits;
		if(creditsCompare != 0)
			return creditsCompare;
		int roomNumCompare = this.roomNum.compareTo(o.roomNum);
		if(roomNumCompare != 0)
			return roomNumCompare;
		int instructorCompare = this.instructor.compareTo(o.instructor);
		if(instructorCompare != 0)
			return instructorCompare;
		
		return 0;
	}
	/**returns the toString of this {@code CourseDBElement} object with each of the five attributes.
	 * @return toString of the this {@code CourseDBElement} object in the format: 
	 * "\n" + "Course:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum.
	 */
	public String toString() { 
		return "\n" + "Course:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum;
	}
	
	
		
}
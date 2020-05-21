package edu.miracostacollege.cs134.mcccoursefinder.model;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBHelperTest {

    private static DBHelper testDB ;
    private static Context testContext ;

    private Course testCourse ;
    private Instructor testInstructor ;
    private Offering testOffering ;

    @Before
    public void setUp() throws Exception {
        testContext = InstrumentationRegistry.getTargetContext() ;
        testDB = new DBHelper(testContext) ;

        testContext.deleteDatabase(DBHelper.DATABASE_NAME) ;

        testCourse = new Course("CS", "999", "Recursive Recursion") ;
        testInstructor = new Instructor("King", "Kailyn", "kking@miracosta.edu") ;
        testOffering = new Offering(12345, "Spring 2022", testCourse, testInstructor) ;
    }

    @After
    public void tearDown() throws Exception {
        testDB.deleteAllCourses();
        testDB.deleteAllInstructors();
    }

    /** .....*/
    @Test
    public void onCreate() {
        assertEquals("Testing name of database", DBHelper.DATABASE_NAME, testDB.getDatabaseName()) ;
    }

    /** .....*/
    @Test
    public void onUpgrade() {
        assertEquals("Testing name of database", DBHelper.DATABASE_NAME, testDB.getDatabaseName()) ;

    }

    /** Done.*/
    @Test
    public void addCourse() {
        // Test adding a new course to the database
        // Happy path:
        // a) test size of database == 1
        // b) test id == 1
        // c) retrieve (get) course from database, all fields should be same as testCourse

        // Put tests in a loop:
        for (int i = 1; i <= 10; i++)
        {
            testDB.addCourse(testCourse) ;
            assertEquals("Testing size of database", i, testDB.getAllCourses().size()) ;
            assertEquals("Testing the id of testCourse after add.", i, testCourse.getId());
            assertEquals("Test all fields of course added to database", testCourse, testDB.getCourse(i)) ;
        }
    }

    /** Done.*/
    @Test
    public void getAllCourses() {
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());
        testDB.addCourse(testCourse) ;
        assertEquals("Testing size of all courses", 1, testDB.getAllCourses().size());
    }

    /** Done.*/
    @Test
    public void deleteCourse() {
        // Sad path: abnormal behavior
        testDB.deleteCourse(testCourse) ;
        assertEquals("Testing size of all courses", 0, testDB.deleteCourse(testCourse));
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());

        // Happy path: normal behavior
        testDB.addCourse(testCourse) ;
        assertEquals("Testing size of all courses", 1, testDB.deleteCourse(testCourse));
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());

        // Edge Case: Test of boundaries (null)
        assertEquals("Testing size of all courses", 0, testDB.deleteCourse(null)) ;
    }

    /** Done.*/
    @Test
    public void deleteAllCourses() {
        assertEquals("Testing deleteAllCourses", 0, testDB.deleteAllCourses()) ;

        testDB.addCourse(testCourse) ;
        testDB.addCourse(testCourse) ;

        assertEquals("Testing deleteAllCourses", 2, testDB.deleteAllCourses()) ;
    }

    /** Done.*/
    @Test
    public void updateCourse() {
        // Tests to make sure that course is added correctly
        testDB.addCourse(testCourse) ;
        assertEquals("Testing updateCourse", testCourse, testDB.getCourse(1));

        // Updates the course and makes sure it is updated in the database
        testCourse.setTitle("Test");
        testDB.updateCourse(testCourse) ;
        assertEquals("Testing updateCourse", testCourse, testDB.getCourse(1));
    }

    /** Done.*/
    @Test
    public void getCourse() {
        testDB.addCourse(testCourse) ;
        assertEquals("Testing getCourses", testCourse, testDB.getCourse(1)) ;

        testCourse = new Course("PHYS", "110", "Test") ;
        testDB.addCourse(testCourse) ;

        assertEquals("Testing getCourses", testCourse, testDB.getCourse(2)) ;
    }

    /** Done.*/
    @Test
    public void addInstructor() {
        testDB.addInstructor(testInstructor) ;

        assertEquals("Testing size of database", 1, testDB.getAllInstructors().size()) ;
        assertEquals("Testing the id of testInstructor after add.", 1, testInstructor.getId());
        assertEquals("Test all fields of instructor added to database", testInstructor, testDB.getInstructor(1)) ;
    }

    /** Done.*/
    @Test
    public void getAllInstructors() {
        assertEquals("Testing size of all instructors", 0, testDB.getAllInstructors().size());
        testDB.addInstructor(testInstructor);
        assertEquals("Testing size of all instructors", 1, testDB.getAllInstructors().size());
    }

    /** Done.*/
    @Test
    public void deleteInstructor() {
        // Sad path: abnormal behavior
        testDB.deleteInstructor(testInstructor);
        assertEquals("Testing size of all instructors", 0, testDB.deleteInstructor(testInstructor));
        assertEquals("Testing size of all instructors", 0, testDB.getAllInstructors().size());

        // Happy path: normal behavior
        testDB.addInstructor(testInstructor) ;
        assertEquals("Testing size of all instructors", 1, testDB.deleteInstructor(testInstructor));
        assertEquals("Testing size of all instructors", 0, testDB.getAllInstructors().size());

        // Edge Case: Test of boundaries (null)
        assertEquals("Testing size of all instructors", 0, testDB.deleteInstructor(null)) ;
    }

    /** Done.*/
    @Test
    public void deleteAllInstructors() {
        assertEquals("Testing deleteAllInstructors", 0, testDB.deleteAllInstructors()) ;

        testDB.addInstructor(testInstructor) ;
        testDB.addInstructor(testInstructor) ;

        assertEquals("Testing deleteAllInstructors", 2, testDB.deleteAllInstructors()) ;
    }

    /** Done.*/
    @Test
    public void updateInstructor() {
        // Tests to make sure that instructor is added correctly
        testDB.addInstructor(testInstructor) ;
        assertEquals("Testing getInstructor", testInstructor, testDB.getInstructor(1));

        // Updates the instructor and makes sure it is updated in the database
        testInstructor.setFirstName("Phil");
        testDB.updateInstructor(testInstructor);
        assertEquals("Testing updateInstructor", testInstructor, testDB.getInstructor(1));
    }

    /** Done.*/
    @Test
    public void getInstructor() {
        testDB.addInstructor(testInstructor) ;
        assertEquals("Testing getInstructor", testInstructor, testDB.getInstructor(1));

        testInstructor = new Instructor("PHYS", "110", "Test") ;
        testDB.addInstructor(testInstructor) ;

        assertEquals("Testing getInstructor", testInstructor, testDB.getInstructor(2));
    }

    /** Done.*/
    @Test
    public void addOffering() {
        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        assertEquals("Testing size of database", 1, testDB.getAllOfferings().size()) ;
        assertEquals("Test all fields of course added to database", testCourse.getId(), testDB.getOffering(12345).getCourse().getId()) ;
        assertEquals("Test all fields of course added to database", testInstructor.getId(), testDB.getOffering(12345).getInstructor().getId()) ;
    }

    /** Done.*/
    @Test
    public void getAllOfferings() {
        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        assertEquals("Testing size of all offerings", 0, testDB.getAllOfferings().size());
        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        assertEquals("Testing size of all offerings", 1, testDB.getAllOfferings().size());
    }

    /** Done.*/
    @Test
    public void deleteOffering() {
        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        // Sad path: abnormal behavior
        testDB.deleteOffering(testOffering);
        assertEquals("Testing size of all offerings", 0, testDB.deleteOffering(testOffering));
        assertEquals("Testing size of all offerings", 0, testDB.getAllOfferings().size());

        // Happy path: normal behavior
        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        assertEquals("Testing size of all offerings", 1, testDB.deleteOffering(testOffering));
        assertEquals("Testing size of all offerings", 0, testDB.getAllOfferings().size());

        // Edge Case: Test of boundaries (null)
        assertEquals("Testing size of all offerings", 0, testDB.deleteOffering(null)) ;
    }

    /** Done.*/
    @Test
    public void deleteAllOfferings() {
        assertEquals("Testing deleteAllOfferings", 0, testDB.deleteAllOfferings()) ;

        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;

        assertEquals("Testing deleteAllOfferings", 2, testDB.deleteAllOfferings()) ;
    }

    /** Done.*/
    @Test
    public void updateOffering() {
        // Tests to make sure that offering is added correctly
        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        assertEquals("Testing getOffering", testOffering, testDB.getOffering(12345));

        // Updates the offering and makes sure it is updated in the database
        testOffering.setSemester("Test");
        testDB.updateOffering(testOffering);
        assertEquals("Testing getOffering", testOffering, testDB.getOffering(12345));
    }

    /** Done.*/
    @Test
    public void getOffering() {
        testDB.addInstructor(testInstructor);
        testDB.addCourse(testCourse) ;

        testDB.addOffering(12345, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;
        assertEquals("Testing getOffering", testOffering, testDB.getOffering(12345));

        testOffering = new Offering(1215, "Spring 2022", testCourse, testInstructor) ;
        testDB.addOffering(1215, "Spring 2022", testCourse.getId(), testInstructor.getId()) ;

        assertEquals("Testing getOffering", testOffering, testDB.getOffering(1215));
    }

    /** Done.*/
    @Test
    public void importOfferingsFromCSV() {
        assertEquals("Testing to see if importOfferingsFromCSV works", true, testDB.importOfferingsFromCSV("offerings.csv"));

        try
        {
            assertEquals("Testing to see if importOfferingsFromCSV works", true, testDB.importOfferingsFromCSV("courses.csv"));

            assertFalse(true);
        } catch (NumberFormatException e)
        {
        }
        try
        {
            assertEquals("Testing to see if importOfferingsFromCSV works", true, testDB.importOfferingsFromCSV("instructors.csv"));

            assertFalse(true);
        } catch (NumberFormatException e)
        {
        }
    }

    /** Done.*/
    @Test
    public void importCoursesFromCSV() {
        assertEquals("Testing to see if importCoursesFromCSV works", true, testDB.importCoursesFromCSV("courses.csv"));

        assertEquals("Testing to see if importCoursesFromCSV works", false, testDB.importCoursesFromCSV("offerig.csv"));
    }

    /** Done.*/
    @Test
    public void importInstructorsFromCSV() {
        assertEquals("Testing to see if importInstructorsFromCSV works", true, testDB.importInstructorsFromCSV("instructors.csv"));

        try
        {
            assertEquals("Testing to see if importInstructorsFromCSV works", true, testDB.importInstructorsFromCSV("offering.csv"));
            assertFalse(true);
        } catch (NullPointerException e)
        {

        }
    }
}
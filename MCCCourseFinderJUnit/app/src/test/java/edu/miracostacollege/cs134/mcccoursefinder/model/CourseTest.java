package edu.miracostacollege.cs134.mcccoursefinder.model;

import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private Course testCourse ;

    // A method that executes before every single test
    // Initializes any information needed to conduct test
    // Typically initializes object
    @Before
    public void setUp() throws Exception {
        // initialize with test data
        testCourse = new Course("CS", "999", "Recursive Recursion") ;

    }

    // Executes after every test finishes
    // Typically used for cleanup code
    @After
    public void tearDown() throws Exception {

    }

    /** Done.*/
    @Test
    public void getId() {
        // All tests begin with assertXXXX (where XXXX is something)
        // Assert that the id of the testCourse is -1
        assertEquals("Testing the getter for id", -1, testCourse.getId());

        testCourse = new Course(101, "CS", "999", "Recursive Recursion") ;
        assertEquals("Testing the getter for id", 101, testCourse.getId());
    }

    /** Done.*/
    @Test
    public void setId() {
        // Happy path testing
        assertEquals("Testing the setter for id", -1, testCourse.getId());

        // Use the setter
        testCourse.setId(101) ;
        assertEquals("Testing the setter for id", 101, testCourse.getId()) ;


        // Sad path testing
        // Edge case test: test the boundaries
        try{
            testCourse.setId(Integer.MIN_VALUE) ;
            // Expecting an exception to occur, so if it doesn't, we fail the test
            fail("Expected setter of -2 to generate exception");
        } catch (IllegalArgumentException e) { // worked as expected
            // Worked as intended
        }

        // Edge case test: test the boundaries
        testCourse.setId(Integer.MAX_VALUE) ;
        assertEquals("Testing the setter for id", Integer.MAX_VALUE, testCourse.getId()) ;

        // Happy path testing
        try{
            testCourse.setId(-2);
            // Expecting an exception to occur, so if it doesn't, we fail the test
            fail("Expected setter of -2 to generate exception");
        } catch (IllegalArgumentException e) { // worked as expected
            // Worked as intended
        }
    }
    /** Done.*/
    @Test
    public void getAlpha() {
        assertEquals("Testing the getter for alpha", "CS", testCourse.getAlpha()) ;

        testCourse = new Course("PHYS", "999", "Physics of hell") ;
        assertEquals("Testing the getter for alpha", "PHYS", testCourse.getAlpha()) ;
    }
    /** Done.*/
    @Test
    public void getNumber() {
        assertEquals("Testing the getter for alpha", "999", testCourse.getNumber()) ;

        testCourse = new Course("CS", "420", "Recursive Recursion") ;
        assertEquals("Testing the getter for number", "420", testCourse.getNumber()) ;
    }
    /** Done.*/
    @Test
    public void getTitle() {
        assertEquals("Testing the getter for title", "Recursive Recursion", testCourse.getTitle()) ;

        testCourse = new Course("PHYS", "999", "Physics of hell") ;
        assertEquals("Testing the getter for title", "Physics of hell", testCourse.getTitle()) ;
    }
    /** Done.*/
    @Test
    public void setTitle() {
        testCourse.setTitle("Computer Architecture") ;
        assertEquals("Testing the setter for title", "Computer Architecture", testCourse.getTitle()) ;

        testCourse.setTitle("The person, society, and the world") ;
        assertEquals("Testing the setter for title", "The person, society, and the world", testCourse.getTitle());
    }
    /** Done.*/
    @Test
    public void getFullName() {
        assertEquals("Testing getter for fullName", "CS 999", testCourse.getFullName());

        testCourse = new Course("PHYS", "151", "Physics") ;
        assertEquals("Testing the getter for fullName", "PHYS 151", testCourse.getFullName());
    }

    /** Done.*/
    @Test
    public void testToString() {
        assertEquals("Testing the toString", "Course{" +
                "Id=" + "-1" +
                ", Alpha='" + "CS" + '\'' +
                ", Number='" + "999" + '\'' +
                ", Title='" + "Recursive Recursion" + '\'' +
                '}', testCourse.toString());

        testCourse.setTitle("Test title");
        assertEquals("Testing the toString", "Course{" +
                "Id=" + "-1" +
                ", Alpha='" + "CS" + '\'' +
                ", Number='" + "999" + '\'' +
                ", Title='" + "Test title" + '\'' +
                '}', testCourse.toString());
    }
}
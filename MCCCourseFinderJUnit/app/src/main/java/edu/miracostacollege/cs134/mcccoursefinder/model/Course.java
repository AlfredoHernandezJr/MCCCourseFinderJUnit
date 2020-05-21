package edu.miracostacollege.cs134.mcccoursefinder.model;

import java.util.Objects;

/**
 * The <code>Course</code> class represents a single course at MiraCosta College,
 * including its alpha (e.g. CS), number (e.g. 134) and title (e.g. Mobile Application Development)
 *
 * @author Michael Paulding
 */
// To generate a test class (JUnit test)
    // Ctrl + shift + T
public class Course {
    private long mId;
    private String mAlpha;
    private String mNumber;
    private String mTitle;

    public Course(long id, String alpha, String number, String title) {
        setId(id) ;
        mAlpha = alpha;
        mNumber = number;
        mTitle = title;
    }

    public Course(String alpha, String number, String title) {
        this(-1, alpha, number, title);
    }

    public long getId() {
        return mId;
    }

    void setId(long id)
    {
        if (id < -1)
            throw new IllegalArgumentException() ;
        mId = id;
    }

    public String getAlpha() {
        return mAlpha;
    }


    public String getNumber() {
        return mNumber;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getFullName() {
        return mAlpha + " " + mNumber;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + mId +
                ", Alpha='" + mAlpha + '\'' +
                ", Number='" + mNumber + '\'' +
                ", Title='" + mTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return mId == course.mId &&
                mAlpha.equals(course.mAlpha) &&
                mNumber.equals(course.mNumber) &&
                mTitle.equals(course.mTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mAlpha, mNumber, mTitle);
    }
}

package edu.miracostacollege.cs134.mcccoursefinder.model;

import java.util.Objects;

/**
 * The <code>Offering</code> class represents a single course offering at MiraCosta College,
 * including its CRN (course registration number), semester (e.g. Fall 2019),
 * the <code>Course</code> it is mapped to and the <code>Instructor</code> teaching
 * this offering of the course.
 *
 * @author Michael Paulding
 */
public class Offering {
    private int mCRN;
    private String mSemester;
    private Course mCourse;
    private Instructor mInstructor;

    public Offering(int CRN, String semester, Course course, Instructor instructor) {
        mCRN = CRN;
        mSemester = semester;
        mCourse = course;
        mInstructor = instructor;
    }

    public int getCRN() {
        return mCRN;
    }

    public void setCRN(int crn) {
        mCRN = crn;
    }

    public String getSemester() {
        return mSemester;
    }

    public void setSemester(String semester) {
        mSemester = semester;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public Instructor getInstructor() {
        return mInstructor;
    }

    public void setInstructor(Instructor instructor) {
        mInstructor = instructor;
    }

    @Override
    public String toString() {
        return "Offering{" +
                "CRN=" + mCRN +
                ", Semester=" + mSemester +
                ", Course=" + mCourse +
                ", Instructor=" + mInstructor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offering offering = (Offering) o;
        return mCRN == offering.mCRN &&
                mSemester.equals(offering.mSemester) &&
                mCourse.equals(offering.mCourse) &&
                mInstructor.equals(offering.mInstructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCRN, mSemester, mCourse, mInstructor);
    }
}

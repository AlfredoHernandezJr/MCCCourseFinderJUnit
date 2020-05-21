package edu.miracostacollege.cs134.mcccoursefinder.model;

import java.util.Objects;

/**
 * The <code>Instructor</code> class represents an individual instructor at MiraCosta College,
 * including the instructor's last name, first name and email address.
 *
 * @author Michael Paulding
 */
public class Instructor {
    private long mId;
    private String mLastName;
    private String mFirstName;
    private String mEmail;

    public Instructor(long id, String lastName, String firstName, String email) {
        mId = id;
        mLastName = lastName;
        mFirstName = firstName;
        mEmail = email;
    }

    public Instructor(String lastName, String firstName, String email) {
        this(-1, lastName, firstName, email);
    }

    public long getId() {
        return mId;
    }

    void setId(long id)
    {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFullName() { return mFirstName + " " + mLastName; }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "Id=" + mId +
                ", LastName='" + mLastName + '\'' +
                ", FirstName='" + mFirstName + '\'' +
                ", Email='" + mEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return mId == that.mId &&
                mLastName.equals(that.mLastName) &&
                mFirstName.equals(that.mFirstName) &&
                mEmail.equals(that.mEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mLastName, mFirstName, mEmail);
    }
}

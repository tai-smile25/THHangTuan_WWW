package entity;

import java.time.LocalDate;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String mobile;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    private List<Qualification> qualifications;
    private String course;

    public Student() {
    }

    public Student(String firstName, String lastName, String dob, String email, String mobile,
                   String gender, String address, String city, String pinCode, String state,
                   String country, List<String> hobbies, List<Qualification> qualifications,
                   String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.qualifications = qualifications;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}

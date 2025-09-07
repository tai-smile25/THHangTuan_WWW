package entity;

import java.time.LocalDate;

public class Student {
    // ===== Thông tin cá nhân =====
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;

    // ===== Sở thích =====
    private boolean drawing;
    private boolean singing;
    private boolean dancing;
    private boolean sketching;
    private String otherHobby;

    // ===== Trình độ học vấn =====
    private String classXBoard;
    private double classXPercentage;
    private int classXYearOfPassing;

    private String classXIIBoard;
    private double classXIIPercentage;
    private int classXIIYearOfPassing;

    private String graduationBoard;
    private double graduationPercentage;
    private int graduationYearOfPassing;

    private String mastersBoard;
    private double mastersPercentage;
    private int mastersYearOfPassing;

    // ===== Khóa học đăng ký =====
    private String courseApplied;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, String mobileNumber, String gender, String address, String city, String pinCode, String state, String country, boolean drawing, boolean singing, boolean dancing, boolean sketching, String otherHobby, String classXBoard, double classXPercentage, int classXYearOfPassing, String classXIIBoard, double classXIIPercentage, int classXIIYearOfPassing, String graduationBoard, double graduationPercentage, int graduationYearOfPassing, String mastersBoard, double mastersPercentage, int mastersYearOfPassing, String courseApplied) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.drawing = drawing;
        this.singing = singing;
        this.dancing = dancing;
        this.sketching = sketching;
        this.otherHobby = otherHobby;
        this.classXBoard = classXBoard;
        this.classXPercentage = classXPercentage;
        this.classXYearOfPassing = classXYearOfPassing;
        this.classXIIBoard = classXIIBoard;
        this.classXIIPercentage = classXIIPercentage;
        this.classXIIYearOfPassing = classXIIYearOfPassing;
        this.graduationBoard = graduationBoard;
        this.graduationPercentage = graduationPercentage;
        this.graduationYearOfPassing = graduationYearOfPassing;
        this.mastersBoard = mastersBoard;
        this.mastersPercentage = mastersPercentage;
        this.mastersYearOfPassing = mastersYearOfPassing;
        this.courseApplied = courseApplied;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public boolean isDrawing() {
        return drawing;
    }

    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }

    public boolean isSinging() {
        return singing;
    }

    public void setSinging(boolean singing) {
        this.singing = singing;
    }

    public boolean isDancing() {
        return dancing;
    }

    public void setDancing(boolean dancing) {
        this.dancing = dancing;
    }

    public boolean isSketching() {
        return sketching;
    }

    public void setSketching(boolean sketching) {
        this.sketching = sketching;
    }

    public String getOtherHobby() {
        return otherHobby;
    }

    public void setOtherHobby(String otherHobby) {
        this.otherHobby = otherHobby;
    }

    public String getClassXBoard() {
        return classXBoard;
    }

    public void setClassXBoard(String classXBoard) {
        this.classXBoard = classXBoard;
    }

    public double getClassXPercentage() {
        return classXPercentage;
    }

    public void setClassXPercentage(double classXPercentage) {
        this.classXPercentage = classXPercentage;
    }

    public int getClassXYearOfPassing() {
        return classXYearOfPassing;
    }

    public void setClassXYearOfPassing(int classXYearOfPassing) {
        this.classXYearOfPassing = classXYearOfPassing;
    }

    public String getClassXIIBoard() {
        return classXIIBoard;
    }

    public void setClassXIIBoard(String classXIIBoard) {
        this.classXIIBoard = classXIIBoard;
    }

    public double getClassXIIPercentage() {
        return classXIIPercentage;
    }

    public void setClassXIIPercentage(double classXIIPercentage) {
        this.classXIIPercentage = classXIIPercentage;
    }

    public int getClassXIIYearOfPassing() {
        return classXIIYearOfPassing;
    }

    public void setClassXIIYearOfPassing(int classXIIYearOfPassing) {
        this.classXIIYearOfPassing = classXIIYearOfPassing;
    }

    public String getGraduationBoard() {
        return graduationBoard;
    }

    public void setGraduationBoard(String graduationBoard) {
        this.graduationBoard = graduationBoard;
    }

    public double getGraduationPercentage() {
        return graduationPercentage;
    }

    public void setGraduationPercentage(double graduationPercentage) {
        this.graduationPercentage = graduationPercentage;
    }

    public int getGraduationYearOfPassing() {
        return graduationYearOfPassing;
    }

    public void setGraduationYearOfPassing(int graduationYearOfPassing) {
        this.graduationYearOfPassing = graduationYearOfPassing;
    }

    public String getMastersBoard() {
        return mastersBoard;
    }

    public void setMastersBoard(String mastersBoard) {
        this.mastersBoard = mastersBoard;
    }

    public double getMastersPercentage() {
        return mastersPercentage;
    }

    public void setMastersPercentage(double mastersPercentage) {
        this.mastersPercentage = mastersPercentage;
    }

    public int getMastersYearOfPassing() {
        return mastersYearOfPassing;
    }

    public void setMastersYearOfPassing(int mastersYearOfPassing) {
        this.mastersYearOfPassing = mastersYearOfPassing;
    }

    public String getCourseApplied() {
        return courseApplied;
    }

    public void setCourseApplied(String courseApplied) {
        this.courseApplied = courseApplied;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", drawing=" + drawing +
                ", singing=" + singing +
                ", dancing=" + dancing +
                ", sketching=" + sketching +
                ", otherHobby='" + otherHobby + '\'' +
                ", classXBoard='" + classXBoard + '\'' +
                ", classXPercentage=" + classXPercentage +
                ", classXYearOfPassing=" + classXYearOfPassing +
                ", classXIIBoard='" + classXIIBoard + '\'' +
                ", classXIIPercentage=" + classXIIPercentage +
                ", classXIIYearOfPassing=" + classXIIYearOfPassing +
                ", graduationBoard='" + graduationBoard + '\'' +
                ", graduationPercentage=" + graduationPercentage +
                ", graduationYearOfPassing=" + graduationYearOfPassing +
                ", mastersBoard='" + mastersBoard + '\'' +
                ", mastersPercentage=" + mastersPercentage +
                ", mastersYearOfPassing=" + mastersYearOfPassing +
                ", courseApplied='" + courseApplied + '\'' +
                '}';
    }
}

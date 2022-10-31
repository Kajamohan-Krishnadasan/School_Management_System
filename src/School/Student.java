package School;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kajamohan
 */
public class Student {
    private String id, name, AppoinmentDate, Email, mobile,DateOfBirth,AddmissionDate,Address,ClassName,ClassID;
    public static int currentYear,currentMonth,currentTerm;
    private float marks;

    
    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getAddmissionDate() {
        return AddmissionDate;
    }

    public void setAddmissionDate(String AddmissionDate) {
        this.AddmissionDate = AddmissionDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Student(String name, float marks){     
        this.name = name;
        this.marks = marks;
    }

    public Student(String id, String name, String AppoinmentDate, String Email, String mobile) {
        this.id = id;
        this.name = name;
        this.AppoinmentDate = AppoinmentDate;
        this.Email = Email;
        this.mobile = mobile;
    }
    
//    Id,Name,class,Addmission Date,Email,Moile
//        ID,Name,ClassID,AddmissionDate,Email,Mobile

    public Student(String id, String name, String Email, String mobile, String AddmissionDate, String ClassID) {
        this.id = id;
        this.name = name;
        this.Email = Email;
        this.mobile = mobile;
        this.AddmissionDate = AddmissionDate;
        this.ClassID = ClassID;
    }
    
    
    public String getAppoinmentDate() {
        return AppoinmentDate;
    }

    public void setAppoinmentDate(String AppoinmentDate) {
        this.AppoinmentDate = AppoinmentDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @SuppressWarnings("deprecation")
    public static void CalcuateTerm(){
        Date d = new Date();
        currentYear = d.getYear()+1900;
        currentMonth = d.getMonth()+1;
        if (currentMonth < 5)
            currentTerm = 1;
        else if(currentMonth < 8 )
            currentTerm = 2;
        else 
            currentTerm = 3;
        
//        System.out.println("Year : "+ currentYear);
//        System.out.println("month : "+ currentMonth);
//        System.out.println("Term : "+ currentTerm);
    }
    
//    public static void main(String[] args) {
//        Student.CalcuateTerm();
//    }
}

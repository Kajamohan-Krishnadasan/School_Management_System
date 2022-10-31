/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;


import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kajamohan
 */
public class ConnectDatabase {
    public static ArrayList <String> Terms = new ArrayList<>();
    public static ArrayList <Student> Teachers = new ArrayList<>();
    public static ArrayList <Student> StudentsDetails = new ArrayList<>();
    public static ArrayList <Student> ClassDetails = new ArrayList<>();
    public static ArrayList <Student> SubjectDetails = new ArrayList<>();
    public static ArrayList <Student> Admin = new ArrayList<>();
    public static ArrayList <Student> AllStaffsTable = new ArrayList<>();
    public static ArrayList <String> PrincpalTypes  = new ArrayList<>(3);
    public static ArrayList <String> RoleTypes  = new ArrayList<>(5);
    public static ArrayList <ReportStore> ReportDetails = new ArrayList<>();
    public static ArrayList <ReportStore> ClassSubjectDetails = new ArrayList<>();
    public static ArrayList <ReportStore> subjectTeacherDetails = new ArrayList<>();
    public static ArrayList <Student> StudentSubjectMarksTable = new ArrayList<>();
    public static ArrayList <Student> StudentMarksTable = new ArrayList<>();
    
    public String StudentClassName;
    private static String getTeachers, getClass,getAdmin, getSubjects;
    
    private String id,UpdateQuery,InsertQuery,setReportQuery,PasswordQuery, userName,userType,getDetailsSQL;
    private String totalQuery, deleteQuery;
    public static Date DOBdate, APPOIMENTdate;
    
    static Connection con;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs ;
    
    Date Cdate = new Date();
    LocalDate todayDate = LocalDate.now();
    
    // Connecting the Database
    public  ConnectDatabase(){      
        String URL = "jdbc:mysql://localhost:3306/schoolmanagementsystem";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");            
            con = DriverManager.getConnection(URL,user,password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Database is not Connected" );
            
        }
    }
          
    /*
    *   Set User Details
    */
    public void setValue(String id, String userName, String userType){
        this.id = id;
        this.userName = userName;
        this.userType = userType;
    }
    
    /*
    *   Check user Verification 
    *   Principal , Teacher , Student , Cleark
    */
    public boolean userVerification(String UN,String PWD, String UTYPE) throws SQLException{
        char StartLetter = UTYPE.charAt(0);
        String UserTable;
        UserTable = switch (StartLetter) {
            case 'P', 'C' -> "adminusertab";
            case 'T' -> "teacherusertab";
            default -> "studentusertab";
        };
                
        String LoginSQL = "SELECT * FROM "+UserTable+" WHERE UserName =? and Password =? ";
      
        pst = con.prepareStatement(LoginSQL);
        pst.setString(1, UN);
        pst.setString(2, PWD);
        // get and Store the data from the database
        rs = pst.executeQuery();
        
        if(UN.charAt(0) == StartLetter){
            System.out.println("User Credentials is Valid!!! ");
            return rs.next();                        
        }else{
            System.out.println("User Credentials is Invalid!!! ");
            return false;
        }

    }
    
    /*
    ========================================================================================
    ========================================================================================
    */
    
    /*********************** Insert Values in Database  Start ******************+********/
    
    /*
    *   Send Report to Principal / Cleark
    *   Teacher , Students can sent
    */
    public void sendReport(String Id , String des ) throws SQLException{
        pst.execute("SET FOREIGN_KEY_CHECKS = 0");
        
        setReportQuery = "INSERT INTO reporttab(ReporterDate,ReporterID,ProblemDetails,ReportStatus) VALUES(?,?,?,?) ";
        
        pst = con.prepareStatement(setReportQuery);
        java.sql.Date currentDate = new java.sql.Date(Cdate.getTime());
         
        pst.setDate(1,currentDate);
        pst.setString(2,Id);
        pst.setString(3,des);
        pst.setString(4,"Unsolved");
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Report Tab");
        }
        
    }
    
    /*
    *   Insert New Subject
    *   Subject Tab
    */
    public void insertNewSubject(String id, String name, String year, String term, String classId, String teacherId) throws SQLException{              
        InsertQuery = "INSERT INTO subjecttab(ID,Name,Year,Term,classID,TeacherID) VALUES(?,?,?,?,?,?)";
        
        pst = con.prepareStatement(InsertQuery);
        
        pst.setString(1,id);
        pst.setString(2,name);
        pst.setString(3,year);
        pst.setString(4,term);
        pst.setString(5,classId);
        pst.setString(6,teacherId);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Subject Tab");
        }
        
        
    }   
    
    /*
    *   Add New Class 
    */
    public void addNewClass(String id, String name, String teacherId ) throws SQLException{
        InsertQuery = "INSERT INTO classtab (ID,Name,TeacherID) VALUES(?,?,?)";
        
        pst  = con.prepareStatement(InsertQuery);
        
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setString(3,teacherId);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Class Tab");
        }   
        
    }
    
    /*
    *   Insert Teacher
    *   Principal / Cleark can Add
    */
    public void addNewTeacher(String ID, String Password, String Name, String Role, String Gender, Date DateOfBirth, Date AppointmentDate, String Email, int Mobile, String NIC, String Address) throws SQLException{
       InsertQuery = "INSERT INTO teachertab (ID,Name,Role,Gender,DateOfBirth,AppointmentDate,Email,Mobile,NIC,Address) VALUES(?,?,?,?,?,?,?,?,?,?)";
       pst = con.prepareStatement(InsertQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Name);
        pst.setString(3, Role);
        pst.setString(4, Gender);
        pst.setDate(5, (java.sql.Date) DateOfBirth);
        pst.setDate(6, (java.sql.Date) AppointmentDate);
        pst.setString(7, Email);
        pst.setInt(8, Mobile);
        pst.setString(9, NIC);
        pst.setString(10, Address);
        
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Teacher Tab");
        } 
       
       // Insert Password
        PasswordQuery = "INSERT INTO teacherusertab(UserName,Password) VALUES (?,?) ";
        pst = con.prepareStatement(PasswordQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Password);
        x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Teacher User Tab");
        } 
        
    }
    
    /*
    *   Insert Principal / Admin
    *   Principal / Cleark can Add
    */
    public void addNewAdmin(String ID, String Password, String Name, String Role, String Gender, Date DateOfBirth, Date AppointmentDate, String Email, int Mobile, String NIC, String Address) throws SQLException{
        InsertQuery = "INSERT INTO admintab (ID,Name,Role,Gender,DateOfBirth,AppointmentDate,Email,Mobile,NIC,Address) VALUES(?,?,?,?,?,?,?,?,?,?)";
        pst = con.prepareStatement(InsertQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Name);
        pst.setString(3, Role);
        pst.setString(4, Gender);
        pst.setDate(5, (java.sql.Date) DateOfBirth);
        pst.setDate(6, (java.sql.Date) AppointmentDate);
        pst.setString(7, Email);
        pst.setInt(8, Mobile);
        pst.setString(9, NIC);
        pst.setString(10, Address);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Admin Tab");
        }
        // Insert Password
        PasswordQuery = "INSERT INTO adminusertab(UserName,Password,UserType) VALUES (?,?,?)";
        
        pst = con.prepareStatement(PasswordQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Password);
        if(ID.contains("P")){
            pst.setString(3, "Principal");  
        }else{
            pst.setString(3, "Cleark"); 
        }
        
        x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Admin User Tab");
        }
        
    }
    
    /*
    *   Insert Student
    *   Principal / Cleark can Add
    */
    public void addNewStudent(String ID, String Password, String Name, String Gender, Date DateOfBirth, Date AddmissionDate, String Email, int Mobile, String Address, String ClassID) throws SQLException{
        InsertQuery = "INSERT INTO studenttab (ID, Name, Gender, DateOfBirth, AddmissionDate, Email, Mobile, Address, ClassID)  VALUES(?,?,?,?,?,?,?,?,?)" ;
        pst = con.prepareStatement(InsertQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Name);
        pst.setString(3, Gender);
        pst.setDate(4, (java.sql.Date) DateOfBirth);
        pst.setDate(5, (java.sql.Date) AddmissionDate);
        pst.setString(6, Email);
        pst.setInt(7, Mobile);
        pst.setString(8, Address);
        pst.setString(9, ClassID);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Student Tab");
        }
      
        
        // Insert Password
        PasswordQuery = "INSERT INTO studentusertab(UserName,Password) VALUES (?,?) ";
        pst = con.prepareStatement(PasswordQuery);
        
        pst.setString(1, ID);
        pst.setString(2, Password);
        x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Student User Tab");
        } 
        
    }
    
    /*
    *   Add Student Marks 
    *   Teacher / Principal / Cleark can Add
    */
    
    
    public void addMarks(String StudentID, String SubjectID, int Year, int Term, float Marks ) throws SQLException{
        
        InsertQuery = "INSERT INTO markstab(StudentID, SubjectID, Year, Term, Marks) VALUES(?,?,?,?,?)";
        
        pst = con.prepareStatement(InsertQuery);
        pst.setString(1, StudentID);
        pst.setString(2, SubjectID);
        pst.setInt(3, Year);
        pst.setInt(4, Term);
        pst.setFloat(5, Marks);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Marks Tab");
        }
            
    }
    
    /*
    *   Add Time Table
    *   Principal / Cleark can Add
    */
    public void addTimeTable(String SubjectID, int Year, int Term, String Day, int Period,String Classid) throws SQLException{
        InsertQuery = "INSERT INTO timetable(SubjectID, Year, Term, Day, Period,ClassID) VALUES(?,?,?,?,?,?)";
        
        pst = con.prepareStatement(InsertQuery);
        pst.setString(1, SubjectID);
        pst.setInt(2, Year);
        pst.setInt(3, Term);
        pst.setString(4, Day);
        pst.setInt(5, Period);
        pst.setString(6, Classid);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Inserted Time Table");
        }
        
        
        
    }
    
    
    
    
    /*********************** Insert Values in Database  End *************************/
    
    /*
    ========================================================================================
    ========================================================================================
    */
   
    /************************* Get Details Start ******************************************/
    
    /*
    *   Get User ID
    */
    public String getClassName(String classID) throws SQLException{
        String className;
        getDetailsSQL = "Select Name FROM classtab WHERE ID=?";
        
        pst = con.prepareStatement(getDetailsSQL);
        pst.setString(1, classID);
        
        rs = pst.executeQuery();
        if(rs.next())
            className = rs.getString("Name");
        else
            className = "Class is Not found";
        
        return className;
    }  
    
    /*
    *   Getting Details
    *   Principal , Teacher , Cleark 
    */
    public String [] getDetails(String UN, String UType) throws SQLException{
        String returnValues []= {"","","","","","","","","",""};
        
        getDetailsSQL = "SELECT * FROM "+UType+" WHERE ID =? ";       
        pst = con.prepareStatement(getDetailsSQL);        
        pst.setString(1, UN);      
        rs = pst.executeQuery();
        
        if (rs.next()){
            returnValues[0] = rs.getString("ID");
            returnValues[1] = rs.getString("Name");
            returnValues[2] = rs.getString("Role");
            returnValues[3] = rs.getString("Gender");
            returnValues[4] = rs.getDate("DateOfBirth").toString();
            DOBdate = rs.getDate("DateOfBirth");
            APPOIMENTdate = rs.getDate("AppointmentDate");
            returnValues[5] = rs.getDate("AppointmentDate").toString();
            returnValues[6] = rs.getString("Email");
            returnValues[7] = Integer.toString(rs.getInt("Mobile"));
            returnValues[8] = rs.getString("NIC");
            returnValues[9] = rs.getString("Address");
        }            
        return returnValues;     
    }
    
    /*
    *   Get Password
    */
    public String getPassword(String Id) throws SQLException{
        String pass = "";
        if(Id.charAt(0) == 'P' || Id.charAt(0) == 'C'){
            getDetailsSQL = "SELECT Password FROM adminusertab WHERE UserName=?";
        }else if(Id.charAt(0) == 'T'){
            getDetailsSQL = "SELECT Password FROM teacherusertab WHERE UserName=?";
        }else if(Id.charAt(0) == 'S'){
            getDetailsSQL = "SELECT Password FROM studentusertab WHERE UserName=?";
        }
        pst = con.prepareStatement(getDetailsSQL);
        pst.setString(1, Id);
        
        rs = pst.executeQuery();
        
        if(rs.next())
            pass = rs.getString("Password");
        
        return pass;
    }
    
   /*
    *   Get Details
    *   Students
    */
    public String [] getStudentDetails(String UN, String UType) throws SQLException{
        String returnValues []= {"","","","","","","","","",""};
        
        getDetailsSQL = "SELECT s.*,c.Name FROM "+UType+" AS s, classtab As c WHERE s.ID =? AND c.ID = s.classID ";       
        pst = con.prepareStatement(getDetailsSQL);        
        pst.setString(1, UN);      
        rs = pst.executeQuery();
        
        if (rs.next()){
            returnValues[0] = rs.getString("s.ID");
            returnValues[1] = rs.getString("s.Name");
            returnValues[2] = rs.getString("s.Gender");
            returnValues[3] = rs.getDate("s.DateOfBirth").toString();
            returnValues[4] = rs.getDate("s.AddmissionDate").toString();
            DOBdate = rs.getDate("s.DateOfBirth");
            APPOIMENTdate = rs.getDate("s.AddmissionDate");
            returnValues[5] = rs.getString("s.Email");
            returnValues[6] = Integer.toString(rs.getInt("s.Mobile"));
            returnValues[7] = rs.getString("s.Address");
            returnValues[8] = rs.getString("s.ClassID");
            StudentClassName = rs.getString("c.Name");
        }            
        return returnValues;     
    }    
    
    public static void getReportDetails() throws SQLException{
        String ReportDetailsList,s1,s2,s3,rID;
        
        ReportDetailsList = "SELECT * FROM reporttab";
        ReportDetails.clear();
        pst = con.prepareStatement(ReportDetailsList);
        rs = pst.executeQuery();
        
        while(rs.next()){
            s1 = rs.getString("ReporterDate");
            rID = rs.getString("ReporterID");
            s2 = rs.getString("ProblemDetails");
            s3 = rs.getString("ReportStatus");
       
            ReportDetails.add(new ReportStore(  s1, rID, s2, s3));
        }
    }
    
    /*
    *   Get User Name using ID
    */
    
    public static String getUserName(String ID) throws SQLException{
        String Name,GetNameSQL,tableName;
        
        tableName = switch (ID.charAt(0)) {
            case 'P', 'C' -> "admintab";
            case 'T' -> "teachertab";
            default -> "studenttab";
        };
        
        GetNameSQL = "SELECT Name FROM "+ tableName+" WHERE ID=?";
        
        pst = con.prepareStatement(GetNameSQL);
        pst.setString(1, ID);
        
        rs = pst.executeQuery();
        
        if(rs.next()){
            Name = rs.getString("Name");
        }else{
            Name = "Removed Name";
        }
        return Name;
    }
    
    /************************* Get Details End ******************************************/
    
     /*
    ========================================================================================
    ========================================================================================
    */
    
    /************************ Update or Change Start ***************************************/
    
    
    /*
    *   Update Details - Principal , Cleark
    *   Admin Tab , Admin User Tab
    *   d1 - date of Birth , d2 - Appointment Date
    *   Principal / Cleark can Change
    */
    public void updateAdminDetails(String id , String name, String pass , String role , String gen , java.sql.Date d1 , java.sql.Date d2 , String email , int mobile , String nic , String address) throws SQLException{
       
        // Update details of Admin
        UpdateQuery  = "UPDATE admintab SET Name=? , Role=? , Gender=? , DateOfBirth=? , AppointmentDate=? , Email=? , Mobile=? , NIC=? , Address=? WHERE ID=?";
        pst = con.prepareStatement(UpdateQuery);
        
        pst.setString(1, name);
        pst.setString(2, role);
        pst.setString(3, gen);
        pst.setDate(4, d1);
        pst.setDate(5, d2);
        pst.setString(6, email);
        pst.setInt(7, mobile);
        pst.setString(8, nic);
        pst.setString(9, address);
        pst.setString(10, id);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Admin Tab");
        }
        
        // Change Password of Admin
        PasswordQuery = "UPDATE adminusertab SET Password=? WHERE UserName=?";
        pst = con.prepareStatement(PasswordQuery);
        
        pst.setString(1, pass);
        pst.setString(2, id);
        x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Admin User Tab");
        }
        
    }
    
    /*
    *   Update Details - Teacher
    *   Teacher Tab , Teacher User Tab
    *   d1 - date of Birth , d2 - Appointment Date
    *   Teacher / principal / Cleark  can Change
    */
    public void updateTeacherDetails(String id , String name, String pass , String role , String gen , java.sql.Date d1 , java.sql.Date d2 , String email , int mobile , String nic , String address) throws SQLException{
        
        // Update details of Teachers
        UpdateQuery  = "UPDATE teachertab SET Name=? , Role=? , Gender=? , DateOfBirth=? , AppointmentDate=? , Email=? , Mobile=? , NIC=? , Address=? WHERE ID=?";
        pst = con.prepareStatement(UpdateQuery);
        
        pst.setString(1, name);
        pst.setString(2, role);
        pst.setString(3, gen);
        pst.setDate(4,  d1);
        pst.setDate(5,  d2);
        pst.setString(6, email);
        pst.setInt(7, mobile);
        pst.setString(8, nic);
        pst.setString(9, address);
        pst.setString(10, id);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Teacher Tab");
        }
        
         // Change Password of Teachers
        PasswordQuery = "UPDATE teacherusertab SET Password=? WHERE UserName=?";
        pst = con.prepareStatement(PasswordQuery);
        
        pst.setString(1, pass);
        pst.setString(2, id);
        x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update User Tab");
        }
        
          
    }
    
     /*
    *   Change Student Password
    *   Student / Principal / Cleark can change
    */
    public void updateStudentPassword(String username, String newPass) throws SQLException{
        PasswordQuery = "UPDATE studentusertab SET Password=? WHERE UserName=?";
        pst = con.prepareStatement(PasswordQuery);
        pst.setString(1, newPass);
        pst.setString(2, username);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Student User Tab");
        }
        
        
    }
    
    /*
    *   Update Student Other Details
    *   Principal / Cleark can Change
    *   d1 - date of Birth , d2 - Addmission Date
    */
    public void updateStudentDetails(String id , String name, String gen , java.sql.Date d1 , java.sql.Date d2 , String email , int mobile  , String address, String classId) throws SQLException{
        // Update details of Student
        UpdateQuery  = "UPDATE studenttab SET Name=?  , Gender=? , DateOfBirth=? , AddmissionDate=? , Email=? , Mobile=?  , Address=? , ClassID=? WHERE ID=?";
        pst = con.prepareStatement(UpdateQuery);
        
        pst.setString(1, name);
        pst.setString(2, gen);       
        pst.setDate(3, d1);
        pst.setDate(4, d2);
        pst.setString(5, email);
        pst.setInt(6, mobile);
        pst.setString(7, address);
        pst.setString(8, classId);
        pst.setString(9, id);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Student Tab");
        }
        
        
        
    }
    
    /*
    *   Update Class Details
    *   Principal / Cleark can Change
    *   
    */
    public void updateClassDetails(String id, String teacherId ) throws SQLException{
        
        UpdateQuery  = "UPDATE classtab SET TeacherID=? WHERE ID=?";
        pst = con.prepareStatement(UpdateQuery);
        
        pst.setString(1, teacherId);
        pst.setString(2, id);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Class Tab");
        }
        
        
    }
    
    /*
    *   Update Report Details
    *   Principal / Cleark can Change
    *   
    */
    public void updateReportDetails(String ReporterDate, String  ReporterID, String ProblemDetails, String ReportStatus) throws SQLException{
        
        UpdateQuery  = "UPDATE reporttab SET ReportStatus =?  WHERE ReporterDate=? AND ReporterID=? AND ProblemDetails=?";
        pst = con.prepareStatement(UpdateQuery);
        
        pst.setString(1,ReportStatus);
        pst.setString(2,ReporterDate);
        pst.setString(3,ReporterID);
        pst.setString(4,ProblemDetails);
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Update Report Tab");
        }
        
        
    }
    
    /************************ Update or Change End ***************************************/
    
    /*
    ========================================================================================
    ========================================================================================
    */
    
    /********************** Get Final ID Values  Start **********************************/
    
    /*
    *   Get Final Class ID
    *   class Tab
    */
    public String getClassFinalID() throws SQLException{        
        String lastId = "0";        
        String getIDQuery = "SELECT ID FROM classtab ORDER BY ID DESC LIMIT 1";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(5, lastId.length()); 
        }
        
       return lastId;
    }
    
    /*
    *   Get Final Subject ID
    *   Subject Tab
    */ 
    public String getSubjectFinalID() throws SQLException{        
        String lastId = "0" ;        
        String getIDQuery = "SELECT ID FROM subjecttab ORDER BY ID DESC LIMIT 1";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(7, lastId.length());   
        }
        return lastId;
    }
    
    /*
    *   Get Final Student ID
    */
    public String getStudentFinalID() throws SQLException{        
        String lastId = "0" ;        
        String getIDQuery = "SELECT ID FROM studenttab ORDER BY ID DESC LIMIT 1";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(1, lastId.length());   
        }
        return lastId;
    }
    
    /*
    *   Get Final Teacher ID
    */
    public String getTeacherFinalID() throws SQLException{        
        String lastId = "0" ;        
        String getIDQuery = "SELECT ID FROM teachertab ORDER BY ID DESC LIMIT 1";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(1, lastId.length());   
        }
        return lastId;
    }
    
    /*
    *   Get Final Principal ID
    */
    public String getPrincipalFinalID() throws SQLException{        
        String lastId = "0" ;        
        
        String getIDQuery = "SELECT ID FROM admintab WHERE ID LIKE \"%P%\" ORDER BY ID DESC LIMIT 1 ";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(1, lastId.length());   
        }
        return lastId;
    }
    
    /*
    *   Get Final Principal ID
    */
    public String getClearkFinalID() throws SQLException{        
        String lastId = "0" ;        
        
        String getIDQuery = "SELECT ID FROM admintab WHERE ID LIKE \"%C%\" ORDER BY ID DESC LIMIT 1 ";
        pst = con.prepareStatement(getIDQuery);
        rs = pst.executeQuery();

        if(rs.next()){
            lastId = rs.getString("ID");
            lastId = lastId.substring(1, lastId.length());   
        }
        return lastId;
    }
    
   /********************** Get Final ID Values  End **********************************/
    
    /*
    ========================================================================================
    ========================================================================================
    */
    
    /********************** set Drop Down Box Values  Start **********************************/
    
    /*
    *   Class, Term, Teacher, Subjects
    */
    /*
    *   Set Class Drop Down Box
    */
    public static void setClassNames() throws SQLException {
        getClass = "SELECT ID,Name FROM classtab";
        pst = con.prepareStatement(getClass);
        rs = pst.executeQuery(); 
        
        ClassDetails.clear();
        while(rs.next()){
            ClassDetails.add(new Student(rs.getString("ID"),rs.getString("Name")));
        }
    }
    
    /*
    *   Set Teacher Drop Down Box
    */
     public static void setTeachersNames() throws SQLException{
        getTeachers = "SELECT ID,Name FROM teachertab";
        
        pst = con.prepareStatement(getTeachers);
        rs = pst.executeQuery();
        
        Teachers.clear();
        while(rs.next()){
            Teachers.add(new Student(rs.getString("ID"),rs.getString("Name")));
        }
        
    }
    
    /*
    *   Set Admin Drop Down Box
    */
     public static void setAdminNames() throws SQLException{
        getAdmin = "SELECT ID,Name FROM admintab";
        
        pst = con.prepareStatement(getAdmin);
        rs = pst.executeQuery();
        
        Admin.clear();
        while(rs.next()){
            Admin.add(new Student(rs.getString("ID"),rs.getString("Name")));
        }
        
    }
     
     /*
    *   Set Term Drop Down Box
    */
     public static void setTerms(){
        Terms.clear();
        String TermsDetails[] = {"1st Term", "2nd Term", "3rd Term"};
        
        for(int i = 0; i<3; i++ ){
            Terms.add(TermsDetails[i]);
        }

    }
     
     /*
    *   Set Subjects Drop Down Box
    */
     public static void setSubjectsNames(String clsID) throws SQLException{
        getSubjects = "SELECT ID,Name FROM subjecttab WHERE ClassID=?";
//        SelectClass
        pst = con.prepareStatement(getSubjects);
        pst.setString(1, clsID);
        rs = pst.executeQuery();
        
        SubjectDetails.clear();
        while(rs.next()){
            SubjectDetails.add(new Student(rs.getString("ID"),rs.getString("Name")));
        }
        
    }
     
    /*
    *   Add Principals Types 
    */
    public static void addPrincipalTypes(){
        PrincpalTypes.clear();
        PrincpalTypes .add("Principal");
        PrincpalTypes .add("Vice Principal");
        PrincpalTypes .add("Deputy Principal");
    }
    
    /*
    *   Add Staffs Role Types 
    */
    public static void addRoleTypes(){
        RoleTypes.clear();
        RoleTypes .add("Principal");
        RoleTypes .add("Vice Principal");
        RoleTypes .add("Deputy Principal");
        RoleTypes .add("Teacher");
        RoleTypes .add("Cleark");
    }
    
    /*
    *   Add School Staffs Details
    *   Principal / Teacher / Cleark
    *   ID / Name / Appointment Date / Email / Mobile
    */
    public static void addStaffs() throws SQLException{
        String getStaffs,s1,s2,s3,s4,s5;
        
        // insert Principals Details in the AllStaffsTable ArrayList
        getStaffs = "SELECT ID, Name, AppointmentDate, Email, Mobile FROM admintab WHERE ID LIKE \"%P%\" ";
        
        
        pst = con.prepareStatement(getStaffs);
        rs = pst.executeQuery();
        AllStaffsTable.clear();

        while(rs.next()){
            s1 = rs.getString("ID");
            s2 = rs.getString("Name");
            s3 = rs.getString("AppointmentDate");
            s4 = rs.getString("Email");
            s5 = rs.getString("Mobile");
            AllStaffsTable.add(new Student(s1,s2,s3,s4,s5));
        }
        
        // insert Teacher Details in the AllStaffsTable ArrayList 
        getStaffs = "SELECT ID, Name, AppointmentDate, Email, Mobile FROM teachertab";
        pst = con.prepareStatement(getStaffs);
        rs = pst.executeQuery();
        while(rs.next()){
            s1 = rs.getString("ID");
            s2 = rs.getString("Name");
            s3 = rs.getString("AppointmentDate");
            s4 = rs.getString("Email");
            s5 = rs.getString("Mobile");
            AllStaffsTable.add(new Student(s1,s2,s3,s4,s5));
        }
        
        // insert Cleark Details in the AllStaffsTable ArrayList
        getStaffs = "SELECT ID, Name, AppointmentDate, Email, Mobile FROM admintab WHERE ID LIKE \"%C%\" ";
        pst = con.prepareStatement(getStaffs);
        rs = pst.executeQuery();

        while(rs.next()){
            s1 = rs.getString("ID");
            s2 = rs.getString("Name");
            s3 = rs.getString("AppointmentDate");
            s4 = rs.getString("Email");
            s5 = rs.getString("Mobile");
            AllStaffsTable.add(new Student(s1,s2,s3,s4,s5));
        }
   
    }
    
    /*
    *   get Class Name And Subject for Teacher 
    */
    public static void getClassAndSubject(String uID,int term,int year) throws SQLException{
        String getDetails,className,classSubject;
        getDetails = "SELECT s.Name, c.Name FROM subjecttab AS s , classtab AS c, teachertab as t WHERE s.ClassID = c.ID AND s.TeacherID = t.ID AND t.ID =? AND s.Term=? AND s.Year=?";
        
        pst = con.prepareStatement(getDetails);
        
        pst.setString(1, uID);
        pst.setInt(2, term);
        pst.setInt(3, year);
        
        rs = pst.executeQuery();
        
        while(rs.next()){
            className = rs.getString("c.Name");
            classSubject = rs.getString("s.Name");
            ClassSubjectDetails.add(new ReportStore(className,classSubject));
        }
        System.out.println("Get Class And Subject");
    }
    
    /*
    *   Get Subject and Teacher for Student
    */
    public static void getSubjectAndTeacher(String classID, int term, int year) throws SQLException{
        
        String getDetails,studentSubject,subjectTeacher;
        getDetails = "SELECT s.Name, t.Name FROM subjecttab AS s, teachertab AS t WHERE s.TeacherID = t.ID AND s.ClassID =? AND s.Term=? AND s.Year=?";
        
        pst = con.prepareStatement(getDetails);
        
        pst.setString(1, classID);
        pst.setInt(2, term);
        pst.setInt(3, year);
        
        rs = pst.executeQuery();
        
        while(rs.next()){
            studentSubject = rs.getString("s.Name");
            subjectTeacher = rs.getString("t.Name");
            subjectTeacherDetails.add(new ReportStore(studentSubject,subjectTeacher));
        }
        System.out.println("Get Class And Subject");
        
    }
    
    /*
    *   Get Subject and Teacher for TimeTable
    */
    public static void getSubjectAndTeacherID(String classID, int term, int year) throws SQLException{
        subjectTeacherDetails.clear();
        String getDetails,sName,tName,sID,tID;
        getDetails = "SELECT s.Name, s.ID, t.Name, t.ID FROM subjecttab AS s, teachertab AS t WHERE s.TeacherID = t.ID AND s.ClassID =? AND s.Term=? AND s.Year=?";
        
        pst = con.prepareStatement(getDetails);
        
        pst.setString(1, classID);
        pst.setInt(2, term);
        pst.setInt(3, year);
        
        rs = pst.executeQuery();
        int i = 0;
        while(rs.next()){
            sName = rs.getString("s.Name");
            tName = rs.getString("t.Name");
            sID = rs.getString("s.ID");
            tID = rs.getString("t.ID"); 
            subjectTeacherDetails.add(new ReportStore(sName,sID,tName,tID,i));
            i++;
        }
        System.out.println("Get Class And Subject");
        
    }
    
    /**
     * 
     * get Subject and Marks for Student 
     */
    public static  void getSubjectAndMarks( int year ,int term , String classId, String studentId) throws SQLException{
        String getDetails,studentSubject;
        int subjectMarks;
        getDetails = "SELECT s.name, m.Marks FROM subjecttab AS s, markstab as m where m.Year =? AND m.Term =? AND s.ClassID =? AND m.StudentID=? ";
        
        pst = con.prepareStatement(getDetails);
        
        pst.setInt(1, year);
        pst.setInt(2, term);
        pst.setString(3, classId);
        pst.setString(4, studentId);
        
        rs = pst.executeQuery();
        
        while(rs.next()){
            studentSubject = rs.getString("s.name");
            subjectMarks = rs.getInt("m.Marks");
            StudentSubjectMarksTable.add(new Student(studentSubject, subjectMarks));
            
        }
        
    }
    
    
    
    /*
    *   Getting All Students in the School
    */
    public static void getAllStudents() throws SQLException{
        String getStudentsList,s1,s2,s3,s4,s5,s6;
        getStudentsList = "SELECT * FROM studenttab";
        
        pst = con.prepareStatement(getStudentsList);
        rs = pst.executeQuery();
        StudentsDetails.clear();
        
        while(rs.next()){
            s1 = rs.getString("ID");
            s2 = rs.getString("Name");
            s3 = rs.getString("ClassID");
            s4 = rs.getString("AddmissionDate");
            s5 = rs.getString("Email");
            s6 = rs.getString("Mobile");
            StudentsDetails.add(new Student(s1, s2, s5, s6, s4, s3));
        }
        
    }
            
    /*
    *   Getting Student for Enter the Marks
    *   Class Name , Subject , Year
    */
    
     public static void GetStudentsforMarks(String cID) throws SQLException{
        String getStudentsList,s1,s2;
        getStudentsList = "SELECT ID,Name FROM studenttab WHERE ClassID=?";
        
        pst = con.prepareStatement(getStudentsList);
        pst.setString(1, cID);
        rs = pst.executeQuery();
        
        StudentsDetails.clear();
        
        while(rs.next()){
            s1 = rs.getString("ID");
            s2 = rs.getString("Name");
             StudentsDetails.add(new Student(s1, s2));
        }
        
    }
    
     
     /**
      * Get Students and Marks for Teacher
      */
     public static void getStudentsAndMarks(int year, int term, String SubjectID) throws SQLException{
//   SELECT s.Name, m.Marks FROM studenttab as s, markstab as m WHERE m.Year = 2022  AND m.Term = 1 AND m.SubjectID = 'SUBJECT000'	AND s.ClassID = 'CLASS000'
        String getStudentsList,s1;
        float s2;
        getStudentsList = "SELECT s.Name, m.Marks FROM studenttab AS s, markstab AS m WHERE m.Year =? AND m.Term =? AND m.SubjectID =? AND s.ID = m.StudentID ";
        
        StudentMarksTable.clear();
        
        pst = con.prepareStatement(getStudentsList);
        pst.setInt(1, year);
        pst.setInt(2, term);
        pst.setString(3, SubjectID);
        
        rs = pst.executeQuery();
        
        while(rs.next() ){
            s1 = rs.getString("s.Name");
            s2 = rs.getFloat("m.Marks");
            StudentMarksTable.add(new Student(s1, s2));
        }
        
     }
    
    /************************** set Drop Down Box Values End *****************************/
    /*
    ========================================================================================
    ========================================================================================
    */
    
     /************************** Delete Values Start *****************************/
     
    /*
     *  Delete Admin Details
     *  Principal / Cleark
    */
    public void deleteAdmin(String id) throws SQLException{
        
        deleteQuery="DELETE FROM admintab WHERE ID=?";
        
        pst = con.prepareStatement(deleteQuery);
        pst.setString(1, id);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Delete Admin Tab");
        }
    }
    
    /*
     *  Delete Teacher Details
     *  Teacher
    */
    public void deleteTeacher(String id)throws SQLException{
        deleteQuery="DELETE FROM teachertab WHERE ID=?";
        pst = con.prepareStatement(deleteQuery);
        pst.setString(1, id);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Delete Teacher Tab");
        }
    }
    
    /*
     *  Delete Student Details
     *  Student
    */
    public void deleteStudent(String id)throws SQLException{
        deleteQuery="DELETE FROM studenttab WHERE ID=?";
        pst = con.prepareStatement(deleteQuery);
        pst.setString(1, id);
        
        int x = pst.executeUpdate();
        
        if(x>0){
            System.out.println("Delete Student Tab");
        }
    }
    
 /************************** Delete Values End *****************************/
    
    
    
    /*
    * View Student Time Table
     */
    
    public static String viewStudentTimeTable(String cID, String day, int period) throws SQLException{
        Student.CalcuateTerm();
        String getDetailsQuery,subject = "-";
          
        getDetailsQuery = "SELECT s.Name FROM subjecttab as s, classtab as c WHERE c.ID=? AND c.ID =s.ClassID AND  s.ID =(SELECT t.SubjectID FROM timetable AS t WHERE t.Year =? AND t.Term =?  AND t.Day =? AND t.Period =? AND t.ClassID=?) ";
        pst = con.prepareStatement(getDetailsQuery);
        pst.setString(1, cID);
        pst.setInt(2, Student.currentYear);
        pst.setInt(3, Student.currentTerm);
        pst.setString(4, day);
        pst.setInt(5, period);
        pst.setString(6, cID);
        rs = pst.executeQuery();
        if(rs.next())
            subject = rs.getString("s.Name");
        
        return subject;
        
    } 
    
    
    /**
     *  Display teachers Time table
     */
//    SELECT s.Name,c.Name FROM subjecttab AS s, classtab AS c WHERE s.ClassID = c.ID  AND s.TeacherID='T0017' AND s.ID = (SELECT tt.SubjectID FROM  timetable AS tt WHERE tt.Year =2022 AND tt.Term =1 AND tt.Day ='Monday' AND tt.Period =1 )
    public static String viewTeacherTimeTable(String tID, String day, int period) throws SQLException{
        Student.CalcuateTerm();
        String getDetailsQuery,subject = "-";
          
        getDetailsQuery = "SELECT s.Name,c.Name FROM subjecttab AS s, classtab AS c WHERE s.ClassID = c.ID  AND s.TeacherID=? AND s.ID = (SELECT tt.SubjectID FROM  timetable AS tt WHERE tt.Year =? AND tt.Term =? AND tt.Day =? AND tt.Period =? AND tt.ClassID = c.ID)";
        pst = con.prepareStatement(getDetailsQuery);
        pst.setString(1, tID);
        pst.setInt(2, Student.currentYear);
        pst.setInt(3, Student.currentTerm);
        pst.setString(4, day);
        pst.setInt(5, period);
        rs = pst.executeQuery();
        if(rs.next())
            subject = rs.getString("s.Name");
        
        return subject;
        
    } 


    /*
    * get Techer Class 
    */
    public static String GetTeacherClass(String tID) throws SQLException {
        getClass = "Select ID FROM classtab WHERE TeacherID = ?";
        
        pst  = con.prepareStatement(getClass);
        
        pst.setString(1, tID);
        
        rs = pst.executeQuery();
        
        if(rs.next())
            return rs.getString("ID");
        else
            return  "";
    }
    
   /********************************************************************/
    

}

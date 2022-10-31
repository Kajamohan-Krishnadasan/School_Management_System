/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;

import java.sql.SQLException;

/**
 *
 * @author Kajamohan
 */
public class ReportStore {
    String rDate, reporterID,reporterName,rProblem,rStatus;
    String className,Subject;
    String sName,sID,tName,tID;

    public ReportStore(String sName, String sID, String tName, String tID, int x) {
        this.sName = sName;
        this.sID = sID;
        this.tName = tName;
        this.tID = tID;
        this.x = x;
    }
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public String getClassName() {
        return className;
    }

    public String getSubject() {
        return Subject;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public ReportStore(String className, String Subject) {
        this.className = className;
        this.Subject = Subject;
    }
    
    

    public ReportStore(String rDate, String reporterID, String rProblem, String rStatus) throws SQLException {
        this.rDate = rDate;
        this.reporterID = reporterID;
        this.rProblem = rProblem;
        this.rStatus = rStatus;
        
    }
    
   
    
    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getReporterID() {
        return reporterID;
    }

    public void setReporterID(String reporterID) {
        this.reporterID = reporterID;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getrProblem() {
        return rProblem;
    }

    public void setrProblem(String rProblem) {
        this.rProblem = rProblem;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }
    
    
}

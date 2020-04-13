package com.hibernate.crud;

import java.util.List;

public class AppMain {
	
    public static void main(String[] args) {
        System.out.println(".......Hibernate Crud Operations Example.......\n");
 
        System.out.println("\n=======CREATE RECORDS=======\n");
        DbOperations.createRecord();
 
        System.out.println("\n=======READ RECORDS=======\n");
        List<Student>  ListviewStudents = DbOperations.displayRecords();
        if(ListviewStudents != null & ListviewStudents.size() > 0) {
            for(Student studentObj : ListviewStudents) {
                System.out.println(studentObj.toString());
            }
        }
 
        System.out.println("\n=======UPDATE RECORDS=======\n");
        int updateId = 1;
        DbOperations.updateRecord(updateId);
        System.out.println("\n=======READ RECORDS AFTER UPDATION=======\n");
        List<Student> updateStudent = DbOperations.displayRecords();
        if(updateStudent != null & updateStudent.size() > 0) {
            for(Student studentObj : updateStudent) {
                System.out.println(studentObj.toString());
            }
        }
 
        System.out.println("\n=======DELETE RECORD=======\n");
        int deleteId = 5;
        DbOperations.deleteRecord(deleteId);
        System.out.println("\n=======READ RECORDS AFTER DELETION=======\n");
        List<Student> deleteStudentRecord = DbOperations.displayRecords();
        for(Student studentObj : deleteStudentRecord) {
            System.out.println(studentObj.toString());
        }
 
        System.out.println("\n=======DELETE ALL RECORDS=======\n");
        DbOperations.deleteAllRecords();
        System.out.println("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        List deleteAll = DbOperations.displayRecords();
        if(deleteAll.size() == 0) {
            System.out.println("\nNo Records Are Present In The Database Table!\n");
        }       
        System.exit(0);
    } 
}

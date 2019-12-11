package com.main;


import com.dao.SchoolkidsDAO;
import com.dao.impl.SchoolkidsDAOimpl;

public class Main {
    public static void main(String[] args) {
        SchoolkidsDAO schoolkidsDAO = new SchoolkidsDAOimpl();
        /*Schoolkids schoolkid = new Schoolkids("alexey", schoolkid_yearofstudy: "6");
        SchoolkidsDAO.insertSchoolkid(schoolkid);*/
        //schoolkidsDAO.insertSchoolkid2("alexey",6);
        schoolkidsDAO.insertSchoolkid(6,"sssss",6);

    }
}
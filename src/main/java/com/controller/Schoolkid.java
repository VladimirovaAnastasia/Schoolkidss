package com.controller;

import com.dao.SchoolkidsDAO;
import com.dao.impl.SchoolkidsDAOimpl;
import com.models.Schoolkids;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/schoolkids")
public class Schoolkid{

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllSchoolkids() {
        try {
            SchoolkidsDAO schoolkidsDAO = new SchoolkidsDAOimpl();
            //schoolkidsDAO.insertSchoolkid(7,"Ананас", 4);
            return schoolkidsDAO.getSchoolkids();
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "schoolkidId") int schoolkidId,
                          @RequestParam(value = "schoolkidName") String schoolkidName,
                          @RequestParam(value = "schoolkidYearofstudy") int schoolkidYearofstudy){
        try {
            SchoolkidsDAO schoolkidsDAO = new SchoolkidsDAOimpl();
            schoolkidsDAO.insertSchoolkid(schoolkidId, schoolkidName, schoolkidYearofstudy);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update (@RequestParam(value = "schoolkidId") int schoolkidId,
                          @RequestParam(value = "schoolkidName") String schoolkidName,
                          @RequestParam(value = "schoolkidYearofstudy") int schoolkidYearofstudy){
        try {
            SchoolkidsDAO schoolkidsDAO = new SchoolkidsDAOimpl();
            schoolkidsDAO.updateSchoolkid(schoolkidId, schoolkidName, schoolkidYearofstudy);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully updated!";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id) {
        try {
            SchoolkidsDAO schoolkidsDAO = new SchoolkidsDAOimpl();
            schoolkidsDAO.deleteSchoolkid(id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucsess";
    }

}
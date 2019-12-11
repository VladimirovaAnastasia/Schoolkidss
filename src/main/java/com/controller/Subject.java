package com.controller;

import com.dao.SubjectsDAO;
import com.dao.impl.SubjectsDAOimpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/subjects")
public class Subject{

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllSubjects() {
        try {
            SubjectsDAO subjectsDAO = new SubjectsDAOimpl();
            return subjectsDAO.getSubjects();
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "subjectId") int subjectId,
                          @RequestParam(value = "subjectTitle") String subject_title,
                          @RequestParam(value = "subjectStartyear") int subject_year){
        try {
            SubjectsDAO subjectsDAO = new SubjectsDAOimpl();
            subjectsDAO.insertSubject(subject_title, subject_year);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id) {
        try {
            SubjectsDAO subjectsDAO = new SubjectsDAOimpl();
            subjectsDAO.deleteSubject(id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucsess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update (@RequestParam(value = "subjectId") int subjectId,
                          @RequestParam(value = "subjectTitle") String subject_title,
                          @RequestParam(value = "subjectStartyear") int subject_year){
        try {
            SubjectsDAO subjectsDAO = new SubjectsDAOimpl();
            subjectsDAO.updateSubject(subjectId, subject_title, subject_year);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully updated!";
    }

}
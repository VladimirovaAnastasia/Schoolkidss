package com.controller;

import com.dao.MarksDAO;
import com.dao.impl.MarksDAOimpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/marks")
public class Mark {

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getMarks(@RequestParam(value = "schoolkidId") int id) {
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            return marksDAO.getMarks(id);
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllMarks() {
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            return marksDAO.getAllMarks();
        } catch (Exception ex) {
            return null;
        }
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id) {
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            marksDAO.deleteMark(id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucsess";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "schoolkidId") int schoolkidId,
                          @RequestParam(value = "markDate") Date markDate,
                          @RequestParam(value = "markPoint") int markPoint,
                          @RequestParam(value = "markSubject") String markSubject){
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            marksDAO.createMark(schoolkidId, markDate, markPoint, markSubject);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "markId") int markId,
                          @RequestParam(value = "markPoint") int markPoint,
                          @RequestParam(value = "markDate") Date markDate,
                          @RequestParam(value = "schoolkidName") String schoolkidName,
                          @RequestParam(value = "subjectTitle") String subjectTitle
                          ){
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            marksDAO.createMarkNew(markId, markPoint, markDate, schoolkidName, subjectTitle);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(@RequestParam(value = "markId") int markId,
                          @RequestParam(value = "markPoint") int markPoint,
                          @RequestParam(value = "markDate") Date markDate,
                          @RequestParam(value = "schoolkidName") String schoolkidName,
                          @RequestParam(value = "subjectTitle") String subjectTitle
    ){
        try {
            MarksDAO marksDAO = new MarksDAOimpl();
            marksDAO.updateMark(markId, markPoint, markDate, schoolkidName, subjectTitle);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }


}

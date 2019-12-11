package com.controller;

import com.dao.HomeworksDAO;
import com.dao.TeachersDAO;
import com.dao.impl.HomeworksDAOimpl;
import com.dao.impl.TeachersDAOimpl;
import com.models.Homeworks;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/homeworks")
public class Homework {
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllHomeworks() {
        try {
            HomeworksDAO homeworksDAO = (HomeworksDAO) new HomeworksDAOimpl();
            return homeworksDAO.getHomeworks();
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllMarks() {
        try {
            HomeworksDAO homeworksDAO = new HomeworksDAOimpl();
            return homeworksDAO.getAllHomeworks();
        } catch (Exception ex) {
            return null;
        }
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id) {
        try {
            HomeworksDAO homeworksDAO = (HomeworksDAO) new HomeworksDAOimpl();
            homeworksDAO.deleteHomework(id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucsess";
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "homeworkId") int homeworkId,
                          @RequestParam(value = "homeworkTask") String homeworkTask,
                          @RequestParam(value = "schoolkidName") String schoolkidName,
                          @RequestParam(value = "subjectTitle") String subjectTitle
    ){
        try {
            HomeworksDAO homeworksDAO = new HomeworksDAOimpl();
            homeworksDAO.createHomework(homeworkId, homeworkTask, schoolkidName, subjectTitle);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(@RequestParam(value = "homeworkId") int homeworkId,
                         @RequestParam(value = "homeworkTask") String homeworkTask,
                         @RequestParam(value = "schoolkidName") String schoolkidName,
                         @RequestParam(value = "subjectTitle") String subjectTitle
    ){
        try {
            HomeworksDAO marksDAO = new HomeworksDAOimpl();
            marksDAO.updateHomework(homeworkId, homeworkTask, schoolkidName, subjectTitle);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }
}

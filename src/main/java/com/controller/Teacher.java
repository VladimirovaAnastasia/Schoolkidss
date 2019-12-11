package com.controller;

import com.dao.SubjectsDAO;
import com.dao.TeachersDAO;
import com.dao.impl.SubjectsDAOimpl;
import com.dao.impl.TeachersDAOimpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/teachers")
public class Teacher {
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getAllTeachers() {
        try {
            TeachersDAO teachersDAO = new TeachersDAOimpl();
            return teachersDAO.getTeachers();
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create (@RequestParam(value = "teacherId") int teacher_id,
                          @RequestParam(value = "teacherFullname") String teacher_name,
                          @RequestParam(value = "teacherInfo") String teacher_info)  {
        try {
            TeachersDAO teachersDAO = new TeachersDAOimpl();
            teachersDAO.insertTeacher(teacher_name, teacher_info);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully saved!";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete(int id) {
        try {
            TeachersDAO teachersDAO = new TeachersDAOimpl();
            teachersDAO.deleteTeacher(id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucsess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String update (@RequestParam(value = "teacherId") int teacher_id,
                          @RequestParam(value = "teacherFullname") String teacher_name,
                          @RequestParam(value = "teacherInfo") String teacher_info)  {
        try {
            TeachersDAO teachersDAO = new TeachersDAOimpl();
            teachersDAO.updateTeacher(teacher_id, teacher_name, teacher_info);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person succesfully updated!";
    }

}

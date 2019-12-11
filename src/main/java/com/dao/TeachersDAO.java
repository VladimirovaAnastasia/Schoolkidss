package com.dao;

import com.models.Teachers;

import java.util.List;

public interface TeachersDAO {

    public void insertTeacher(String teachers_fullname, String teachers_info);

    public void deleteTeacher(int teacher_id);

    public void updateTeacher(int teacher_id, String teachers_fullname, String teachers_info);

    public List<Teachers> getTeachers();

}

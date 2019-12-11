package com.dao;

import com.models.Homeworks;
import com.models.Schoolkids;
import com.models.Subjects;

import java.util.List;

public interface HomeworksDAO {

    public void deleteHomework(int homework_id);

    public void createHomework(int homeworkId, String homeworkTask, String schoolkidName, String subjectTitle);

    public void updateHomework(int homeworkId, String homeworkTask, String schoolkidName, String subjectTitle);

    public List<Homeworks> getHomeworks();

    public List<Homeworks> getAllHomeworks();

}

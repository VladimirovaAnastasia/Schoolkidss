package com.dao;

import com.models.Marks;
import com.models.Schoolkids;
import com.models.Subjects;
import com.models.Teachers;

import java.sql.Date;
import java.util.List;

public interface MarksDAO {

    public void createMark(int subject_id, Date mark_date, int point, String subject);

    public void createMarkNew(int markId, int markPoint, Date markDate, String schoolkidName, String subjectTitle);

    public void deleteMark(int mark_id);

    public void updateMark(int markId, int markPoint, Date markDate, String schoolkidName, String subjectTitle);

    public List<Marks> getMarks(int id);

    public List<Marks> getAllMarks();

}

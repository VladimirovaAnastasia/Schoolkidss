package com.dao;

import com.models.Subjects;

import java.util.List;

public interface SubjectsDAO {

    public void insertSubject(String subject_title, int subject_startyear);

    public void deleteSubject(int subject_id);

    public void updateSubject(int subjectId, String subject_title, int subject_startyear);

    public List<Subjects> getSubjects();
}

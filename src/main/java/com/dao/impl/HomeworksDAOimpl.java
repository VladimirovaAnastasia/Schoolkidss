package com.dao.impl;

import com.dao.HomeworksDAO;
import com.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HomeworksDAOimpl implements HomeworksDAO {
    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }


    public void deleteHomework(int homework_id){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Homeworks homework = session.load(Homeworks.class,homework_id);
        homework.setSchoolkids(null);
        homework.setSubjects(null);
        session.delete(homework);
        transaction.commit();
    }

    public List<Homeworks> getAllHomeworks(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Homeworks> homeworks = session.createQuery("from Homeworks ").list();
        transaction.commit();
        return homeworks;
    }

    public void updateHomework(int homeworkId, String homeworkTask, String schoolkidName, String subjectTitle){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids where schoolkid_fullname=:schoolkid_fullname")
                .setParameter("schoolkid_fullname",schoolkidName)
                .list();

        List<Subjects> subjects = session.createQuery("from Subjects where subject_title=:subject_title")
                .setParameter("subject_title",subjectTitle)
                .list();

        Homeworks updateHomework = session.load(Homeworks.class,homeworkId);
        updateHomework.setHomeworkTask(homeworkTask);
        updateHomework.setSchoolkids(schoolkids.get(0));
        updateHomework.setSubjects(subjects.get(0));
        session.update(updateHomework);
        transaction.commit();
    }

    public void createHomework(int homeworkId, String homeworkTask, String schoolkidName, String subjectTitle){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        List<Subjects> subjects = session.createQuery("from Subjects where subject_title=:subject_title")
                .setParameter("subject_title",subjectTitle)
                .list();

        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids where schoolkid_fullname=:schoolkid_fullname")
                .setParameter("schoolkid_fullname",schoolkidName)
                .list();

        Homeworks homework = new Homeworks(homeworkId, homeworkTask, schoolkids.get(0), subjects.get(0));
        session.save(homework);
        transaction.commit();
    }


    public List<Homeworks> getHomeworks(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Homeworks> homeworks = session.createQuery("from Homeworks").list();
        transaction.commit();
        return homeworks;
    }
}

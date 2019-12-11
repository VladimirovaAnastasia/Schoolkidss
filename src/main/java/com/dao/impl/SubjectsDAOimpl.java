package com.dao.impl;


import com.dao.SubjectsDAO;
import com.models.Schoolkids;
import com.models.Subjects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SubjectsDAOimpl implements SubjectsDAO {

    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public void insertSubject(String subject_title, int subject_startyear){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Subjects subject = new Subjects(subject_title, subject_startyear);
        session.save(subject);
        transaction.commit();
    }

    public void deleteSubject(int subject_id){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Subjects subject = session.load(Subjects.class,subject_id);
        session.delete(subject);
        transaction.commit();
    }

    public List<Subjects> getSubjects(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Subjects> subjects = session.createQuery("from Subjects ").list();
        transaction.commit();
        return subjects;
    }

    public void updateSubject(int subjectId, String subject_title, int subject_startyear){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Subjects updateSubject = session.load(Subjects.class,subjectId);
        updateSubject.setSubjectStartyear(subject_startyear);
        updateSubject.setSubjectTitle(subject_title);
        session.update(updateSubject);
        transaction.commit();
    }

}

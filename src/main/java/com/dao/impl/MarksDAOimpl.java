package com.dao.impl;

import com.controller.Schoolkid;
import com.controller.Teacher;
import com.dao.MarksDAO;
import com.models.Marks;
import com.models.Schoolkids;
import com.models.Subjects;
import com.models.Teachers;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;

public class MarksDAOimpl implements MarksDAO {

    private Session createHibernateSession() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public void deleteMark(int mark_id) {
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        Marks mark = session.load(Marks.class,mark_id);

        Subjects subject = mark.getSubjects();
        subject.getMarks().remove(mark);
        session.save(subject);

        Schoolkids schoolkid = mark.getSchoolkids();
        schoolkid.getMarks().remove(mark);
        session.save(schoolkid);

        Teachers teacher = mark.getTeachers();
        teacher.getMarks().remove(mark);
        session.save(teacher);

        mark.setSubjects(null);
        mark.setSchoolkids(null);
        mark.setTeachers(null);
        session.update(mark);

        session.delete(mark);
        transaction.commit();
    }

    public void updateMark(int markId, int markPoint, Date markDate, String schoolkidName, String subjectTitle){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids where schoolkid_fullname=:schoolkid_fullname")
                .setParameter("schoolkid_fullname",schoolkidName)
                .list();

        List<Subjects> subjects = session.createQuery("from Subjects where subject_title=:subject_title")
                .setParameter("subject_title",subjectTitle)
                .list();

        Marks updateMark = session.load(Marks.class,markId);
        updateMark.setMarkPoint(markPoint);
        updateMark.setMarkDate(markDate);
        updateMark.setSchoolkids(schoolkids.get(0));
        updateMark.setSubjects(subjects.get(0));
        session.update(updateMark);
        transaction.commit();
    }


    public List<Marks> getAllMarks(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Marks> marks = session.createQuery("from Marks ").list();
        transaction.commit();
        return marks;
    }


    public void createMark(int schoolkid_id, Date mark_date, int point, String subject) {
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        List<Subjects> subjects = session.createQuery("from Subjects where subject_title=:subject_title")
                .setParameter("subject_title",subject)
                .list();

        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids where schoolkid_id=:schoolkid_id")
                .setParameter("schoolkid_id",schoolkid_id)
                .list();

        Marks mark = new Marks(mark_date, point, subjects.get(0), schoolkids.get(0));
        session.save(mark);

        transaction.commit();
    }

    public void createMarkNew(int markId, int markPoint, Date markDate, String schoolkidName, String subjectTitle){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();


        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids where schoolkid_fullname=:schoolkid_fullname")
                .setParameter("schoolkid_fullname",schoolkidName)
                .list();

        List<Subjects> subjects = session.createQuery("from Subjects where subject_title=:subject_title")
                .setParameter("subject_title",subjectTitle)
                .list();

        Marks mark = new Marks(markId, markPoint, markDate, schoolkids.get(0),subjects.get(0));
        session.save(mark);

        transaction.commit();
    }

    public List getMarks(int id) {
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();

        //Criteria userCriteria = session.createCriteria(Marks.class);

        //userCriteria.add(Restrictions.eq("schoolkids.schoolkid_id", id));

        //List marks = userCriteria.list();

        List<Marks> marks = session.createQuery("from Marks where schoolkids.schoolkid_id=:id")
                .setParameter("id",id)
                .list();

        transaction.commit();
        return marks;
    }
}


package com.dao.impl;

import com.dao.TeachersDAO;
import com.models.Teachers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TeachersDAOimpl implements TeachersDAO{

    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public void insertTeacher(String teachers_fullname, String teachers_info){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Teachers teacher = new Teachers(teachers_fullname, teachers_info);
        session.save(teacher);
        transaction.commit();
    }

    public void deleteTeacher(int teacher_id){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Teachers teacher = session.load(Teachers.class,teacher_id);
        session.delete(teacher);
        transaction.commit();
    }

    public List<Teachers> getTeachers(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Teachers> teachers = session.createQuery("from Teachers ").list();
        transaction.commit();
        return teachers;
    }

    public void updateTeacher(int teacher_id, String teachers_fullname, String teachers_info){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Teachers updateTeacher = session.load(Teachers.class,teacher_id);
        updateTeacher.setTeacherFullname(teachers_fullname);
        updateTeacher.setTeacherInfo(teachers_info);
        session.update(updateTeacher);
        transaction.commit();
    }


}

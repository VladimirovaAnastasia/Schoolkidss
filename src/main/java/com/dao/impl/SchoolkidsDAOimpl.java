package com.dao.impl;

import com.dao.SchoolkidsDAO;
import com.models.Schoolkids;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class SchoolkidsDAOimpl implements SchoolkidsDAO{


    private Session createHibernateSession(){
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }


    public void insertSchoolkid(int schoolkid_id, String schoolkid_fullname, int schoolkid_yearofstudy){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Schoolkids schoolkid = new Schoolkids(schoolkid_id, schoolkid_fullname, schoolkid_yearofstudy);
        session.save(schoolkid);
        transaction.commit();
    }

    public void insertSchoolkid2(String schoolkid_fullname, int schoolkid_yearofstudy){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Schoolkids schoolkid = new Schoolkids(schoolkid_fullname, schoolkid_yearofstudy);
        session.save(schoolkid);
        transaction.commit();
    }

    public void deleteSchoolkid(int schoolkid_id){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        Schoolkids schoolkid = session.load(Schoolkids.class,schoolkid_id);
        session.delete(schoolkid);
        transaction.commit();
    }

    public List<Schoolkids> getSchoolkids(){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        List<Schoolkids> schoolkids = session.createQuery("from Schoolkids ").list();
        transaction.commit();
        return schoolkids;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Schoolkids> getSchoolkids2() {
        return entityManager.createQuery("from Schoolkids c order by c.schoolkid_id desc", Schoolkids.class).getResultList();
    }



    public void updateSchoolkid(int schoolkid_id, String schoolkid_fullname, int schoolkid_yearofstudy){
        Session session = createHibernateSession();
        Transaction transaction = session.beginTransaction();
        //Query query = session.createQuery("update Schoolkids" + " SET schoolkid_fullname = :schoolkid_fullname_par" + ", schoolkid_yearofstudy = :schoolkid_yearofstudy_par" +
        //        " where schoolkid_id = :schoolkid_id");
        //query.setParameter("schoolkid_fullname_par", schoolkid_fullname);
        //query.setParameter("schoolkid_yearofstudy_par", schoolkid_yearofstudy);
        //query.setParameter("schoolkid_id", schoolkid_id);
        //int result = query.executeUpdate();
        Schoolkids updateSchoolkid = session.load(Schoolkids.class,schoolkid_id);
        updateSchoolkid.setSchoolkidName(schoolkid_fullname);
        updateSchoolkid.setSchoolkidYearofstudy(schoolkid_yearofstudy);
        session.update(updateSchoolkid);
        transaction.commit();
    }

}

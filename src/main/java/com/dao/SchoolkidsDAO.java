package com.dao;

import com.models.Schoolkids;

import java.util.List;

public interface SchoolkidsDAO {

    public void insertSchoolkid(int schoolkid_id, String schoolkid_fullname, int schoolkid_yearofstudy);
    public void insertSchoolkid2(String schoolkid_fullname, int schoolkid_yearofstudy);

    public void deleteSchoolkid(int schoolkid_id);

    public List<Schoolkids> getSchoolkids();

    public void updateSchoolkid(int schoolkid_id, String schoolkid_fullname, int schoolkid_yearofstudy);

    public List<Schoolkids> getSchoolkids2();


}

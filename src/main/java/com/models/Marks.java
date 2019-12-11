package com.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "marks")
public class Marks implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "mark_id", nullable = false)
    private int mark_id;

    @Basic
    @Column(name = "mark_date", nullable = false)
    private Date mark_date;

    @Basic
    @Column(name = "point", nullable = false)
    private int point;

/*    @OneToMany(targetEntity = com.models.Schoolkids.class, mappedBy = "marks", cascade = CascadeType.ALL)
    private Set<Schoolkids> schoolkids = new HashSet<Schoolkids>(0);*/

    @ManyToOne(targetEntity = com.models.Schoolkids.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolkid_id", referencedColumnName = "schoolkid_id")
    private Schoolkids schoolkids;

    /*@OneToMany(targetEntity = com.models.Teachers.class, mappedBy = "marks", cascade = CascadeType.ALL)
    private Set<Teachers> teachers = new HashSet<Teachers>(0);*/

    @ManyToOne(targetEntity = com.models.Teachers.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teachers teachers;

    /*@OneToMany(targetEntity = com.models.Subjects.class, mappedBy = "marks", cascade = CascadeType.ALL)
    private Set<Subjects> subjects = new HashSet<Subjects>(0);*/

    @ManyToOne(targetEntity = com.models.Subjects.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subjects subjects;

    public Marks() {
    }

    public Marks(int mark_id, Date mark_date, int point) {
        this.mark_id = mark_id;
        this.mark_date = mark_date;
        this.point = point;
    }

    public Marks(Date mark_date, int point, Subjects subjects, Schoolkids schoolkids) {
        this.mark_date = mark_date;
        this.point = point;
        this.subjects = subjects;
        this.schoolkids = schoolkids;
    }

    public Marks(int markId, int point, Date mark_date, Schoolkids schoolkid, Subjects subject) {
        this.mark_id = markId;
        this.point = point;
        this.mark_date = mark_date;
        this.schoolkids = schoolkid;
        this.subjects = subject;
    }

    public Marks(Date mark_date, int point) {
        this.mark_date = mark_date;
        this.point = point;
    }

    public Marks(Date mark_date, int point, Schoolkids schoolkid, Teachers teacher, Subjects subject) {
        this.mark_date = mark_date;
        this.point = point;
        this.schoolkids = schoolkid;
        this.subjects = subject;
        this.teachers = teacher;
    }

    public int getMarkId() {
        return mark_id;
    }

    public void setMarkId(int mark_id) {
        this.mark_id = mark_id;
    }

    public Date getMarkDate() {
        return mark_date;
    }

    public void setMarkDate(Date mark_date) {
        this.mark_date = mark_date;
    }

    public int getMarkPoint() {
        return point;
    }

    public void setMarkPoint(int point) {
        this.point = point;
    }

    public Schoolkids getSchoolkids() {
        return schoolkids;
    }

    public void setSchoolkids(Schoolkids schoolkids) {
        this.schoolkids = schoolkids;
    }

/*    public Set<Schoolkids> getSchoolkids(){
        return this.schoolkids;
    }

    public void setSchoolkids(Set<Schoolkids> schoolkids){
        this.schoolkids = schoolkids;
    }*/

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    /*public Set<Teachers> getTeachers(){
        return this.teachers;
    }

    public void setTeachers(Set<Teachers> teachers){
        this.teachers = teachers;
    }*/

/*    public Set<Subjects> getSubjects(){
        return this.subjects;
    }

    public void setSubjects(Set<Subjects> subjects){
        this.subjects = subjects;
    }*/

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
}
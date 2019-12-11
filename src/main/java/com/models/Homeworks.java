package com.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "homeworks")
public class Homeworks implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "homework_id", nullable = false)
    private int homework_id;

    @Basic
    @Column(name = "task", nullable = false)
    private String task;

/*    @OneToMany(targetEntity = com.models.Schoolkids.class, mappedBy = "homeworks", cascade = CascadeType.ALL)
    private Set<Schoolkids> schoolkids = new HashSet<Schoolkids>(0);*/

    @ManyToOne(targetEntity = com.models.Schoolkids.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "schoolkid_id", referencedColumnName = "schoolkid_id")
    private Schoolkids schoolkids;

/*    @OneToMany(targetEntity = com.models.Subjects.class, mappedBy = "homeworks", cascade = CascadeType.ALL)
    private Set<Subjects> subjects = new HashSet<Subjects>(0);*/

    @ManyToOne(targetEntity = com.models.Subjects.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subjects subjects;

    public Homeworks() {
    }

    public Homeworks(int homework_id, String task, Schoolkids schoolkid) {
        this.homework_id = homework_id;
        this.task = task;
        this.schoolkids = schoolkid;
    }

    public Homeworks(String task) {
        this.task = task;
    }

    public Homeworks(String task, Schoolkids schoolkid, Subjects subject) {
        this.task = task; this.schoolkids = schoolkid; this.subjects = subject;
    }

    public Homeworks(int homework_id, String task, Schoolkids schoolkid, Subjects subject) {
        this.homework_id = homework_id;
        this.task = task;
        this.schoolkids = schoolkid;
        this.subjects = subject;
    }


    public int getHomeworkId() {
        return homework_id;
    }

    public void setHomeworkId(int homework_id) {
        this.homework_id = homework_id;
    }

    public String getHomeworkTask() {
        return task;
    }

    public void setHomeworkTask(String task) {
        this.task = task;
    }

/*    public Set<Schoolkids> getSchoolkids(){
        return this.schoolkids;
    }

    public void setSchoolkids(Set<Schoolkids> schoolkids){
        this.schoolkids = schoolkids;
    }*/

    public Schoolkids getSchoolkids() {
        return schoolkids;
    }

    public void setSchoolkids(Schoolkids schoolkids) {
        this.schoolkids = schoolkids;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

/*    public Set<Subjects> getSubjects(){
        return this.subjects;
    }

    public void setSubjects(Set<Subjects> subjects){
        this.subjects = subjects;
    }*/

}
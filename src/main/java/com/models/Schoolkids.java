package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "schoolkids")
public class Schoolkids implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "schoolkid_id", nullable = false)
    private int schoolkid_id;

/*    @ManyToOne(targetEntity = com.models.Homeworks.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "homework_id", referencedColumnName = "homework_id")
    private Homeworks homeworks;*/

    @OneToMany(targetEntity = com.models.Homeworks.class, mappedBy = "schoolkids", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Homeworks> homeworks = new HashSet<Homeworks>(0);

/*    @ManyToOne(targetEntity = com.models.Marks.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mark_id", referencedColumnName = "mark_id")
    private Marks marks;*/

    @OneToMany(targetEntity = com.models.Marks.class, mappedBy = "schoolkids", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Marks> marks = new HashSet<Marks>(0);

    @Basic
    @Column(name = "schoolkid_fullname", nullable = false, length = 50)
    private String schoolkid_fullname;

    @Basic
    @Column(name = "schoolkid_yearofstudy", nullable = false)
    private int schoolkid_yearofstudy;

    public Schoolkids() {
    }

    public Set<Marks> getMarks() {
        return marks;
    }

    public void setMarks(Set<Marks> marks) {
        this.marks = marks;
    }

    public Schoolkids(int schoolkid_id, String schoolkid_fullname, int schoolkid_yearofstudy) {
        this.schoolkid_id = schoolkid_id;
        this.schoolkid_fullname = schoolkid_fullname;
        this.schoolkid_yearofstudy = schoolkid_yearofstudy;
    }

    public Schoolkids(String schoolkid_fullname, int schoolkid_yearofstudy) {
        this.schoolkid_fullname = schoolkid_fullname;
        this.schoolkid_yearofstudy = schoolkid_yearofstudy;
    }

    public int getSchoolkidId() {
        return schoolkid_id;
    }

    public void setSchoolkidId(int schoolkid_id) {
        this.schoolkid_id = schoolkid_id;
    }

    public String getSchoolkidName() {
        return schoolkid_fullname;
    }

    public void setSchoolkidName(String schoolkid_fullname) {
        this.schoolkid_fullname = schoolkid_fullname;
    }

    public int getSchoolkidYearofstudy() {
        return schoolkid_yearofstudy;
    }

    public void setSchoolkidYearofstudy(int schoolkid_yearofstudy) {
        this.schoolkid_yearofstudy = schoolkid_yearofstudy;
    }

}
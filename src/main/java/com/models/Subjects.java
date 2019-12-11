package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "subjects")
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "subject_id", nullable = false)
    private int subject_id;

/*    @ManyToOne(targetEntity = com.models.Homeworks.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "homework_id", referencedColumnName = "homework_id")
    private Homeworks homeworks;*/

    @OneToMany(targetEntity = com.models.Homeworks.class, mappedBy = "subjects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Homeworks> homeworks = new HashSet<Homeworks>(0);

/*    @ManyToOne(targetEntity = com.models.Marks.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mark_id", referencedColumnName = "mark_id")
    private Marks marks;*/

    @OneToMany(targetEntity = com.models.Marks.class, mappedBy = "subjects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Marks> marks = new HashSet<Marks>(0);


    @Basic
    @Column(name = "subject_title", nullable = false, length = 30)
    private String subject_title;

    @Basic
    @Column(name = "subject_startyear", nullable = false)
    private int subject_startyear;

    public Subjects() {
    }

    public Subjects(int subject_id, String subject_title, int subject_startyear) {
        this.subject_id = subject_id;
        this.subject_title = subject_title;
        this.subject_startyear = subject_startyear;
    }

    public Subjects(String subject_title, int subject_startyear) {
        this.subject_title = subject_title;
        this.subject_startyear = subject_startyear;
    }

    public Set<Marks> getMarks() {
        return marks;
    }

    public void setMarks(Set<Marks> marks) {
        this.marks = marks;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubjectTitle() {
        return subject_title;
    }

    public void setSubjectTitle(String subject_title) {
        this.subject_title = subject_title;
    }

    public int getSubjectStartyear() {
        return subject_startyear;
    }

    public void setSubjectStartyear(int subject_startyear) {
        this.subject_startyear = subject_startyear;
    }
}
package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "seqPK", sequenceName = "seqPK")
@Entity
@Table(name = "teachers")
public class Teachers implements Serializable {
    @Id
    @GeneratedValue(generator = "seqPK")
    @Column(name = "teacher_id", nullable = false)
    private int teacher_id;

    /*@ManyToOne(targetEntity = com.models.Marks.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mark_id", referencedColumnName = "mark_id")
    private Marks marks;*/

    @OneToMany(targetEntity = com.models.Marks.class, mappedBy = "teachers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Marks> marks = new HashSet<Marks>(0);

    @Basic
    @Column(name = "teacher_fullname", nullable = false, length = 50)
    private String teacher_fullname;

    @Basic
    @Column(name = "teacher_info", nullable = false)
    private String teacher_info;

    public Teachers() {
    }

    public Set<Marks> getMarks() {
        return marks;
    }

    public void setMarks(Set<Marks> marks) {
        this.marks = marks;
    }

    public Teachers(int teacher_id, String teacher_fullname, String teacher_info) {
        this.teacher_id = teacher_id;
        this.teacher_fullname = teacher_fullname;
        this.teacher_info = teacher_info;
    }

    public Teachers(String subject_title, String teacher_info) {
        this.teacher_fullname = subject_title;
        this.teacher_info = teacher_info;
    }

    public int getTeacherId() {
        return teacher_id;
    }

    public void setTeacherId(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacherFullname() {
        return teacher_fullname;
    }

    public void setTeacherFullname(String teacher_fullname) {
        this.teacher_fullname = teacher_fullname;
    }

    public String getTeacherInfo() {
        return teacher_info;
    }

    public void setTeacherInfo(String teacher_info) {
        this.teacher_info = teacher_info;
    }
}
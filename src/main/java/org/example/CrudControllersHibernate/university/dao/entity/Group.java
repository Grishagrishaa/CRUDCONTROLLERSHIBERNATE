package org.example.CrudControllersHibernate.university.dao.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Group", schema = "belstu")
@JsonDeserialize(builder = Group.Builder.class)
public class Group implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;

//    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.EAGER)
    //,cascade = CascadeType.REMOVE, orphanRemoval = true
    private List<Student> students;

    public Group(String groupName, List<Student> students, Long id) {
        this.groupName = groupName;
        this.students = students;
        this.id = id;
    }

    public Group() {
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder{
        private Long id;
        private String groupName;
        private List<Student> students;

        private Builder(){
            students = new ArrayList<>();
        }

        public Builder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder setStudents(List<Student> students) {
            this.students = students;
            return this;
        }

        public Builder addStudents(Student student) {
            students.add(student);
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Group build(){
            return new Group(groupName, students, id);
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }
}

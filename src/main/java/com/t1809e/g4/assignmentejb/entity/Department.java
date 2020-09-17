package com.t1809e.g4.assignmentejb.entity;

import com.t1809e.g4.assignmentejb.utility.constance.ColumnName;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Department implements Serializable {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true)
    private String id;
    @Column(name = ColumnName.DEPARTMENT_NAME)
    private String name;
    @Column(name = ColumnName.DEPARTMENT_CREATED_AT)
    private LocalDateTime createdAt;
    @Column(name = ColumnName.DEPARTMENT_UPDATED_AT)
    private LocalDateTime updatedAt;
    @Column(name = ColumnName.DEPARTMENT_STATUS)
    private String status;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<User> users;

    public Department() {
    }

    public Department(String id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, String status, List<User> users) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

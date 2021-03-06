package com.t1809e.g4.assignmentejb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.t1809e.g4.assignmentejb.utility.constance.PropertyName;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(name = PropertyName.DEPARTMENT_NAME)
    private String name;
    @Column(name = PropertyName.DEPARTMENT_CREATED_AT)
    private LocalDateTime createdAt;
    @Column(name = PropertyName.DEPARTMENT_UPDATED_AT)
    private LocalDateTime updatedAt;
    @Column(name = PropertyName.DEPARTMENT_STATUS)
    private String status;

    public Department() {
    }

    public Department(String id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, String status) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
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

   }

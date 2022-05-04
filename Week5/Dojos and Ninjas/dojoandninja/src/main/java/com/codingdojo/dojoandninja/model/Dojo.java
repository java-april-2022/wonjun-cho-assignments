package com.codingdojo.dojoandninja.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dojo")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    public Dojo() {}

    @PrePersist
    public void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
}

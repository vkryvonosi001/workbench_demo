package com.example.workbench_demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name")
    private String clientName;
    @Column(name = "source")
    private String source;
}

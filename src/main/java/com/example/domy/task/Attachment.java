package com.example.domy.task;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;

    @Column(length = 1000)
    @NotBlank
    private String link;

    @Column(length = 100)
    private String name;

    @NotNull
    private Timestamp createdAt;


}

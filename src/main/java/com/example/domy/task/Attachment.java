package com.example.domy.task;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min=1,max = 1000)
    @NotBlank
    @URL
    private String link;

    @Column(length = 100)
    @Size(max = 100)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Timestamp createdAt;


}

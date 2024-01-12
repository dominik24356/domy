package com.example.domy.task;

import com.example.domy.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User author;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;

    @Column(length = 200)
    @Size(max = 200)
    private String content;

    @NotNull
    private Timestamp createdAt;

}

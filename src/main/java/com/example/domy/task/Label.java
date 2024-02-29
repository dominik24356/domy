package com.example.domy.task;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Label {

    public enum LabelColor {
        RED,
        GREEN,
        BLUE,
        YELLOW,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    @ManyToMany(mappedBy = "labels", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Column(length = 100, nullable = false)
    @Size(min=1,max = 100)
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private LabelColor color;


    // equals by name and color
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Label)) return false;
        Label label = (Label) o;
        return name.equals(label.name) && color == label.color;
    }


}

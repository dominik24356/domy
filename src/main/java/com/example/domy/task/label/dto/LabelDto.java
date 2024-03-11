package com.example.domy.task.label.dto;

import com.example.domy.task.label.Label;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class LabelDto {

    private Long labelId;

    private String name;

    private Label.LabelColor color;

    private Set<Long> taskIds;

}

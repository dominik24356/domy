package com.example.domy.task.dto;

import com.example.domy.task.Label;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class LabelCreateRequest {

    @Size(min=1,max = 100)
    @NotBlank
    private final String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private final Label.LabelColor color;


    @JsonCreator
    public LabelCreateRequest(String name,Label.LabelColor color) {
        this.name = name;
        this.color = color;
    }
}

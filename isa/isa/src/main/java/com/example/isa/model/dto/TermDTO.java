package com.example.isa.model.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TermDTO {
    private Long id;

    private String dateTerm;

    private Integer duration;

    public TermDTO(){

    }

    public TermDTO(Long id, LocalDateTime dateTerm, Integer duration) {
        this.id = id;
        this.dateTerm = dateTerm.toString();
        this.duration = duration;
    }
}

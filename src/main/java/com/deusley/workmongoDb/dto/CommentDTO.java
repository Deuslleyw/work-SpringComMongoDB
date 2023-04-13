package com.deusley.workmongoDb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String text;
    private Date date;
    private AuthorDTO authorDTO;

}

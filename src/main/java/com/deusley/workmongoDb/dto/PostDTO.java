package com.deusley.workmongoDb.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PostDTO {

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}

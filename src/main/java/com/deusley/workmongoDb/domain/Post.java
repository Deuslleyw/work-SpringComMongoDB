package com.deusley.workmongoDb.domain;

import com.deusley.workmongoDb.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getDate(), post.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate());
    }
}

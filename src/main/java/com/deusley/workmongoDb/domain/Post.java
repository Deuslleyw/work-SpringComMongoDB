package com.deusley.workmongoDb.domain;

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
    private User author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return Objects.equals(getId(), post.getId()) &&
                Objects.equals(getDate(), post.getDate())
                && Objects.equals(getTitle(), post.getTitle())
                && Objects.equals(getBody(), post.getBody());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getTitle(), getBody());
    }
}

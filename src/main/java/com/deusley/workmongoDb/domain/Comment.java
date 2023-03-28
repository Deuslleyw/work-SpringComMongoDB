package com.deusley.workmongoDb.domain;

import lombok.*;

import java.util.Date;
import java.util.Objects;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String id;
    private String text;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return Objects.equals(getId(), comment.getId())
                && Objects.equals(getText(), comment.getText())
                && Objects.equals(getDate(), comment.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getDate());
    }
}

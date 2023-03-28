package com.deusley.workmongoDb.domain;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


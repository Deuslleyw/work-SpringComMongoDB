package com.deusley.workmongoDb.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    private String id;
    private String name;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return getId().equals(userDTO.getId()) &&
                Objects.equals(getName(), userDTO.getName()) &&
                getEmail().equals(userDTO.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }
}

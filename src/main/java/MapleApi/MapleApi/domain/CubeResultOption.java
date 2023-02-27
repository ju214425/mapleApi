package MapleApi.MapleApi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@AllArgsConstructor
@Getter
public class CubeResultOption {
    private String value;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    protected CubeResultOption() {

    }
}

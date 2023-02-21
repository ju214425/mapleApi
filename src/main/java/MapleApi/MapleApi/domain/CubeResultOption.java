package MapleApi.MapleApi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
@Embeddable
@AllArgsConstructor
public class CubeResultOption {
    private String value;
    private Grade grade;
}

package MapleApi.MapleApi.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cube {

    @Id @GeneratedValue
    @Column(name = "cube_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CubeType name;

    private float epicUpgradeProbability;
    private float uniqueUpgradeProbability;
    private float legendaryUpgradeProbability;
}

package MapleApi.MapleApi.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CubeHistory {

    @Id @GeneratedValue
    @Column(name = "cube_history_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Cascade(CascadeType.ALL)
    private Member member;

    private OffsetDateTime createDate;

    @Enumerated(EnumType.STRING)
    private CubeType cubeType;

    private String itemUpgradeResult;
    private String miracleTimeFlag;

    @Embedded
    private Item item;

    @Enumerated(EnumType.STRING)
    private Grade potentialOptionGrade;
    @Enumerated(EnumType.STRING)
    private Grade additionalPotentialOptionGrade;

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "beforeUpValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "beforeUpGrade")),
    })
    private List<CubeResultOption> beforePotentialOptions;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "beforeDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "beforeDownGrade")),
    })
    private List<CubeResultOption> beforeAdditionalPotentialOptions;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterUpValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterUpGrade")),
    })
    private List<CubeResultOption> afterPotentialOptions;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterDownGrade")),
    })
    private List<CubeResultOption> afterAdditionalPotentialOptions;
}

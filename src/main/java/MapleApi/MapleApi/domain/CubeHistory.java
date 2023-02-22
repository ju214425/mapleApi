package MapleApi.MapleApi.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Builder
public class CubeHistory {

    @Id @GeneratedValue
    @Column(name = "cube_history_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    private OffsetDateTime createDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cube_id")
    private Cube cube;

    private String itemUpgradeResult;
    private String miracleTimeFlag;

    @Embedded
    private Item item;

    private Grade potentialOptionGrade;
    private Grade additionalPotentialOptionGrade;

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "beforeUpValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "beforeUpGrade")),
    })
    private List<CubeResultOption> beforePotentialOptionGrades;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "beforeDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "beforeDownGrade")),
    })
    private List<CubeResultOption> beforeAdditionalPotentialOptionGrades;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterUpValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterUpGrade")),
    })
    private List<CubeResultOption> afterPotentialOptionGrades;
    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterDownGrade")),
    })
    private List<CubeResultOption> afterAdditionalPotentialOptionGrades;
}

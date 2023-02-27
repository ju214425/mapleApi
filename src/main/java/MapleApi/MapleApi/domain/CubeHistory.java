package MapleApi.MapleApi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CubeHistory {

    @Id @GeneratedValue
    @Column(name = "cube_history_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "member_id")
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
    @Builder.Default
    private List<CubeResultOption> beforePotentialOptions = new ArrayList<>();

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "beforeDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "beforeDownGrade")),
    })
    @Builder.Default
    private List<CubeResultOption> beforeAdditionalPotentialOptions = new ArrayList<>();

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterUpValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterUpGrade")),
    })
    @Builder.Default
    private List<CubeResultOption> afterPotentialOptions = new ArrayList<>();

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "afterDownValue")),
            @AttributeOverride(name = "grade", column = @Column(name = "afterDownGrade")),
    })
    @Builder.Default
    private List<CubeResultOption> afterAdditionalPotentialOptions = new ArrayList<>();
}

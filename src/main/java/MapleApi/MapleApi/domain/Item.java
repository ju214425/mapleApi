package MapleApi.MapleApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@AllArgsConstructor
@Getter
public class Item {
    @Column(name = "item_equip_part")
    private String itemEquipPart;

    @Column(name = "item_level")
    private int itemLevel;

    @Column(name = "target_item")
    private String targetItem;

    protected Item() {

    }
}

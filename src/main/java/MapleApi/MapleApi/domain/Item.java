package MapleApi.MapleApi.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class Item {
    private String itemEquipPart;
    private int itemLevel;
    private String targetItem;
}

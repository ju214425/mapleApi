package MapleApi.MapleApi.domain;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
//    레어, 에픽, 유니크, 레전드리
    RARE("레어"),
    EPIC("에픽"),
    UNIQUE("유니크"),
    LEGENDARY("레전드리"),
    ERROR("에러");

    private final String name;

    Grade(String name) {
        this.name = name;
    }

    public static final Map<String, Grade> map = new HashMap<>();

    static {
        for (Grade grade : Grade.values()) {
            map.put(grade.getName(), grade);
        }
    }
    public static Grade getGradeByName(String code) {
        return map.get(code);
    }

    public String getName() {
        return name;
    }
}

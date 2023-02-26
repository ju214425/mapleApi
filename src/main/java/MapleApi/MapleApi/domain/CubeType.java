package MapleApi.MapleApi.domain;

import java.util.HashMap;
import java.util.Map;

public enum CubeType {
//       수상한큐브, 장인의큐브, 명장의큐브, 레드큐브, 블랙큐브, 에디셔널큐브, 잘못된 입력
       OCCULT("수상한 큐브", 0.9901, 0, 0),
       MASTER("장인의 큐브", 4.7619, 1.1858, 0),
       MEISTER("명장의 큐브", 7.9994, 1.6959, 0.1996),
       RED("레드 큐브", 6, 1.8, 0.3),
       BLACK("블랙 큐브", 15, 3.5, 1),
       ADDITIONAL("에디셔널 큐브", 4.7619, 1.9608, 0.4975);

       private final String name;
       private final double epicUpgradeProbability;
       private final double uniqueUpgradeProbability;
       private final double legendaryUpgradeProbability;

       CubeType(String name, double epic, double unique, double legendary) {
              this.name = name;
              this.epicUpgradeProbability = epic;
              this.uniqueUpgradeProbability = unique;
              this.legendaryUpgradeProbability = legendary;
       }

       public static final Map<String, CubeType> map = new HashMap<>();

       static {
              for (CubeType cubeType : CubeType.values()) {
                     map.put(cubeType.getName(), cubeType);
              }
       }
       public static CubeType getCubeTypeByName(String name) {
              return map.get(name);
       }

       public String getName() {
              return name;
       }


}

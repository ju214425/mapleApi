//package MapleApi.MapleApi.domain;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//import static MapleApi.MapleApi.domain.CubeType.*;
//
//@Entity
//@Getter @Setter
//@AllArgsConstructor
//public class Cube {
//
//    @Id @GeneratedValue
//    @Column(name = "cube_id")
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    private CubeType name;
//
//    public static CubeType findByCubeType(String cubeType) {
//        if(cubeType.equals("수상한 큐브")) {
//            return OCCULT;
//        } else if(cubeType.equals("장인의 큐브")) {
//            return MASTER;
//        } else if(cubeType.equals("명장의 큐브")) {
//            return MEISTER;
//        } else if(cubeType.equals("레드 큐브")) {
//            return RED;
//        } else if(cubeType.equals("블랙 큐브")) {
//            return BLACK;
//        } else {
//            return ADDITIONAL;
//        }
//    }
//}

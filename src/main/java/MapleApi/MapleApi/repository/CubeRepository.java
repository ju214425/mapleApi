//package MapleApi.MapleApi.repository;
//
//import MapleApi.MapleApi.domain.Cube;
//import jakarta.persistence.EntityManager;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository
//@AllArgsConstructor
//@Transactional(readOnly = true)
//public class CubeRepository {
//
//    private final EntityManager em;
//
//    public List<Cube> findAll() {
//        String psql = "select c from Cube c";
//        return em.createQuery(psql, Cube.class).getResultList();
//    }
//
//    public Cube findOne(Long id) {
//        return em.find(Cube.class, id);
//    }
//}

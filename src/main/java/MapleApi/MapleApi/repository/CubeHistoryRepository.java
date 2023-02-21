package MapleApi.MapleApi.repository;

import MapleApi.MapleApi.domain.CubeHistory;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class CubeHistoryRepository {

    private final EntityManager em;

    public List<CubeHistory> findAll() {
        String psql = "select ch from CubeHistory ch";
        return em.createQuery(psql, CubeHistory.class).getResultList();
    }

    public CubeHistory findOne(Long id) {
        return em.find(CubeHistory.class, id);
    }
}

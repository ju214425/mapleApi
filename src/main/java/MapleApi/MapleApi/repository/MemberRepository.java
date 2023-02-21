package MapleApi.MapleApi.repository;

import MapleApi.MapleApi.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class MemberRepository {

    private final EntityManager em;

    public List<Member> findAll() {
        String psql = "select u from Member u";
        return em.createQuery(psql, Member.class).getResultList();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
}

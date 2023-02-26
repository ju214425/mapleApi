package MapleApi.MapleApi.repository;

import MapleApi.MapleApi.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Transactional
public class MemberRepository {

    private final EntityManager em;

    public List<Member> findAll() {
        String psql = "select m from Member m";
        return em.createQuery(psql, Member.class).getResultList();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Optional<Member> findOneByName(String name) {
        String psql = "select m " +
                "from Member m " +
                "where m.name = :name";

        return em.createQuery(psql, Member.class)
                .setParameter("name", name)
                .getResultList().stream().findAny();
    }

    public void save(Member member) {
        em.persist(member);
    }
}

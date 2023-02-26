package MapleApi.MapleApi.service;

import MapleApi.MapleApi.domain.Member;
import MapleApi.MapleApi.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getUsers() {
        return memberRepository.findAll();
    }

    public Member getUser(Long id) {
        return memberRepository.findOne(id);
    }

    public Optional<Member> getUserByName(String name) {
        return memberRepository.findOneByName(name);
    }
}

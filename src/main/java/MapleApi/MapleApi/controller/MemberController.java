package MapleApi.MapleApi.controller;

import MapleApi.MapleApi.domain.Member;
import MapleApi.MapleApi.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public Result getUsers() {
        List<Member> findMembers = memberService.getUsers();
        List<UserDto> collect = findMembers.stream()
                .map(u -> new UserDto(u.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @GetMapping("/members/{id}")
    public Result getUser(@PathVariable Long id) {
        Member member = memberService.getUser(id);
        UserDto userDto = new UserDto(member.getName());

        return new Result(1, userDto);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class UserDto {
        private String name;
    }

}

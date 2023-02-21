package MapleApi.MapleApi.controller;

import MapleApi.MapleApi.domain.*;
import MapleApi.MapleApi.service.CubeHistoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CubeHistoryController {

    private final CubeHistoryService cubeHistoryService;

    @GetMapping("/cube-history")
    public Result getMember() {
        List<CubeHistory> findCubeHistories = cubeHistoryService.getCubeHistories();
        List<CubeHistoryDto> collect = findCubeHistories.stream()
                .map(ch -> new CubeHistoryDto(ch.getMember(), ch.getCreateDate(), ch.getCube(),
                        ch.getItemUpgradeResult(), ch.getMiracleTimeFlag(), ch.getItem(),
                        ch.getPotentialOptionGrade(), ch.getAdditionalPotentialOptionGrade()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @GetMapping("/cube-history/{id}")
    public Result getMember(@PathVariable Long id) {
        CubeHistory ch = cubeHistoryService.getCubeHistory(id);
        CubeHistoryDto cubeHistoryDto = new CubeHistoryDto(ch.getMember(), ch.getCreateDate(), ch.getCube(),
                ch.getItemUpgradeResult(), ch.getMiracleTimeFlag(), ch.getItem(),
                ch.getPotentialOptionGrade(), ch.getAdditionalPotentialOptionGrade());

        return new Result(1, cubeHistoryDto);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class CubeHistoryDto {
        private Member member;
        private LocalDate createDate;
        private Cube cube;

        private String itemUpgradeResult;
        private String miracleTimeFlag;

        private Item item;

        private Grade potentialOptionGrade;
        private Grade additionalPotentialOptionGrade;
    }

    @PostMapping("/cube-history")
    public CreateCubeHistoryResponse createCubeHistory(@RequestBody CreateCubeHistoryRequest request) {
        int count = request.getCount();
        List<CubeHistory> cubeHistories = request.getCube_histories();

        cubeHistories.forEach(cubeHistoryService::save);

        return new CreateCubeHistoryResponse(count);
    }

    @Data
    static class CreateCubeHistoryResponse {
        private int count;

        CreateCubeHistoryResponse(int count) {
            this.count = count;
        }
    }

    @Data
    static class CreateCubeHistoryRequest {
        private int count;
        private List<CubeHistory> cube_histories;
        private String next_cursor;
    }
}

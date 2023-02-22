package MapleApi.MapleApi.controller;

import MapleApi.MapleApi.domain.*;
import MapleApi.MapleApi.service.CubeHistoryService;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
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
                .map(ch -> CubeHistoryDto.builder()
                        .member(ch.getMember())
                        .createDate(ch.getCreateDate())
                        .cube(ch.getCube())
                        .itemUpgradeResult(ch.getItemUpgradeResult())
                        .miracleTimeFlag(ch.getMiracleTimeFlag())
                        .item(ch.getItem())
                        .potentialOptionGrade(ch.getPotentialOptionGrade())
                        .additionalPotentialOptionGrade(ch.getAdditionalPotentialOptionGrade())
                        .build())
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @GetMapping("/cube-history/{id}")
    public Result getMember(@PathVariable Long id) {
        CubeHistory ch = cubeHistoryService.getCubeHistory(id);
        CubeHistoryDto cubeHistoryDto = CubeHistoryDto.builder()
                .member(ch.getMember())
                .createDate(ch.getCreateDate())
                .cube(ch.getCube())
                .itemUpgradeResult(ch.getItemUpgradeResult())
                .miracleTimeFlag(ch.getMiracleTimeFlag())
                .item(ch.getItem())
                .potentialOptionGrade(ch.getPotentialOptionGrade())
                .additionalPotentialOptionGrade(ch.getAdditionalPotentialOptionGrade())
                .build();

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
    @Builder
    static class CubeHistoryDto {
        private Member member;
        private OffsetDateTime createDate;
        private Cube cube;

        private String itemUpgradeResult;
        private String miracleTimeFlag;

        private Item item;

        private Grade potentialOptionGrade;
        private Grade additionalPotentialOptionGrade;
    }

    @PostMapping("/cube-history")
    public CreateCubeHistoryResponse createCubeHistory(@RequestBody CreateCubeHistoriesRequest request) {
        int count = request.getCount();
        List<CreateCubeHistoryRequest> cubeHistories = request.getCubeHistories();

        for(CreateCubeHistoryRequest ch : cubeHistories) {
            cubeHistoryService.save(ch.toEntity());
        }

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
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    static class CreateCubeHistoriesRequest {
        private int count;
        private List<CreateCubeHistoryRequest> cubeHistories;
        private String nextCursor;
    }

    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    static class CreateCubeHistoryRequest {
        private Member member;
        private OffsetDateTime createDate;
        private Cube cube;

        private String itemUpgradeResult;
        private String miracleTimeFlag;

        private Item item;

        private Grade potentialOptionGrade;
        private Grade additionalPotentialOptionGrade;

        private List<CubeResultOption> beforePotentialOptionGrades;
        private List<CubeResultOption> beforeAdditionalPotentialOptionGrades;
        private List<CubeResultOption> afterPotentialOptionGrades;
        private List<CubeResultOption> afterAdditionalPotentialOptionGrades;

        public CubeHistory toEntity() {
            return CubeHistory.builder()
                    .member(member)
                    .createDate(createDate)
                    .cube(cube)
                    .itemUpgradeResult(itemUpgradeResult)
                    .miracleTimeFlag(miracleTimeFlag)
                    .item(item)
                    .potentialOptionGrade(potentialOptionGrade)
                    .additionalPotentialOptionGrade(additionalPotentialOptionGrade)
                    .beforePotentialOptionGrades(beforePotentialOptionGrades)
                    .beforeAdditionalPotentialOptionGrades(beforeAdditionalPotentialOptionGrades)
                    .afterPotentialOptionGrades(afterPotentialOptionGrades)
                    .afterAdditionalPotentialOptionGrades(afterAdditionalPotentialOptionGrades)
                    .build();
        }
    }
}

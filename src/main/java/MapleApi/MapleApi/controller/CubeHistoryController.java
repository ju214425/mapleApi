package MapleApi.MapleApi.controller;

import MapleApi.MapleApi.dto.CubeHistoryDto.*;
import MapleApi.MapleApi.service.CubeHistoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CubeHistoryController {

    private final CubeHistoryService cubeHistoryService;

    @GetMapping("/cube-history")
    public Result getMember() {
        List<CubeHistoryServiceDto> findCubeHistories = cubeHistoryService.getCubeHistories();

        List<CubeHistoryGetResponseDto> collect = findCubeHistories.stream()
                .map(CubeHistoryServiceDto::toControllerDto)
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @GetMapping("/cube-history/{id}")
    public Result getMember(@PathVariable Long id) {
        CubeHistoryServiceDto ch = cubeHistoryService.getCubeHistory(id);
        CubeHistoryGetResponseDto cubeHistoryDto = CubeHistoryGetResponseDto.builder()
                .characterName(ch.getCharacterName())
                .createDate(ch.getCreateDate())
                .cubeName(ch.getCubeType())
                .itemUpgradeResult(ch.getItemUpgradeResult())
                .miracleTimeFlag(ch.getMiracleTimeFlag())
                .itemEquipPart(ch.getItemEquipPart())
                .itemLevel(ch.getItemLevel())
                .targetItem(ch.getTargetItem())
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
    static class CreateCubeHistoryResponse<T> {
        private int count;
        private T data;
    }

    @PostMapping("/cube-histories")
    public CreateCubeHistoryResponse createCubeHistory(@RequestBody @Valid CubeHistoriesRequestDto request) {
        List<CubeHistoryRequestDto> cubeHistoryRequestDtoList = request.getCubeHistories();

        for (CubeHistoryRequestDto cubeHistoryRequestDto : cubeHistoryRequestDtoList) {
            cubeHistoryService.save(cubeHistoryRequestDto.toServiceDto());
        }

        return new CreateCubeHistoryResponse(cubeHistoryRequestDtoList.size(), cubeHistoryRequestDtoList);
    }
}

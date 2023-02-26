//package MapleApi.MapleApi.controller;
//
//import MapleApi.MapleApi.domain.Cube;
//import MapleApi.MapleApi.domain.CubeType;
//import MapleApi.MapleApi.service.CubeService;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequiredArgsConstructor
//public class CubeController {
//
//    private final CubeService cubeService;
//
//    @GetMapping("/cubes")
//    public Result getCubes() {
//        List<Cube> findCubes = cubeService.getCubes();
//        List<CubeDto> collect = findCubes.stream()
//                .map(c -> new CubeDto(c.getName(), c.getEpicUpgradeProbability(), c.getUniqueUpgradeProbability(), c.getLegendaryUpgradeProbability()))
//                .collect(Collectors.toList());
//
//        return new Result(collect.size(), collect);
//    }
//
//    @GetMapping("/cubes/{id}")
//    public Result getCubes(@PathVariable Long id) {
//        Cube c = cubeService.getCube(id);
//        CubeDto cubeDto = new CubeDto(c.getName(), c.getEpicUpgradeProbability(), c.getUniqueUpgradeProbability(), c.getLegendaryUpgradeProbability());
//
//
//        return new Result(1, cubeDto);
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class Result<T> {
//        private int count;
//        private T data;
//    }
//
//    @Data
//    @AllArgsConstructor
//    static class CubeDto {
//        private CubeType name;
//        private float epicUpgradeProbability;
//        private float uniqueUpgradeProbability;
//        private float legendaryUpgradeProbability;
//    }
//}

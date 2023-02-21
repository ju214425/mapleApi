package MapleApi.MapleApi.service;

import MapleApi.MapleApi.domain.Cube;
import MapleApi.MapleApi.repository.CubeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CubeService {

    private final CubeRepository cubeRepository;

    public List<Cube> getCubes() {
        return cubeRepository.findAll();
    }

    public Cube getCube(Long id) {
        return cubeRepository.findOne(id);
    }
}

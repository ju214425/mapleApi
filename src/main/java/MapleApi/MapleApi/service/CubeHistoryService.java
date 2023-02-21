package MapleApi.MapleApi.service;

import MapleApi.MapleApi.domain.CubeHistory;
import MapleApi.MapleApi.repository.CubeHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CubeHistoryService {

    private final CubeHistoryRepository cubeHistoryRepository;

    public List<CubeHistory> getCubeHistories() {
        return cubeHistoryRepository.findAll();
    }

    public CubeHistory getCubeHistory(Long id) {
        return cubeHistoryRepository.findOne(id);
    }
}

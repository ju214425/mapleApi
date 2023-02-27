package MapleApi.MapleApi.service;

import MapleApi.MapleApi.domain.*;
import MapleApi.MapleApi.dto.CubeHistoryDto.CubeHistoryServiceDto;
import MapleApi.MapleApi.repository.CubeHistoryRepository;
import MapleApi.MapleApi.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CubeHistoryService {

    private final CubeHistoryRepository cubeHistoryRepository;
    private final MemberRepository memberRepository;

    public List<CubeHistoryServiceDto> getCubeHistories() {
        List<CubeHistoryServiceDto> cubeHistoryServiceDtoList = new ArrayList<>();

        cubeHistoryRepository.findAll().forEach(ch ->
                cubeHistoryServiceDtoList.add(new CubeHistoryServiceDto(ch))
        );

        return cubeHistoryServiceDtoList;
    }

    public CubeHistoryServiceDto getCubeHistory(Long id) {
        return new CubeHistoryServiceDto(cubeHistoryRepository.findOne(id));
    }

    public Long save(CubeHistoryServiceDto cubeHistoryServiceDto) {
        String characterName = cubeHistoryServiceDto.getCharacterName();
        String cubeName = cubeHistoryServiceDto.getCubeType();
        String itemEquipPart = cubeHistoryServiceDto.getItemEquipPart();
        int itemLevel = cubeHistoryServiceDto.getItemLevel();
        String targetItem = cubeHistoryServiceDto.getTargetItem();
        String pog = cubeHistoryServiceDto.getPotentialOptionGrade();
        String apog = cubeHistoryServiceDto.getAdditionalPotentialOptionGrade();

        //캐릭터 명에 해당하는 계정 반환, 없으먄 계정 생성 후 반환
        Member findMember = memberRepository.findOneByName(characterName).
                orElseGet(() -> Member.builder().name(characterName).build());

        //많아봤자 10개 내외인 데이터를 데이터베이스에서 조회하긴 아까운데...
        //미리 메모리에 올려놓을 방법은 없나? 또는 임베디드 타입으로 전환 필요해 보임
        //Enum 사용하는 것으로 변경
        //TODO : 동적으로 추가하는 것이 불가능해짐, 동적을 추가할 수 있는 지 알아보자
        CubeType cubeType = CubeType.getCubeTypeByName(cubeName);

        //객체 계속 생성하면 안되는 걸로 보임
        //TODO 추후 보완 필요
        Item item = new Item(itemEquipPart, itemLevel, targetItem);

        Grade gradePog = Grade.getGradeByName(pog);
        Grade gradeApog = Grade.getGradeByName(apog);

        CubeHistory cubeHistory = cubeHistoryServiceDto.toEntity(findMember, cubeType, item, gradePog, gradeApog);

        cubeHistoryRepository.save(cubeHistory);

        //TODO 변경필요
        return 1L;
    }
}

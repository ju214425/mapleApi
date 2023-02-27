package MapleApi.MapleApi.dto;

import MapleApi.MapleApi.domain.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

public class CubeHistoryDto {
    /**
     * Web -> Controller Request Dto
     */
    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoryRequestDto {
        private String characterName;
        private OffsetDateTime createDate;
        private String cubeType;
        private String itemUpgradeResult;
        private String miracleTimeFlag;
        private String itemEquipPart;
        private int itemLevel;
        private String targetItem;
        private String potentialOptionGrade;
        private String additionalPotentialOptionGrade;
        private List<CubeResultOption> beforePotentialOptions;
        private List<CubeResultOption> beforeAdditionalPotentialOptions;
        private List<CubeResultOption> afterPotentialOptions;
        private List<CubeResultOption> afterAdditionalPotentialOptions;

        public CubeHistoryServiceDto toServiceDto() {

            return CubeHistoryServiceDto.builder()
                    .characterName(characterName)
                    .createDate(createDate)
                    .cubeType(cubeType)
                    .itemUpgradeResult(itemUpgradeResult)
                    .miracleTimeFlag(miracleTimeFlag)
                    .itemEquipPart(itemEquipPart)
                    .itemLevel(itemLevel)
                    .targetItem(targetItem)
                    .potentialOptionGrade(potentialOptionGrade)
                    .additionalPotentialOptionGrade(additionalPotentialOptionGrade)
                    .beforePotentialOptionGrades(beforePotentialOptions)
                    .beforeAdditionalPotentialOptionGrades(beforeAdditionalPotentialOptions)
                    .afterPotentialOptionGrades(afterPotentialOptions)
                    .afterAdditionalPotentialOptionGrades(afterAdditionalPotentialOptions)
                    .build();
        }
    }

    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoriesRequestDto {
        private int count;
        private List<CubeHistoryRequestDto> cubeHistories;
        private String nextCursor;
    }

    /**
     * Controller -> Web Get Response Dto
     */
    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoryGetResponseDto {
        private String characterName;
        private OffsetDateTime createDate;
        private String cubeName;

        private String itemUpgradeResult;
        private String miracleTimeFlag;

        private String itemEquipPart;
        private int itemLevel;
        private String targetItem;

        private String potentialOptionGrade;
        private String additionalPotentialOptionGrade;
    }

    /**
     * Controller -> Web Post Response Dto
     */
    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoryPostResponseDto {
        private int count;
    }

    /**
     * Controller -> Service Dto
     */
    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoryServiceDto {
        private String characterName;
        private OffsetDateTime createDate;
        private String cubeType;
        private String itemUpgradeResult;
        private String miracleTimeFlag;
        private String itemEquipPart;
        private int itemLevel;
        private String targetItem;
        private String potentialOptionGrade;
        private String additionalPotentialOptionGrade;
        private List<CubeResultOption> beforePotentialOptionGrades;
        private List<CubeResultOption> beforeAdditionalPotentialOptionGrades;
        private List<CubeResultOption> afterPotentialOptionGrades;
        private List<CubeResultOption> afterAdditionalPotentialOptionGrades;

        public CubeHistoryGetResponseDto toControllerDto() {
            return CubeHistoryGetResponseDto.builder()
                    .characterName(characterName)
                    .createDate(createDate)
                    .cubeName(cubeType)
                    .itemUpgradeResult(itemUpgradeResult)
                    .miracleTimeFlag(miracleTimeFlag)
                    .itemEquipPart(itemEquipPart)
                    .itemLevel(itemLevel)
                    .targetItem(targetItem)
                    .potentialOptionGrade(potentialOptionGrade)
                    .additionalPotentialOptionGrade(additionalPotentialOptionGrade)
                    .build();
        }

        public CubeHistoryServiceDto(CubeHistory cubeHistory) {
            this.characterName = cubeHistory.getMember().getName();
            this.createDate = cubeHistory.getCreateDate();
            this.cubeType = cubeHistory.getCubeType().getName();
            this.itemUpgradeResult = cubeHistory.getItemUpgradeResult();
            this.miracleTimeFlag = cubeHistory.getMiracleTimeFlag();
            this.itemEquipPart = cubeHistory.getItem().getItemEquipPart();
            this.itemLevel = cubeHistory.getItem().getItemLevel();
            this.targetItem = cubeHistory.getItem().getTargetItem();
            this.potentialOptionGrade = cubeHistory.getPotentialOptionGrade().getName();
            this.additionalPotentialOptionGrade = cubeHistory.getAdditionalPotentialOptionGrade().getName();
            this.beforePotentialOptionGrades = cubeHistory.getBeforePotentialOptions();
            this.beforeAdditionalPotentialOptionGrades = cubeHistory.getBeforeAdditionalPotentialOptions();
            this.afterPotentialOptionGrades = cubeHistory.getAfterPotentialOptions();
            this.afterAdditionalPotentialOptionGrades = cubeHistory.getAfterAdditionalPotentialOptions();
        }

        public CubeHistory toEntity(Member member, CubeType cubeType, Item item, Grade pog, Grade apog) {
            return CubeHistory.builder()
                    .member(member)
                    .createDate(createDate)
                    .cubeType(cubeType)
                    .itemUpgradeResult(itemUpgradeResult)
                    .miracleTimeFlag(miracleTimeFlag)
                    .item(item)
                    .potentialOptionGrade(pog)
                    .additionalPotentialOptionGrade(apog)
                    .beforePotentialOptions(beforePotentialOptionGrades)
                    .beforeAdditionalPotentialOptions(beforeAdditionalPotentialOptionGrades)
                    .afterPotentialOptions(afterPotentialOptionGrades)
                    .afterAdditionalPotentialOptions(afterAdditionalPotentialOptionGrades)
                    .build();
        }
    }

    /**
     * Controller -> Service Dto
     */
    @Data
    @AllArgsConstructor
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CubeHistoriesServiceDto {
        private int count;
        private List<CubeHistoryServiceDto> cubeHistories;
        private String nextCursor;
    }
}

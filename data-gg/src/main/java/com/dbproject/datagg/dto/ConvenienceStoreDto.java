package com.dbproject.datagg.dto;

import com.dbproject.datagg.entity.ConvenienceStoreEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ConvenienceStoreDto {
    @JsonProperty
    private String bizplcNm;  // 사업장명
    @JsonProperty
    private String refineLotnoAddr; // 소재지지번주소
    @JsonProperty
    private String refineRoadnmAddr; // 소재지도로명주소
    @JsonProperty
    private String refineWgs84Logt; // WGS84경도
    @JsonProperty
    private String refineWgs84Lat; // WGS84위도

    @Builder
    public ConvenienceStoreDto(String bizplcNm, String refineLotnoAddr, String refineRoadnmAddr, String refineWgs84Logt, String refineWgs84Lat) {
        this.bizplcNm = bizplcNm;
        this.refineLotnoAddr = refineLotnoAddr;
        this.refineRoadnmAddr = refineRoadnmAddr;
        this.refineWgs84Logt = refineWgs84Logt;
        this.refineWgs84Lat = refineWgs84Lat;
    }

    public ConvenienceStoreEntity toEntity() {
        return ConvenienceStoreEntity.builder()
                .bizplcNm(bizplcNm)
                .refineLotnoAddr(refineLotnoAddr)
                .refineRoadnmAddr(refineRoadnmAddr)
                .refineWgs84Lat(refineWgs84Lat)
                .refineWgs84Logt(refineWgs84Logt)
                .build();
    }

}

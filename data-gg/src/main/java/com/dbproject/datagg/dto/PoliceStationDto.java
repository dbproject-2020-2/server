package com.dbproject.datagg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PoliceStationDto {
    @JsonProperty
    private String localInstNm; // 지방청명
    @JsonProperty
    private String polcsttnNm; // 경찰서명
    @JsonProperty
    private String govofcNm;    // 관서명
    @JsonProperty
    private String refineRoadnmAddr; // 소재지도로명주소
    @JsonProperty
    private String refineLotnoAddr; // 소재지지번주소
    @JsonProperty
    private String refineWgs84Logt; // WGS84경도
    @JsonProperty
    private String refineWgs84Lat; // WGS84위도

    @Builder
    public PoliceStationDto(String localInstNm, String polcsttnNm, String govofcNm,
                            String refineRoadnmAddr, String refineLotnoAddr, String refineWgs84Logt, String refineWgs84Lat) {
        this.localInstNm = localInstNm;
        this.polcsttnNm = polcsttnNm;
        this.govofcNm = govofcNm;
        this.refineRoadnmAddr = refineRoadnmAddr;
        this.refineLotnoAddr = refineLotnoAddr;
        this.refineWgs84Logt = refineWgs84Logt;
        this.refineWgs84Lat = refineWgs84Lat;
    }
}

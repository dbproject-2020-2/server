package com.dbproject.datagg.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "convenience_store")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConvenienceStoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bizplc_nm")
    private String bizplcNm;  // 사업장명
    @Column(name = "refine_lotno_addr")
    private String refineLotnoAddr; // 소재지지번주소
    @Column(name = "refine_roadnm_addr")
    private String refineRoadnmAddr; // 소재지도로명주소
    @Column(name = "refine_wgs84_logt")
    private String refineWgs84Logt; // WGS84경도
    @Column(name = "refine_wgs84_lat")
    private String refineWgs84Lat; // WGS84위도

    @Builder
    public ConvenienceStoreEntity(String bizplcNm, String refineLotnoAddr, String refineRoadnmAddr, String refineWgs84Logt, String refineWgs84Lat) {
        this.bizplcNm = bizplcNm;
        this.refineLotnoAddr = refineLotnoAddr;
        this.refineRoadnmAddr = refineRoadnmAddr;
        this.refineWgs84Logt = refineWgs84Logt;
        this.refineWgs84Lat = refineWgs84Lat;
    }
}

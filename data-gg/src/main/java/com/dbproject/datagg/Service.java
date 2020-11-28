package com.dbproject.datagg;

import com.dbproject.datagg.dto.CctvDto;
import com.dbproject.datagg.dto.ConvenienceStoreDto;
import com.dbproject.datagg.dto.PoliceStationDto;
import com.dbproject.datagg.repository.ConvenienceStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    GGDataDreamApiClient ggDataDreamApiClient;
    @Autowired
    ConvenienceStoreRepository convenienceStoreRepository;

    public List<ConvenienceStoreDto> getOpenBsnStateConvenienceStoreList() throws JSONException {
        List<ConvenienceStoreDto> convenienceStoreDtoList = ggDataDreamApiClient.requestConvenienceStoreInfo();
        /*
        for(int i = 0; i < convenienceStoreDtoList.size(); i++) {
            convenienceStoreRepository.save(convenienceStoreDtoList.get(i).toEntity());
        }
        return convenienceStoreDtoList;
        */
        return ggDataDreamApiClient.requestConvenienceStoreInfo();
    }

    public List<PoliceStationDto> getPoliceStationList() throws JSONException {
        return ggDataDreamApiClient.requestPoliceStationInfo();
    }

    public List<CctvDto> getCctvList() throws JSONException {
        return ggDataDreamApiClient.requestCctvInfo();
    }

    public List<ConvenienceStoreDto> getNearConvenienceStoreList(HttpServletRequest request) throws JSONException {
        String currLogt = request.getParameter("currLog");  // 현재위치경도
        String currLat = request.getParameter("currLat");   // 현재위치위도

        return null;
    }
}

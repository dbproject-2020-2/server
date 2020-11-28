package com.dbproject.datagg;

import com.dbproject.datagg.dto.CctvDto;
import com.dbproject.datagg.dto.ConvenienceStoreDto;
import com.dbproject.datagg.dto.PoliceStationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(value = "/api/convenience-store")
    public List<ConvenienceStoreDto> getConvenienceStoreList() throws JSONException {
        return service.getOpenBsnStateConvenienceStoreList();
    }

    @RequestMapping(value = "/api/police-station")
    public List<PoliceStationDto> getPoliceStationList() throws JSONException {
        return service.getPoliceStationList();
    }

    @RequestMapping(value = "/api/cctv")
    public List<CctvDto> getCctvList() throws JSONException {
        return service.getCctvList();
    }

    @RequestMapping(value = "/api/near/convenience-store")
    public List<ConvenienceStoreDto> getNearConvenienceStoreList(HttpServletRequest request) throws JSONException {
        return service.getNearConvenienceStoreList(request);
    }
}
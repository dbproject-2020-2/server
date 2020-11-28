package com.dbproject.datagg;

import com.dbproject.datagg.dto.CctvDto;
import com.dbproject.datagg.dto.ConvenienceStoreDto;
import com.dbproject.datagg.dto.PoliceStationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GGDataDreamApiClient {
    private final String secretKey = "d09a48eee15444f4b98d7ee271ceb2b7";

    private final String SuwonCityConvenienceStoreUrl = "https://openapi.gg.go.kr/Resrestrtcvnstr"
            + "?Key=" + secretKey
            + "&Type=json"
            + "&SIGUN_NM=수원시";

    private final String SuwonCityPoliceStationUrl = "https://openapi.gg.go.kr/Ptrldvsnsubpolcstus"
            + "?Key=" +secretKey
            + "&Type=json"
            + "&SIGUN_NM=수원시";

    private final String SuwonCityCCTVUrl = "https://openapi.gg.go.kr/CCTV"
            + "?Key=" +secretKey
            + "&Type=json"
            + "&SIGUN_NM=수원시";

    @Autowired
    RestTemplate restTemplate1;
    @Autowired
    RestTemplate restTemplate2;
    @Autowired
    RestTemplate restTemplate3;

    public List<ConvenienceStoreDto> requestConvenienceStoreInfo() throws JSONException {

        String jsonString = restTemplate1.exchange(SuwonCityConvenienceStoreUrl, HttpMethod.GET, null, String.class).getBody();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("Resrestrtcvnstr");
        JSONObject row = (JSONObject) jsonArray.get(1);
        JSONArray convenienceStoreList = row.getJSONArray("row");

        List<ConvenienceStoreDto> convenienceStoreDtoList = new ArrayList<>();

        for(int i = 0; i < convenienceStoreList.length(); i++) {
            JSONObject convenienceStore = convenienceStoreList.getJSONObject(i);

            if (convenienceStore.getString("BSN_STATE_NM").equals("영업")) {
                String bizplcNm = convenienceStore.getString("BIZPLC_NM");
                String refineLotnoAddr = convenienceStore.getString("REFINE_LOTNO_ADDR");
                String refineRoadnmAddr = convenienceStore.getString("REFINE_ROADNM_ADDR");
                String refineWgs84Logt = convenienceStore.getString("REFINE_WGS84_LOGT");
                String refineWgs84Lat = convenienceStore.getString("REFINE_WGS84_LAT");

                ConvenienceStoreDto convenienceStoreDto = new ConvenienceStoreDto(bizplcNm, refineLotnoAddr, refineRoadnmAddr, refineWgs84Logt, refineWgs84Lat);
                convenienceStoreDtoList.add(convenienceStoreDto);
            }
        }

        return convenienceStoreDtoList;
    }

    public List<PoliceStationDto> requestPoliceStationInfo() throws JSONException {
        String jsonString = restTemplate2.exchange(SuwonCityPoliceStationUrl, HttpMethod.GET, null, String.class).getBody();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("Ptrldvsnsubpolcstus");
        JSONObject row = (JSONObject) jsonArray.get(1);
        JSONArray policeStationList = row.getJSONArray("row");

        List<PoliceStationDto> policeStationDtoList = new ArrayList<>();

        for(int i = 0; i < policeStationList.length(); i++) {
            JSONObject policeStation = policeStationList.getJSONObject(i);

            String localInstNm = policeStation.getString("LOCAL_INST_NM");
            String polcsttnNm = policeStation.getString("POLCSTTN_NM");
            String govofcNm = policeStation.getString("GOVOFC_NM");
            String refineRoadnmAddr = policeStation.getString("REFINE_ROADNM_ADDR");
            String refineLotnoAddr = policeStation.getString("REFINE_LOTNO_ADDR");
            String refineWgs84Logt = policeStation.getString("REFINE_WGS84_LOGT");
            String refineWgs84Lat = policeStation.getString("REFINE_WGS84_LAT");

            PoliceStationDto policeStationDto = new PoliceStationDto(localInstNm, polcsttnNm, govofcNm, refineRoadnmAddr, refineLotnoAddr, refineWgs84Logt, refineWgs84Lat);
            policeStationDtoList.add(policeStationDto);
        }

        return policeStationDtoList;
    }

    public List<CctvDto> requestCctvInfo() throws JSONException {
        String jsonString = restTemplate3.exchange(SuwonCityCCTVUrl, HttpMethod.GET, null, String.class).getBody();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("CCTV");
        JSONObject row = (JSONObject) jsonArray.get(1);
        JSONArray cctvList = row.getJSONArray("row");

        List<CctvDto> cctvDtoList = new ArrayList<>();

        for(int i = 0; i <cctvList.length(); i++) {
            JSONObject cctv = cctvList.getJSONObject(i);

            String refineRoadnmAddr = cctv.getString("REFINE_ROADNM_ADDR");
            String refineLotnoAddr = cctv.getString("REFINE_LOTNO_ADDR");
            String refineWgs84Logt = cctv.getString("REFINE_WGS84_LOGT");
            String refineWgs84Lat = cctv.getString("REFINE_WGS84_LAT");

            CctvDto cctvDto = new CctvDto(refineRoadnmAddr, refineLotnoAddr, refineWgs84Logt, refineWgs84Lat);
            cctvDtoList.add(cctvDto);
        }

        return cctvDtoList;
    }
}

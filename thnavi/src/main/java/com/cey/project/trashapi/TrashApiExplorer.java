package com.cey.project.trashapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;


/**
 * 전국휴지통표준데이터 api 관련
 */
public class TrashApiExplorer {
	
	@Value("${trashcan.api.url}")
	private String apiUrl;	//api url
	
	@Value("${trashcan.api.auth.key}")
	private String authKey; //일반 인증키
	
	@Value("${trashcan.api.enc.key}")
	private String encKey;	//encoding 인증키
	
	@Value("${trashcan.api.dec.key}")
	private String decKey;	//decoding 인증키
	
	
	// 전국휴지통표준데이터 API 호출
	public StringBuilder trashApiCall(Map<String, Object> paramMap) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(apiUrl); //api url
		urlBuilder.append("?" + URLEncoder.encode("serviceKey"     ,"UTF-8") + "=" + authKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo"         ,"UTF-8") + "=" + URLEncoder.encode("0"   , "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows"      ,"UTF-8") + "=" + URLEncoder.encode("100" , "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type"           ,"UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("INSTL_PLC_NM"   ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*설치장소명*/
        urlBuilder.append("&" + URLEncoder.encode("CTPV_NM"        ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*시도명*/
        urlBuilder.append("&" + URLEncoder.encode("SGG_NM"         ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*시군구명*/
        urlBuilder.append("&" + URLEncoder.encode("LCTN_ROAD_NM"   ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*소재지도로명주소*/
        urlBuilder.append("&" + URLEncoder.encode("LCTN_LOTNO_ADDR","UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*소재지지번주소*/
        urlBuilder.append("&" + URLEncoder.encode("LAT"            ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*위도*/
        urlBuilder.append("&" + URLEncoder.encode("LOT"            ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*경도*/
        urlBuilder.append("&" + URLEncoder.encode("ACTL_PSTN"      ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*세부위치*/
        urlBuilder.append("&" + URLEncoder.encode("TRASH_CAN_KND"  ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*휴지통종류*/
        urlBuilder.append("&" + URLEncoder.encode("MNG_INST_NM"    ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*관리기관명*/
        urlBuilder.append("&" + URLEncoder.encode("MNG_INST_TELNO" ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*관리기관전화번호*/
        urlBuilder.append("&" + URLEncoder.encode("CRTR_YMD"       ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("instt_code"     ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*제공기관코드*/
        urlBuilder.append("&" + URLEncoder.encode("instt_nm"       ,"UTF-8") + "=" + URLEncoder.encode(""    , "UTF-8")); /*제공기관기관명*/
		
		URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        System.out.println("response code : " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = rd.readLine()) != null) {
        	sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println("result : " + sb.toString());
		
		return sb;
	}
}

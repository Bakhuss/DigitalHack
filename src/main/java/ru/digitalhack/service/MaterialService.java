package ru.digitalhack.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class MaterialService {
    public String getMaterials(String page, String pageSize) {
        String url = "https://uchebnik.mos.ru/cms/api/materials?";
        if (page != null) url += "&page=" + page;
        if (pageSize != null) url += "&per_page=" + pageSize;
        System.out.println(url);
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "profile_type=demo");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());
        return exchange.getBody();
    }
}

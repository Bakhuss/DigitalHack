package ru.digitalhack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.digitalhack.model.Material;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialService {
    private final Logger log = LoggerFactory.getLogger(MaterialService.class);

    public String getMaterials(String page, String pageSize) {
        String url = "https://uchebnik.mos.ru/cms/api/materials?";

        if (page != null) url += "&page=" + page;
        if (pageSize != null) url += "&per_page=" + pageSize;
        log.info(url);

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "profile_type=demo");
        headers.add("Access-Control-Allow-Origin", "*");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());
        return exchange.getBody();
    }

    public List<Material> getMaterialsWithSubject(String page, String pageSize) {
        String url = "https://uchebnik.mos.ru/cms/api/materials?";

        if (page != null) url += "&page=" + page;
        if (pageSize != null) url += "&per_page=" + pageSize;
        log.info(url);

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "profile_type=demo");
        headers.add("Access-Control-Allow-Origin", "*");
        HttpEntity<Material> entity = new HttpEntity<>(new Material(), headers);
        ParameterizedTypeReference<List<Material>> list = new ParameterizedTypeReference<List<Material>>() {
        };
        ResponseEntity<List<Material>> exchange = template.exchange(url, HttpMethod.GET, entity, list);
        List<Material> body = exchange.getBody();

        String subject = "Математика";
        for (int i = 0; i < body.size(); i++) {
            body.get(i).setSubject(subject);
            if (i > body.size() / 3) subject = "Физика";
            if (i > body.size() * 2 / 3) subject = "Биология";
        }

        body.forEach(System.out::println);
        return body;
    }
}

package ru.digitalhack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalhack.model.Material;
import ru.digitalhack.service.MaterialService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping(value = "/materials")
    public List<Material> getMaterials(@RequestParam(required = false) String pageSize,
                                       @RequestParam(required = false) String page) {
        return materialService.getMaterialsWithSubject(pageSize, page);
    }
}

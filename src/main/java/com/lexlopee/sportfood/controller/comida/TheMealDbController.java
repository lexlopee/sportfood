package com.lexlopee.sportfood.controller.comida;

import com.lexlopee.sportfood.dto.comida.MealDTO;
import com.lexlopee.sportfood.service.comida.TheMealDbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/themealdb")
public class TheMealDbController {

    private final TheMealDbService theMealDbService;

    public TheMealDbController(TheMealDbService theMealDbService) {
        this.theMealDbService = theMealDbService;
    }

    @GetMapping("/search")
    public List<MealDTO> buscarNombre(@RequestParam String nombre) {
        return theMealDbService.buscarNombre(nombre);
    }

}

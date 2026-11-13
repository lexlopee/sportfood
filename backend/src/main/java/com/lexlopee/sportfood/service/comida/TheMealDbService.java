package com.lexlopee.sportfood.service.comida;

import com.lexlopee.sportfood.dto.comida.MealDTO;
import com.lexlopee.sportfood.dto.comida.MealResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TheMealDbService {

    private final RestClient theMealDbClient;

    // Spring inyecta el RestClient que configuraste en el @Bean
    public TheMealDbService(RestClient theMealDbClient) {
        this.theMealDbClient = theMealDbClient;
    }

    public List<MealDTO> buscarNombre(String nombre) {
        MealResponseDTO respuesta = theMealDbClient.get()
                .uri("/search.php?s={nombre}", nombre)
                .retrieve()
                .body(MealResponseDTO.class);
        return respuesta.getMeals();
    }
    public MealDTO buscarPorId (String idExterno){
        MealResponseDTO respuesta = theMealDbClient.get()
                .uri("/lookup.php?i={id}", idExterno)
                .retrieve()
                .body(MealResponseDTO.class);
        if (respuesta.getMeals() == null || respuesta.getMeals().isEmpty()){
            return null;
        }
        return respuesta.getMeals().get(0);
    }
}

package org.example.nycrestaurantexplorer.controllers.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.example.nycrestaurantexplorer.services.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@Tag(name = "Restaurants", description = "Endpoints for Restaurants.")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Operation(summary = "Buscar restaurantes por filtros",
            description = "Busca restaurantes com base nos filtros: cuisine, currentGrade, e borough.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurantes encontrados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping(value = "/search")
    public Page<Restaurants> getRestaurantsByFilters(
            @RequestParam @Parameter(description = "Tipo de cozinha") String cuisine,
            @RequestParam @Parameter(description = "Classificação atual do restaurante") String currentGrade,
            @RequestParam @Parameter(description = "Bairro onde o restaurante está localizado") String borough,
            @RequestParam @Parameter(description = "Número da página para paginar os resultados") int page,
            @RequestParam @Parameter(description = "Número de itens por página") int size
    ) {
        return restaurantService.getRestaurantsByFilters(cuisine, currentGrade, borough, page, size);
    }

    @Operation(summary = "Buscar restaurantes pelo nome",
            description = "Busca restaurantes com base em uma correspondência parcial do nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurantes encontrados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetro de nome inválido")
    })
    @GetMapping(value = "/search-by-name")
    public List<Restaurants> searchRestaurantsByName(
            @RequestParam @Parameter(description = "Nome do restaurante para busca parcial") String name) {
        return restaurantService.searchRestaurantsByName(name);
    }

    @Operation(summary = "Buscar todos os restaurantes",
            description = "Retorna todos os restaurantes cadastrados no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurantes encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar restaurantes")
    })
    @GetMapping(value = "/find-all")
    public List<Restaurants> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }
}
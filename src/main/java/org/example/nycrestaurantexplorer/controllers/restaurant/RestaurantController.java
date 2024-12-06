package org.example.nycrestaurantexplorer.controllers.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.nycrestaurantexplorer.dto.commands.PostRestaurantCommand;
import org.example.nycrestaurantexplorer.dto.commands.PutRestaurantCommand;
import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.example.nycrestaurantexplorer.services.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping()
    public Page<Restaurants> getRestaurantsByFilters(
            @RequestParam(required = false) @Parameter(description = "Tipo de cozinha") String grade,
            @RequestParam(required = false) @Parameter(description = "Bairro onde o restaurante está localizado") String borough,
            @RequestParam(defaultValue = "1") @Parameter(description = "Número da página para paginar os resultados") int page,
            @RequestParam(defaultValue = "20") @Parameter(description = "Número de itens por página") int size,
            @RequestParam(defaultValue = "name") @Parameter(description = "Campo para ordenação (name, grade, inspection_date)") String sortBy,
            @RequestParam(defaultValue = "asc") @Parameter(description = "Ordem da ordenação (asc ou desc)") String sortDirection
    ) {
        // Ajusta a paginação (page é base 0 no Spring Data)
        page = page > 0 ? page - 1 : 0;

        // Define a direção da ordenação
        Sort.Direction direction = "desc".equalsIgnoreCase(sortDirection) ? Sort.Direction.DESC : Sort.Direction.ASC;

        // Cria a configuração de paginação com ordenação
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return restaurantService.getRestaurantsByFilters(grade, borough, pageRequest);
    }


    @Operation(summary = "Buscar restaurantes pelo nome",
            description = "Busca restaurantes com base em uma correspondência parcial do nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurantes encontrados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetro de nome inválido")
    })
    @GetMapping(value = "/search")
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

    // CREATE - Add a new restaurant
    @PostMapping
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody @Valid PostRestaurantCommand postRestaurantCommand) {
        Restaurants createdRestaurant = restaurantService.createRestaurant(postRestaurantCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurants> updateRestaurant(
            @PathVariable Integer id,
            @RequestBody @Valid PutRestaurantCommand putRestaurantCommand) {
        Restaurants updatedRestaurant = restaurantService.updateRestaurant(id, putRestaurantCommand);
        return ResponseEntity.ok(updatedRestaurant);
    }

    // DELETE - Remove a restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurants> getRestaurantById(
            @PathVariable("id") Integer id) {
        Restaurants restaurant = restaurantService.findById(id);
        return ResponseEntity.ok(restaurant);
    }
}
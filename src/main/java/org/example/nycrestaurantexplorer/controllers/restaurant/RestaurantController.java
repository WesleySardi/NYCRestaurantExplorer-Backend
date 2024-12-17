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
@Tag(name = "Restaurants", description = "Endpoints for managing restaurants.")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    /**
     * Searches for restaurants based on various filters such as cuisine, grade, and borough.
     * Supports pagination and sorting.
     *
     * @param grade the grade of the restaurant
     * @param borough the borough where the restaurant is located
     * @param cuisineDescription the type of cuisine served by the restaurant
     * @param page the page number to paginate the results (default is 1)
     * @param size the number of items per page (default is 20)
     * @param sortBy the field to sort the results by (default is "name")
     * @param sortDirection the direction of the sort (either "asc" or "desc", default is "asc")
     * @return a page of restaurants matching the filters
     */
    @Operation(summary = "Search for restaurants by filters",
            description = "Searches for restaurants based on filters such as cuisine, grade, and borough.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurants found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    @GetMapping()
    public Page<Restaurants> getRestaurantsByFilters(
            @RequestParam(required = false) @Parameter(description = "The grade of the restaurant") String grade,
            @RequestParam(required = false) @Parameter(description = "The borough where the restaurant is located") String borough,
            @RequestParam(required = false) @Parameter(description = "The type of cuisine served by the restaurant") String cuisineDescription,
            @RequestParam(defaultValue = "1") @Parameter(description = "The page number for pagination") int page,
            @RequestParam(defaultValue = "20") @Parameter(description = "The number of items per page") int size,
            @RequestParam(defaultValue = "name") @Parameter(description = "The field by which to sort the results (name, grade, inspection_date)") String sortBy,
            @RequestParam(defaultValue = "asc") @Parameter(description = "The direction of the sort (asc or desc)") String sortDirection
    ) {
        page = page > 0 ? page - 1 : 0;

        Sort.Direction direction = "desc".equalsIgnoreCase(sortDirection) ? Sort.Direction.DESC : Sort.Direction.ASC;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return restaurantService.getRestaurantsByFilters(grade, borough, cuisineDescription, pageRequest);
    }

    /**
     * Searches for restaurants based on a partial name match, with support for pagination.
     *
     * @param name the name of the restaurant to search for
     * @param page the page number for pagination (default is 1)
     * @param size the number of items per page (default is 20)
     * @param sortBy the field to sort the results by (default is "name")
     * @param sortDirection the direction of the sort (either "asc" or "desc", default is "asc")
     * @return a page of restaurants whose names match the search query
     */
    @Operation(summary = "Search for restaurants by name",
            description = "Searches for restaurants based on a partial name match with pagination support.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurants found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid name parameter")
    })
    @GetMapping(value = "/search")
    public Page<Restaurants> searchRestaurantsByName(
            @RequestParam @Parameter(description = "Restaurant name for partial match search") String name,
            @RequestParam(defaultValue = "1") @Parameter(description = "The page number for pagination") int page,
            @RequestParam(defaultValue = "20") @Parameter(description = "The number of items per page") int size,
            @RequestParam(defaultValue = "name") @Parameter(description = "The field by which to sort the results (name, grade, inspection_date)") String sortBy,
            @RequestParam(defaultValue = "asc") @Parameter(description = "The direction of the sort (asc or desc)") String sortDirection
    ) {
        page = page > 0 ? page - 1 : 0;

        Sort.Direction direction = "desc".equalsIgnoreCase(sortDirection) ? Sort.Direction.DESC : Sort.Direction.ASC;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return restaurantService.searchRestaurantsByName(name, pageRequest);
    }

    /**
     * Returns a list of all restaurants in the system.
     *
     * @return a list of all registered restaurants
     */
    @Operation(summary = "Get all restaurants",
            description = "Returns all restaurants registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurants found successfully"),
            @ApiResponse(responseCode = "500", description = "Internal error while fetching restaurants")
    })
    @GetMapping(value = "/find-all")
    public List<Restaurants> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    /**
     * Creates a new restaurant.
     *
     * @param postRestaurantCommand the data required to create a restaurant
     * @return a ResponseEntity containing the created restaurant with HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody @Valid PostRestaurantCommand postRestaurantCommand) {
        Restaurants createdRestaurant = restaurantService.createRestaurant(postRestaurantCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    /**
     * Updates an existing restaurant.
     *
     * @param id the ID of the restaurant to be updated
     * @param putRestaurantCommand the updated data for the restaurant
     * @return a ResponseEntity containing the updated restaurant with HTTP status 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Restaurants> updateRestaurant(
            @PathVariable Integer id,
            @RequestBody @Valid PutRestaurantCommand putRestaurantCommand) {
        Restaurants updatedRestaurant = restaurantService.updateRestaurant(id, putRestaurantCommand);
        return ResponseEntity.ok(updatedRestaurant);
    }

    /**
     * Deletes a restaurant by its ID.
     *
     * @param id the ID of the restaurant to be deleted
     * @return a ResponseEntity with HTTP status 204 (No Content) if successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieves a restaurant by its ID.
     *
     * @param id the ID of the restaurant to retrieve
     * @return a ResponseEntity containing the restaurant with HTTP status 200 (OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurants> getRestaurantById(
            @PathVariable("id") Integer id) {
        Restaurants restaurant = restaurantService.findById(id);
        return ResponseEntity.ok(restaurant);
    }
}

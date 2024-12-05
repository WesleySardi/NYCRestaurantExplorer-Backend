package org.example.nycrestaurantexplorer.services.restaurant;

import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.example.nycrestaurantexplorer.repositories.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Page<Restaurants> getRestaurantsByFilters(String cuisine, String currentGrade, String borough, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return restaurantRepository.findByCuisineTypeAndCurrentGradeAndBorough(cuisine, currentGrade, borough, pageRequest);
    }

    public List<Restaurants> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContaining(name);
    }

    // Novo método para buscar todos os restaurantes
    public List<Restaurants> findAllRestaurants() {
        return restaurantRepository.findAll();
    }
}


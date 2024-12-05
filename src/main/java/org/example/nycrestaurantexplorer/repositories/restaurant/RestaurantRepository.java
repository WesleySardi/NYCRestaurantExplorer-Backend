package org.example.nycrestaurantexplorer.repositories.restaurant;

import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
    Page<Restaurants> findByCuisineTypeAndCurrentGradeAndBorough(
            String cuisine, String currentGrade, String borough, Pageable pageable
    );

    List<Restaurants> findByNameContaining(String name);
}


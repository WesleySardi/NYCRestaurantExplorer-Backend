package org.example.nycrestaurantexplorer.repositories.restaurant;

import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
    @Query("SELECT r FROM Restaurants r " +
            "JOIN r.inspections i " +
            "WHERE (:grade IS NULL OR i.grade LIKE %:grade%) " +
            "AND (:borough IS NULL OR r.borough LIKE %:borough%) " +
            "AND (:cuisineDescription IS NULL OR r.cuisineDescription LIKE %:cuisineDescription%)")
    Page<Restaurants> findByGradeAndBoroughAndCuisineDescription(
            @Param("grade") String grade,
            @Param("borough") String borough,
            @Param("cuisineDescription") String cuisineDescription,
            Pageable pageable);

    @Query("SELECT r FROM Restaurants r " +
            "LEFT JOIN r.inspections i " +
            "WHERE :grade IS NULL OR i.grade LIKE %:grade%")
    Page<Restaurants> findByGrade(
            @Param("grade") String grade,
            Pageable pageable);

    @Query("SELECT r FROM Restaurants r " +
            "WHERE :borough IS NULL OR r.borough LIKE %:borough%")
    Page<Restaurants> findByBorough(
            @Param("borough") String borough,
            Pageable pageable);

    @Query("SELECT r FROM Restaurants r " +
            "WHERE :cuisineDescription IS NULL OR r.cuisineDescription LIKE %:cuisineDescription%")
    Page<Restaurants> findByCuisineDescription(
            @Param("cuisineDescription") String cuisineDescription,
            Pageable pageable);

    @Query("SELECT r FROM Restaurants r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Restaurants> findByNameContainingIgnoreCase(
            @Param("name") String name,
            Pageable pageable);

    Optional<Restaurants> findById(Integer id);

    @Query("SELECT r FROM Restaurants r LEFT JOIN FETCH r.inspections WHERE r.camis = :id")
    Optional<Restaurants> findByIdWithInspections(Integer id);
}


package org.example.nycrestaurantexplorer.services.restaurant;

import org.example.nycrestaurantexplorer.dto.commands.PostRestaurantCommand;
import org.example.nycrestaurantexplorer.dto.commands.PutInspectionCommand;
import org.example.nycrestaurantexplorer.dto.commands.PutRestaurantCommand;
import org.example.nycrestaurantexplorer.entities.inspection.Inspections;
import org.example.nycrestaurantexplorer.entities.restaurant.Restaurants;
import org.example.nycrestaurantexplorer.exceptions.ResourceNotFoundException;
import org.example.nycrestaurantexplorer.repositories.inspections.InspectionsRepository;
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

    @Autowired
    private InspectionsRepository inspectionsRepository;

    public Page<Restaurants> getRestaurantsByFilters(String grade, String borough, String cuisineDescription, PageRequest pageRequest) {
        if (grade != null && borough != null && cuisineDescription != null) {
            return restaurantRepository.findByGradeAndBoroughAndCuisineDescription(grade, borough, cuisineDescription, pageRequest);
        } else if (cuisineDescription != null) {
            return restaurantRepository.findByCuisineDescription(cuisineDescription, pageRequest);
        }else if (grade != null) {
            return restaurantRepository.findByGrade(grade, pageRequest);
        } else if (borough != null) {
            return restaurantRepository.findByBorough(borough, pageRequest);
        } else {
            return restaurantRepository.findAll(pageRequest);
        }
    }

    public Page<Restaurants> searchRestaurantsByName(String name, PageRequest pageRequest) {
        return restaurantRepository.findByNameContainingIgnoreCase(name, pageRequest);
    }

    public List<Restaurants> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurants createRestaurant(PostRestaurantCommand restaurantCreateDTO) {
        Restaurants restaurant = new Restaurants();
        restaurant.setName(restaurantCreateDTO.getName());
        restaurant.setBorough(restaurantCreateDTO.getBorough());
        restaurant.setStreet(restaurantCreateDTO.getStreet());
        restaurant.setZipcode(restaurantCreateDTO.getZipcode());
        restaurant.setPhone(restaurantCreateDTO.getPhone());
        restaurant.setCuisineDescription(restaurantCreateDTO.getCuisineDescription());

        restaurant = restaurantRepository.save(restaurant);

        Inspections inspection = new Inspections();

        inspection.setInspectionDate(restaurantCreateDTO.getLastInspectionDate());
        inspection.setRecordDate(restaurantCreateDTO.getLastInspectionDate());
        inspection.setGrade(restaurantCreateDTO.getCurrentGrade());
        inspection.setCriticalFlag("Undefined Critical Flag");
        inspection.setRestaurant(restaurant);

        inspectionsRepository.save(inspection);

        return restaurant;
    }

    public Restaurants updateRestaurant(Integer id, PutRestaurantCommand restaurantCommand) {
        Restaurants existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));

        existingRestaurant.setName(restaurantCommand.getName());
        existingRestaurant.setBorough(restaurantCommand.getBorough());
        existingRestaurant.setStreet(restaurantCommand.getStreet());
        existingRestaurant.setZipcode(restaurantCommand.getZipcode());
        existingRestaurant.setPhone(restaurantCommand.getPhone());
        existingRestaurant.setCuisineDescription(restaurantCommand.getCuisineDescription());

        for (PutInspectionCommand inspectionCommand : restaurantCommand.getInspections()) {
            Inspections inspection;

            if (inspectionCommand.getId() != null) {
                inspection = inspectionsRepository.findById(inspectionCommand.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Inspection not found with ID: " + inspectionCommand.getId()));
            } else {
                inspection = new Inspections();
            }

            inspection.setInspectionDate(inspectionCommand.getInspectionDate());
            inspection.setRecordDate(inspectionCommand.getRecordDate());
            inspection.setGrade(inspectionCommand.getGrade());
            inspection.setCriticalFlag(inspectionCommand.getCriticalFlag());
            inspection.setRestaurant(existingRestaurant);

            inspectionsRepository.save(inspection);
        }

        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurant(Integer id) {
        Restaurants existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
        restaurantRepository.delete(existingRestaurant);
    }

    public Restaurants findById(Integer id) {
        return restaurantRepository.findByIdWithInspections(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
    }
}


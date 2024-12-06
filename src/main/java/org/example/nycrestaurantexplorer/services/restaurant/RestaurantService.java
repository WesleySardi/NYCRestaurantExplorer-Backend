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

    public Page<Restaurants> getRestaurantsByFilters(String grade, String borough, PageRequest pageRequest) {
        if (grade != null && borough != null) {
            return restaurantRepository.findByGradeAndBorough(grade, borough, pageRequest);
        } else if (grade != null) {
            return restaurantRepository.findByGrade(grade, pageRequest);
        } else if (borough != null) {
            return restaurantRepository.findByBorough(borough, pageRequest);
        } else {
            return restaurantRepository.findAll(pageRequest);
        }
    }

    public List<Restaurants> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContaining(name);
    }

    // Novo método para buscar todos os restaurantes
    public List<Restaurants> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurants createRestaurant(PostRestaurantCommand restaurantCreateDTO) {
        // Mapeamento do DTO para a entidade Restaurants
        Restaurants restaurant = new Restaurants();
        restaurant.setName(restaurantCreateDTO.getName());
        restaurant.setBorough(restaurantCreateDTO.getBorough());
        restaurant.setStreet(restaurantCreateDTO.getStreet());
        restaurant.setZipcode(restaurantCreateDTO.getZipcode());
        restaurant.setPhone(restaurantCreateDTO.getPhone());

        // Salvar a entidade mapeada no banco de dados
        return restaurantRepository.save(restaurant);
    }

    public Restaurants updateRestaurant(Integer id, PutRestaurantCommand restaurantCommand) {
        // Verificar se o restaurante existe
        Restaurants existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));

        // Atualizar informações básicas
        existingRestaurant.setName(restaurantCommand.getName());
        existingRestaurant.setBorough(restaurantCommand.getBorough());
        existingRestaurant.setStreet(restaurantCommand.getStreet());
        existingRestaurant.setZipcode(restaurantCommand.getZipcode());
        existingRestaurant.setPhone(restaurantCommand.getPhone());

        // Gerenciar inspeções
        for (PutInspectionCommand inspectionCommand : restaurantCommand.getInspections()) {
            Inspections inspection = new Inspections();
            inspection.setInspectionDate(inspectionCommand.getInspectionDate());
            inspection.setGrade(inspectionCommand.getGrade());
            inspection.setCriticalFlag(inspectionCommand.getCriticalFlag());
            inspection.setRestaurant(existingRestaurant);
            inspectionsRepository.save(inspection);
        }

        // Salvar alterações
        return restaurantRepository.save(existingRestaurant);
    }

    // DELETE - Remove a restaurant
    public void deleteRestaurant(Integer id) {
        Restaurants existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
        restaurantRepository.delete(existingRestaurant);
    }

    public Restaurants findById(Integer id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with ID: " + id));
    }
}


package org.example.nycrestaurantexplorer.services.instruction;

import org.example.nycrestaurantexplorer.entities.inspection.Inspections;
import org.example.nycrestaurantexplorer.exceptions.ResourceNotFoundException;
import org.example.nycrestaurantexplorer.repositories.inspections.InspectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionService {

    @Autowired
    private InspectionsRepository inspectionsRepository;

    public void deleteInspection(Integer id) {
        Inspections existingInspection = inspectionsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspection not found with ID: " + id));
        inspectionsRepository.delete(existingInspection);
    }
}


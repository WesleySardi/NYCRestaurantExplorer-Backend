package org.example.nycrestaurantexplorer.controllers.instruction;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.nycrestaurantexplorer.services.instruction.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inspections")
@Tag(name = "Inspections", description = "Endpoints for Inspections.")
public class InspectionController {

    @Autowired
    private InspectionService instructionService;

    // DELETE - Remove a restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInspection(@PathVariable Integer id) {
        instructionService.deleteInspection(id);
        return ResponseEntity.noContent().build();
    }
}

package org.example.nycrestaurantexplorer.controllers.instruction;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@Tag(name = "Inspections", description = "Endpoints for managing inspections.")
public class InspectionController {

    @Autowired
    private InspectionService instructionService;

    /**
     * Deletes an inspection by its ID.
     *
     * @param id the ID of the inspection to be deleted
     * @return a ResponseEntity with a 204 No Content status if the deletion is successful
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an inspection",
            description = "Deletes the inspection with the given ID. If the inspection is successfully deleted, a 204 No Content response will be returned.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Inspection successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Inspection not found")
            }
    )
    public ResponseEntity<Void> deleteInspection(
            @Parameter(description = "ID of the inspection to be deleted") @PathVariable Integer id
    ) {
        instructionService.deleteInspection(id);
        return ResponseEntity.noContent().build();
    }
}

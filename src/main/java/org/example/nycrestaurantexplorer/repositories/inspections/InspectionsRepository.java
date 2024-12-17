package org.example.nycrestaurantexplorer.repositories.inspections;

import org.example.nycrestaurantexplorer.entities.inspection.Inspections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InspectionsRepository extends JpaRepository<Inspections, Integer> {
    Optional<Inspections> findById(Integer id);
}


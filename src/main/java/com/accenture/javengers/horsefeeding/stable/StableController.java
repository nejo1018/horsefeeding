package com.accenture.javengers.horsefeeding.stable;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StableController {

    @Autowired
    private StableService stableService;

    @Autowired
    private StableMapper stableMapper;

    @GetMapping("/stables")
    public ResponseEntity<List<StableDto>> readStables() {
        List<StableDto> stableDtos = stableService.readStable();
        return ResponseEntity.ok(stableDtos);
    }

    @PostMapping("/stables/add")
    public ResponseEntity<Stable> createStable(@RequestBody Stable stable) {
        Stable createdStable = stableService.createStable(stable);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStable);
    }

    @DeleteMapping("stables/delete/{id}")
    public ResponseEntity<String> deleteStable(@PathVariable Integer id) {
        try {
            stableService.deleteStableById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Stable mit ID " + id + " wurde gelöscht.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("stables/update/{id}")
    public ResponseEntity<Stable> updateStable(@PathVariable Integer id, @RequestBody Stable stableDetails) {
        try {
            Stable updatedStable = stableService.updateStable(id, stableDetails);
            return ResponseEntity.ok(updatedStable);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

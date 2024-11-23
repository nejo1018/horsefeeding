package com.accenture.javengers.horsefeeding.stable;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

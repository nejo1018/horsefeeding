package com.accenture.javengers.horsefeeding.owner;

import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class OwnerController {

    @Autowired
    private OwnerService ownerservice;

    @Autowired
    private OwnerMapper ownermapper;

    @GetMapping("/owner")
    public ResponseEntity<List<OwnerDto>> readOwner() {
        List<OwnerDto> ownerDtos = ownerservice.readOwner();
        return ResponseEntity.ok(ownerDtos);
    }
}

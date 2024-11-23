package com.accenture.javengers.horsefeeding.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horses")
public class HorseController {

    @Autowired
    private HorseService horseService;

    @Autowired
    private HorseMapper horseMapper;

    @GetMapping("/allhorses")
    public ResponseEntity<List<HorseDto>> readHorse() {
        List<HorseDto> horseDtos = horseService.readHorse();
        return ResponseEntity.ok(horseDtos);
    }

    @PostMapping
    public ResponseEntity<HorseDto> createHorse(@RequestBody HorseDto horseDto) {
        HorseDto createdHorse = horseService.createHorse(horseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorse);
    }
}

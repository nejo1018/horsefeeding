package com.accenture.javengers.horsefeeding.test;


import com.accenture.javengers.horsefeeding.horse.HorseController;
import com.accenture.javengers.horsefeeding.horse.HorseDto;
import com.accenture.javengers.horsefeeding.horse.HorseMapper;
import com.accenture.javengers.horsefeeding.horse.HorseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HorseController.class)
class HorseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HorseService horseService;

    @MockBean
    private HorseMapper horseMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllHorses() throws Exception {
        HorseDto horse1 = new HorseDto();
        horse1.setId(1);
        horse1.setGuid("GUID1");
        horse1.setHorseName("Horse1");
        horse1.setHorseNickname("Nick1");
        horse1.setBreed("Breed1");
        horse1.setOwner_id(1);
        horse1.setStable_id(1);
        horse1.setMealplan_id(1);

        HorseDto horse2 = new HorseDto();
        horse2.setId(2);
        horse2.setGuid("GUID2");
        horse2.setHorseName("Horse2");
        horse2.setHorseNickname("Nick2");
        horse2.setBreed("Breed2");
        horse2.setOwner_id(2);
        horse2.setStable_id(2);
        horse2.setMealplan_id(2);


        List<HorseDto> mockHorses = Arrays.asList(horse1, horse2);
        when(horseService.readHorse()).thenReturn(mockHorses);

        // HTTP-GET-Request simulieren
        mockMvc.perform(get("/horses/allhorses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2)) // Überprüft, ob die Liste 2 Elemente hat
                .andExpect(jsonPath("$[0].horseName").value("Horse1")) // Überprüft den ersten Eintrag
                .andExpect(jsonPath("$[1].horseName").value("Horse2")); // Überprüft den zweiten Eintrag

        // Überprüfen, ob der Service genau einmal aufgerufen wurde
        verify(horseService, times(1)).readHorse();
    }
}
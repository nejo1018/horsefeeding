package com.accenture.javengers.horsefeeding.stable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StableService {

    @Autowired
    private StableRepository stableRepository;

    @Autowired
    private StableMapper stableMapper;

    public List<StableDto> readStable(){

        List<Stable> all = stableRepository.findAll();
        return stableMapper.toDtos(all);
    }
}

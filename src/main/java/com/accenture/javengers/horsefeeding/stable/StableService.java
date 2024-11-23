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

    public Stable createStable(Stable stable) {
        return stableRepository.save(stable);
    }

    public void deleteStableById(Integer id) {
        if (!stableRepository.existsById(id)) {
            throw new IllegalArgumentException("Stable mit ID " + id + " existiert nicht.");
        }
        stableRepository.deleteById(id);
    }

    public Stable updateStable(Integer id, Stable stableDetails) {
        Stable stable = stableRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stable mit ID " + id + " existiert nicht."));
        stable.setStableName(stableDetails.getStableName());
        return stableRepository.save(stable);
    }


}

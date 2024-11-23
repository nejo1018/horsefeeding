package com.accenture.javengers.horsefeeding.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    public List<OwnerDto> readOwner() {

        List<Owner> all = ownerRepository.findAll();
        return ownerMapper.toDtos(all);
    }
}

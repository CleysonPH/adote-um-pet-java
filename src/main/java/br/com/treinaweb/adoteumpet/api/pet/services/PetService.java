package br.com.treinaweb.adoteumpet.api.pet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@Service
public class PetService {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    public PetService(PetMapper petMapper, PetRepository petRepository) {
        this.petMapper = petMapper;
        this.petRepository = petRepository;
    }

    public PetResponse create(PetRequest petRequest) {
        var petToCreate = petMapper.toModel(petRequest);
        var createdPet = petRepository.save(petToCreate);
        return petMapper.toResponse(createdPet);
    }

    public List<PetResponse> findAll() {
        return petRepository.findAll()
            .stream()
            .map(petMapper::toResponse)
            .toList();
    }

}

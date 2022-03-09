package br.com.treinaweb.adoteumpet.api.adocao.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.models.Adocao;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@Component
public class AdocaoMapper {

    private final PetMapper petMapper;
    private final PetRepository petRepository;

    public AdocaoMapper(PetMapper petMapper, PetRepository petRepository) {
        this.petMapper = petMapper;
        this.petRepository = petRepository;
    }

    public Adocao toModel(AdocaoRequest adocaoRequest) {
        return Adocao.builder()
            .valor(adocaoRequest.getValor())
            .email(adocaoRequest.getEmail())
            .pet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()))
            .build();
    }

    public AdocaoResponse toResponse(Adocao adocao) {
        return AdocaoResponse.builder()
            .id(adocao.getId())
            .email(adocao.getEmail())
            .valor(adocao.getValor())
            .pet(petMapper.toResponse(adocao.getPet()))
            .build();
    }

}

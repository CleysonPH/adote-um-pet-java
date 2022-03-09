package br.com.treinaweb.adoteumpet.api.adocao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.adocao.mappers.AdocaoMapper;
import br.com.treinaweb.adoteumpet.core.repositories.AdocaoRepository;

@Service
public class AdocaoService {

    private final AdocaoMapper adocaoMapper;
    private final AdocaoRepository adocaoRepository;

    public AdocaoService(AdocaoMapper adocaoMapper, AdocaoRepository adocaoRepository) {
        this.adocaoMapper = adocaoMapper;
        this.adocaoRepository = adocaoRepository;
    }

    public AdocaoResponse create(AdocaoRequest adocaoRequest) {
        var adocaoToCreate = adocaoMapper.toModel(adocaoRequest);
        var createdAdocao = adocaoRepository.save(adocaoToCreate);
        return adocaoMapper.toResponse(createdAdocao);
    }

    public List<AdocaoResponse> findAll() {
        return adocaoRepository.findAll()
            .stream()
            .map(adocaoMapper::toResponse)
            .toList();
    }

}

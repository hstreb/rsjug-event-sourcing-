package org.exemplo.seguros.apolice;

import org.springframework.stereotype.Service;

@Service
public class ApoliceService {

    private ApoliceRepository apoliceRepository;

    public ApoliceService(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    public Apolice salvar(Apolice apolice) {
        return apoliceRepository.save(apolice);
    }

    public Apolice buscar(Long id) {
        return apoliceRepository.findById(id)
                .orElseThrow(() -> new ApoliceNotFoundException("Apolice '" + id + "' não encontrada!"));
    }

    public Apolice adicionarDependente(Long id, Dependente dependente) {
        final Apolice apolice = buscar(id);
        apolice.addDepenente(dependente);
        return apoliceRepository.save(apolice);
    }
}

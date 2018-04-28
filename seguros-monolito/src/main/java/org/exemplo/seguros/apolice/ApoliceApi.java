package org.exemplo.seguros.apolice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apolices")
public class ApoliceApi {
    private ApoliceService apoliceService;

    public ApoliceApi(ApoliceService apoliceService) {
        this.apoliceService = apoliceService;
    }

    @PostMapping
    public Apolice salvar(@RequestBody Apolice apolice) {
        return apoliceService.salvar(apolice);
    }

    @GetMapping
    public List<Apolice> listar() {
        return apoliceService.listar();
    }

    @GetMapping("/{id}")
    public Apolice buscar(@PathVariable("id") Long id) {
        return apoliceService.buscar(id);
    }

    @PostMapping("/{id}/dependentes")
    public Apolice adicionarDependente(@PathVariable("id") Long id, @RequestBody Dependente dependente) {
        return apoliceService.adicionarDependente(id, dependente);
    }

}

package org.exemplo.seguros.apolice.dominio.dominio;

import org.exemplo.seguros.apolice.dominio.dominio.evento.DependenteAdicionado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apolice {
    private Long numero;
    private String cpf;
    private String nome;
    private String bem;
    private String seguradora;
    private List<Dependente> dependentes;

    public Apolice(Long numero, String cpf, String nome, String bem, String seguradora, List<Dependente> dependentes) {
        this.numero = numero;
        this.cpf = cpf;
        this.nome = nome;
        this.bem = bem;
        this.seguradora = seguradora;
        this.dependentes = dependentes == null ? Collections.emptyList() : dependentes;
    }

    public void adicionar(DependenteAdicionado adicionado) {
        this.dependentes = new ArrayList<Dependente>(dependentes) {{
            add(new Dependente(adicionado.getCpf(), adicionado.getNome(), adicionado.getIdade()));
        }};
    }

    public Long getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getBem() {
        return bem;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public List<Dependente> getDependentes() {
        return Collections.unmodifiableList(dependentes);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.programe.manager;

import io.programe.enums.Sexo;
import io.programe.modelo.Especialidade;
import io.programe.servico.EspecialidadeServico;
import io.programe.utilitario.Mensagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author elybezerra
 */
@ManagedBean
@ViewScoped
public class EspecialidadeManagerBean implements Serializable {

    private Especialidade especialidade;
    private List<Especialidade> especialidades;

    @EJB
    EspecialidadeServico especialidadeServico;

    @PostConstruct
    public void iniciar() {
        this.especialidade = new Especialidade();
        this.especialidades = new ArrayList<>();
    }

  
    public void salvar() {
        especialidadeServico.salvar(especialidade);
        Mensagem.mensagemInformacao("Salvo", "Com sucesso");
        iniciar();
    }

    public void adicionarEspecialidade() {
        this.especialidades.add(this.especialidade);
        this.especialidade = new Especialidade();
    }

    public void removerEspecialidade(Especialidade item) {
        this.especialidades.remove(item);
    }

    public List<SelectItem> getSexo() {
        // CRIAÇÃO DE SELECT DE ITENS
        List<SelectItem> items = new ArrayList<>();

        // PERCORRENDO O ENUM DE SEXO
        for (Sexo item : Sexo.values()) {

            // ADCIONA NA LISTA DE SELECT ITENS        
            items.add(new SelectItem(item, item.name()));
        }

        return items;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

}

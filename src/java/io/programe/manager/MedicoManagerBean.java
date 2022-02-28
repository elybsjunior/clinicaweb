/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.programe.manager;

import io.programe.enums.Sexo;
import io.programe.modelo.Medico;
import io.programe.utilitario.Mensagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author elybezerra
 */
@ManagedBean
@ViewScoped
public class MedicoManagerBean implements Serializable{
    
    // ATRIBUTOS
    private Medico medico;
    private List<Medico> medicos;
    
    
    @PostConstruct
    public void iniciar(){
        this.medico = new Medico();
        this.medicos = new ArrayList<>();
        
    }

    public void imprimir(){
        
       Mensagem.mensagemInformacao(medico.getNome(),medico.getContato());
    }
    
    public void adicionarMedico(){
        this.medicos.add(this.medico);
        imprimir();
        this.medico = new Medico();
        
        
    }
    
    public List<SelectItem> itens() {
        // CRIAÇÃO DE SELECT DE ITENS
        List<SelectItem> items = new ArrayList<>();
        
        // PERCORRENDO O ENUM DE SEXO
        for (Sexo item : Sexo.values()) {
            
            // ADCIONA NA LISTA DE SELECT ITENS        
            items.add(new SelectItem(item, item.name()));
        }
        
        return items;
    }
    
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    
    
    
    
     
    
    
    
}

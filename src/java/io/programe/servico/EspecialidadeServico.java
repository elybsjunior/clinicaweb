/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.programe.servico;

import io.programe.modelo.Especialidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elybezerra
 */
@Stateless
public class EspecialidadeServico {
   
    @PersistenceContext
    EntityManager em;
    
    
    public void salvar(Especialidade especialidade){
        em.persist(especialidade);
    }
    
    public void atualizar(Especialidade especialidade){
         em.merge(especialidade);
         em.flush();
    }
    
    public Especialidade find(Long id){
        return em.find(Especialidade.class, id);
    }
    
    // CONSULTAS 
    public List<Especialidade> todasEspecialidades(){
        return null;
    }
    
}

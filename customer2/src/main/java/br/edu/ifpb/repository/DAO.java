package br.edu.ifpb.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAO {

    private EntityManager em;


    public DAO(){
        this.em = Persistence
                .createEntityManagerFactory("Projeto")
                .createEntityManager();
    }

    public void salvar(Object obj){
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}

package br.com.julianfernando.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Interface genérica que deverá ser implementada por todas as classes que forem acessar banco de dados
 * @author julian
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    
    void update(T entity);
    
    void remove(T entity);
    
    void merge(T entity);
    
    // recupera um objeto conforme o id passado
    T getEntity(Serializable id);
    
    // 
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    
    // recupera todas as entidades
    List<T> getEntities();
    
    // 
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    
}

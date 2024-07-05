package org.example.employer.ressource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;

import java.util.List;

public interface BasesRessources<T> {
    public T finfById(@PathParam("id") Long id);
    public List<T> findAll();
    public T create(T entity);

    public T update(@PathParam("id") Long id , T entity);

    public Boolean delete(@PathParam("id") Long id);


}

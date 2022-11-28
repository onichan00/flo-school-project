package com.hva.helios.repositories;

import java.util.List;

public interface EntityRepository<E> {
    List<E> findAll();

    E findById(long id);

    E save(E entity);

    E deleteById(long id);
}

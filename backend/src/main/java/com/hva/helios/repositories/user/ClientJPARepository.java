package com.hva.helios.repositories.user;

import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientJPARepository
        implements EntityRepository<Client> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> query =
                entityManager.createQuery("SELECT client from Client client", Client.class);

        return query.getResultList();
    }

    @Override
    public Client findById(long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public Client save(Client entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Client deleteById(long id) {
        Client client = findById(id);
        entityManager.remove(client);
        return client;
    }
}

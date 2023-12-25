package org.design.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.design.entity.ExceptionEntity;

@ApplicationScoped
public class ExceptionRepository implements PanacheRepository<ExceptionEntity> {

    @Transactional
    public void saveException(ExceptionEntity entity) {
        persist(entity);
    }
}

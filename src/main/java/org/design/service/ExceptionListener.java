package org.design.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.design.entity.ExceptionEntity;
import org.design.repository.ExceptionRepository;

@ApplicationScoped
public class ExceptionListener {

    @Inject
    ExceptionRepository repository;

    public void exceptionConsumer(@Observes ExceptionEntity exceptionEntity) {
        repository.saveException(exceptionEntity);
    }
}

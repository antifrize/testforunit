package ru.vmakarenko.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import ru.vmakarenko.entities.Test;
import ru.vmakarenko.services.TestService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.InvalidParameterException;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
@Local(TestService.class)
@Named
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @PersistenceContext
    EntityManager em;

    @Override
    public Test getById(Long id) {
        return em.getReference(Test.class, id);
    }


    @Override
    public Test update(Test test) {
        if (test.getId() != null) {
            Test managedTest = em.getReference(Test.class, test.getId());
            BeanUtils.copyProperties(test, managedTest, "user","version");
            test = em.merge(managedTest);
        } else {
            throw new InvalidParameterException("Cannot update Test with nulled id!");
        }
        return test;
    }

    @Override
    public Test create(Test test) {
        em.persist(test);
        return test;
    }

    @Override
    public void delete(Long id) {
        em.remove(em.getReference(Test.class, id));
    }
}

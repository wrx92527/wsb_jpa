package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class PatientVersioningTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Test
    public void testOptimisticLocking() {
        EntityManager em1 = entityManagerFactory.createEntityManager();
        em1
            .getTransaction()
            .begin();
        PatientEntity patient1 = em1.find(PatientEntity.class, 1L);
        patient1.setFirstName("Updated Name 1");
        em1
            .getTransaction()
            .commit();
        em1.close();

        EntityManager em2 = entityManagerFactory.createEntityManager();
        em2
            .getTransaction()
            .begin();
        PatientEntity patient2 = em2.find(PatientEntity.class, 1L);

        EntityManager em3 = entityManagerFactory.createEntityManager();
        em3
            .getTransaction()
            .begin();
        PatientEntity patient3 = em3.find(PatientEntity.class, 1L);
        patient3.setLastName("New Last Name");
        em3
            .getTransaction()
            .commit();
        em3.close();

        patient2.setFirstName("Updated Name 2");

        assertThatThrownBy(em2.getTransaction()::commit)
            .isInstanceOf(RollbackException.class)
            .hasCauseInstanceOf(OptimisticLockException.class)
        ;

        em2.close();
    }
}

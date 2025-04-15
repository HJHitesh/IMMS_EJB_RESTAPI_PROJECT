package com.imms.ejb;

import java.util.List;

import com.imms.model.MaintenanceTask;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class MaintenanceServiceBean {
    @PersistenceContext private EntityManager em;

    public void createTask(MaintenanceTask task) { em.persist(task); }

    public List<MaintenanceTask> getTasksByTechnician(Long techId) {
        return em.createQuery("SELECT t FROM MaintenanceTask t WHERE t.assignedTechnician.id = :techId", MaintenanceTask.class)
                 .setParameter("techId", techId).getResultList();
    }
}

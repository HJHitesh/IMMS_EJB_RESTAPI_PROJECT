package com.imms.ejb;

import com.imms.model.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserServiceBean {
    @PersistenceContext private EntityManager em;

    public User authenticate(String username, String password) {
        try {
            User user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                          .setParameter("username", username)
                          .getSingleResult();
            return user.getPasswordHash().equals(Integer.toHexString(password.hashCode())) ? user : null;
        } catch (NoResultException e) {
            return null;
        }
    }
}

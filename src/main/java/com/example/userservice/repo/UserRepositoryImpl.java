package com.example.userservice.repo;


import com.example.userservice.model.User;
import com.example.userservice.util.DataUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepoCustom {
    @PersistenceContext(name = "bccsfood")
    private EntityManager em;


    @Override
    public List<User> listAllUserByStatus(String status) {
        StringBuilder sql = new StringBuilder(" ");
        sql.append("select * from bccsfood.users where 1=1 ");

        if (!DataUtil.isNullOrEmpty(status)) {
            sql.append(" and status =:status");
        }

        Query query = em.createNativeQuery(sql.toString(), User.class);

        if (!DataUtil.isNullOrEmpty(status)) {
            query.setParameter("status", status);
        }

        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public User findByUserId(Long id) {
        StringBuilder sql = new StringBuilder(" ");
        sql.append("select * from bccsfood.users where 1=1 and user_id =:id");
        Query query = em.createNativeQuery(sql.toString(), User.class);
        query.setParameter("id", id);
        List<User> result = query.getResultList();
        if (result.size()==0) {
            return null;
        }
        return result.get(0);
    }

}

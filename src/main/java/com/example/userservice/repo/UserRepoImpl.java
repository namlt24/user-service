package com.example.userservice.repo;


import com.example.userservice.model.User;
import com.example.userservice.util.DataUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class UserRepoImpl implements UserRepoCustom {
    @PersistenceContext(name = "bccsfood")
    private EntityManager em;


    @Override
    public List<User> listAllUserByStatus(String status) {
        StringBuilder sql = new StringBuilder(" ");
        sql.append("select * from bccsfood.users where status =:status");
        Query query = em.createNativeQuery(sql.toString(),User.class);
        if (!DataUtil.isNullOrEmpty(status)){
            query.setParameter("status", "1");
        }else{
            query.setParameter("status", status);
        }
        List<User> result = query.getResultList();
        return result;
    }
}

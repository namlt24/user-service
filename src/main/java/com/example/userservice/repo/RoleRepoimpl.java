package com.example.userservice.repo;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleRepoimpl implements RoleRepository{
    @PersistenceContext(name = "bccsfood")

    @Autowired
    private EntityManager em;

    @Override
    public List<Role> findListRoleByUserId(Long userId) {
        StringBuilder sql = new StringBuilder(" ");
        sql.append("select r.* from bccsfood.roles r, bccsfood.map_user_role m where r.role_id = m.role_id and m.user_id =:userId");
        Query query = em.createNativeQuery(sql.toString(),Role.class);
        query.setParameter("userId",userId);
        return query.getResultList();
    }

}

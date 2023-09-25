package com.example.userservice.repo;

import com.example.userservice.model.MapUserRole;
import com.example.userservice.model.User;
import com.example.userservice.util.DataUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapUserRoleRepoImpl implements MapUserRoleRepoCustom {
    @Autowired
    private EntityManager em;

    @Override
    public List<MapUserRole> getListRolesByUserId(Long id) {
        StringBuilder sql = new StringBuilder(" ");
        sql.append("select * from bccsfood.map_user_role where user_id =:id and status =1");
        Query query = em.createNativeQuery(sql.toString(), MapUserRole.class);
        query.setParameter("id", id);
        List<MapUserRole> result = query.getResultList();
        return result;
    }
}

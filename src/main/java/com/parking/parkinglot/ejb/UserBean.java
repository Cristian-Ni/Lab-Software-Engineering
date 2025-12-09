package com.parking.parkinglot.ejb;
import com.parking.parkinglot.common.UserDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Stateless
public class UserBean
{
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        try{
            TypedQuery<Users> typedQuery = entityManager.createQuery("SELECT u from Users u", Users.class);
            List<Users> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<Users> users) {
        List<UserDto> dtos = new ArrayList<>();

        for (Users user : users) {
            UserDto dto = new UserDto(user.getUsername(), user.getId(), user.getEmail());
            dtos.add(dto);
        }
        return dtos;
    }
}
package it.eforhum.users.dao;

import org.springframework.data.repository.CrudRepository;
import it.eforhum.users.entity.User;
public interface UserDao extends CrudRepository<User, Integer> {
}

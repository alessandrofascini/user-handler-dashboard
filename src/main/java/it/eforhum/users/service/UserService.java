package it.eforhum.users.service;

import it.eforhum.users.dao.UserDao;
import it.eforhum.users.entity.User;
import it.eforhum.users.exception.UnimplementedMethodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudRepository<User, Integer> {
    @Autowired
    private UserDao dao;

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return this.dao.saveAll(entities);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return this.dao.findById(id);
    }

    public User findById(int id) {
        return this.findById(Integer.valueOf(id)).orElseThrow(() -> new EntityNotFoundException("There's no user with id = " + id));
    }

    @Override
    public boolean existsById(Integer id) {
        return this.findById(id).isPresent();
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        this.dao.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Integer> integers) {
        throw new UnimplementedMethodException("service/User - findAllById not implemented");
    }

    @Override
    public long count() {
        throw new UnimplementedMethodException("service/User - count not implemented");
    }

    @Override
    public void deleteById(Integer id) {
        this.dao.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        this.dao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        throw new UnimplementedMethodException("service/User - deleteAllById not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        throw new UnimplementedMethodException("service/User - deleteAllById not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnimplementedMethodException("service/User - deleteAll not implemented");
    }

    @Override
    public User save(User user) {
        return this.dao.save(user);
    }

    public User update(User user) {
        return this.save(user);
    }
}

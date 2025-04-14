package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user); // may already act as save
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);

    // ➕ Add these
    Optional<User> findByUsername(String username);
    void save(User user);
}

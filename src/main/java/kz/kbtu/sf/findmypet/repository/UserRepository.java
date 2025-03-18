package kz.kbtu.sf.findmypet.repository;

import kz.kbtu.sf.findmypet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

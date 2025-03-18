package kz.kbtu.sf.findmypet.repository;

import kz.kbtu.sf.findmypet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByName(String petName);
}
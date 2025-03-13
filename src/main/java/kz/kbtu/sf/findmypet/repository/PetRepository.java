package kz.kbtu.sf.findmypet.repository;

import kz.kbtu.sf.findmypet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
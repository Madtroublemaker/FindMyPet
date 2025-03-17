package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PetService {
    List<Pet> getAllPets();
    Optional<Pet> getPetById(Long id);
    Pet createPet(Pet pet);
    Pet updatePet(Long id, Pet updatedPet);
    void deletePet(Long id);
}
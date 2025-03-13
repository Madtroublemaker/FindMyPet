package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {
    Pet savePet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(Long id);
    Pet updatePet(Long id, Pet pet);
    void deletePet(Long id);
}

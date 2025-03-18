package kz.kbtu.sf.findmypet.serviceImpl;

import kz.kbtu.sf.findmypet.model.Pet;
import kz.kbtu.sf.findmypet.repository.PetRepository;
import kz.kbtu.sf.findmypet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet updatePet(Long id, Pet updatedPet) {
        return petRepository.findById(id).map(pet -> {
            pet.setName(updatedPet.getName());
            pet.setType(updatedPet.getType());
            pet.setBreed(updatedPet.getBreed());
            pet.setAge(updatedPet.getAge());
            pet.setStatus(updatedPet.getStatus());
            pet.setPhoto(updatedPet.getPhoto());
            return petRepository.save(pet);
        }).orElse(null);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}

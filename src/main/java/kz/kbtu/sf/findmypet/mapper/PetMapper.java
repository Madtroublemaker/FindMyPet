package kz.kbtu.sf.findmypet.mapper;

import kz.kbtu.sf.findmypet.dto.PetDto;
import kz.kbtu.sf.findmypet.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    Pet toEntity(PetDto petInputDTO);
    PetDto toDTO(Pet pet);
}

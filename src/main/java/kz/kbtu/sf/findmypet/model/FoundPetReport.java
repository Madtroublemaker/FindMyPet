package kz.kbtu.sf.findmypet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "found_pet_reports")
public class FoundPetReport extends PetReport {

    private boolean isReunited;

    @Column(name = "found_date")
    private LocalDateTime foundDate;

    private String caretakerContact;
}


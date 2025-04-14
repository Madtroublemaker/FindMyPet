package kz.kbtu.sf.findmypet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lost_pet_reports")
public class LostPetReport extends PetReport {

    private BigDecimal reward;

    @Column(name = "last_seen_date")
    private LocalDateTime lastSeenDate;

    private boolean isStillMissing;

    private String caretakerContact;
}

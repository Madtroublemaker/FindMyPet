package kz.kbtu.sf.findmypet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String breed;
    private String lastSeenLocation;
    private LocalDateTime lastSeenTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getLastSeenLocation() {
        return lastSeenLocation;
    }
    public void setLastSeenLocation(String lastSeenLocation) {
        this.lastSeenLocation = lastSeenLocation;
    }
    public LocalDateTime getLastSeenTime() {
        return lastSeenTime;
    }
    public void setLastSeenTime(LocalDateTime lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

}


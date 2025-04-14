package kz.kbtu.sf.findmypet.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenUser {
    private Long id;
    private String username;
    private String role;  // Ensure this is properly populated with the correct role

    public TokenUser(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
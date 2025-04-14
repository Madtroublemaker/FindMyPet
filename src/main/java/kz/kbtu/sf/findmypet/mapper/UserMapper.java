package kz.kbtu.sf.findmypet.mapper;


import kz.kbtu.sf.findmypet.dto.TokenUser;
import kz.kbtu.sf.findmypet.model.User;
import kz.kbtu.sf.findmypet.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public TokenUser tokenUserFromUser(User user) {
        return TokenUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    public User fromRegisterRequest(RegisterRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(request.getPassword()) // Password should be encoded before saving!
                .build();
    }
}
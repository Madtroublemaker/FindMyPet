package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.dto.TokenUser;
import kz.kbtu.sf.findmypet.model.Role;
import kz.kbtu.sf.findmypet.mapper.UserMapper;
import kz.kbtu.sf.findmypet.model.User;
import kz.kbtu.sf.findmypet.request.LoginRequest;
import kz.kbtu.sf.findmypet.request.RegisterRequest;
import kz.kbtu.sf.findmypet.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final TokenService tokenService;
    private final EncoderService encoderService;
    private final UserMapper userMapper;

    public AuthResponse login(LoginRequest request) {
        User user = findByUsername(request.getUsername().toLowerCase())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!encoderService.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        TokenUser tokenUser = userMapper.tokenUserFromUser(user);
        String token = tokenService.generateToken(tokenUser);
        return tokenService.authResponseFromToken(token);
    }

    public void register(RegisterRequest request) {
        findByUsername(request.getUsername().toLowerCase()).ifPresent((e) -> {
            throw new RuntimeException("User with this username already exists!");
        });

        User user = userMapper.fromRegisterRequest(request);
        user.setPassword(encoderService.encode(request.getPassword()));
        user.setUsername(request.getUsername().toLowerCase());
        user.setRole(Role.USER);

        userService.save(user);
    }

    private Optional<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }
}

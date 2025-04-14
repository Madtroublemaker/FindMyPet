package kz.kbtu.sf.findmypet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.kbtu.sf.findmypet.dto.TokenUser;
import kz.kbtu.sf.findmypet.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;



@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class); // Logger initialization

    private static final String TOKEN_PREFIX = "Bearer ";
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        logger.info("Request Path: " + path);

        // Skip filtering for authentication endpoints
        if (path.startsWith("/auth/login") || path.startsWith("/auth/register")) {
            logger.info("Skipping token authentication for path: " + path);
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        logger.info("Authorization Header: " + header);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            logger.warn("Token is missing or incorrect");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = header.substring(TOKEN_PREFIX.length());
        logger.info("Token extracted: " + token);

        TokenUser user = tokenService.verifyToken(token);
        if (user == null) {
            logger.warn("Invalid token");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Set Spring Security context
        logger.info("Token is valid, setting security context for user: " + user.getUsername());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        Collections.emptyList() // ✅ no authorities
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
package com.openclassrooms.mddapi.security;


import com.openclassrooms.mddapi.models.UserPrincipal;
import com.openclassrooms.mddapi.services.impl.JwtServiceImpl;

import com.openclassrooms.mddapi.services.impl.UserService;
import com.openclassrooms.mddapi.services.interfaces.IUserDetailsService;
import com.openclassrooms.mddapi.services.interfaces.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtServiceImpl jwtServiceImpl;
    private final ApplicationContext context;
    private final JwtUtils jwtUtils;

    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/api/auth/login") || path.equals("/api/auth/register")) {
            logger.debug("Filter : register called");
            filterChain.doFilter(request, response);
            return;  // Continuer la chaîne sans vérification JWT pour ces routes
        }
        String token = jwtUtils.extractTokenFromRequest(request);
        String email = null;
        logger.debug("token: " + token);
        if (token!=null && !token.isEmpty()){
            email = jwtServiceImpl.extractEmail(token);
        }
        logger.debug("email: " + email);

        if (hasToBoAuthenticated(email)) {
            logger.debug("check authentication: " + email);
            UserPrincipal userPrincipal = (UserPrincipal) context.
                    getBean(UserDetailsService.class).
                    loadUserByUsername(email);
            validateToken(request, token, userPrincipal);
        }
        filterChain.doFilter(request, response);
    }



    private void validateToken(HttpServletRequest request, String token, UserPrincipal userPrincipal) {
        boolean isValidToken = jwtServiceImpl.hasTokenNotExpiredAndExistingUser(token, userPrincipal);
        if (isValidToken) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userPrincipal,
                    null, userPrincipal.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource()
                    .buildDetails(request));
            SecurityContextHolder.
                    getContext().
                    setAuthentication(authToken);
        }
    }





    private static boolean hasToBoAuthenticated(String username) {
        return username == null || SecurityContextHolder.getContext().getAuthentication() == null;
    }
}

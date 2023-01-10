package com.hva.helios.rest;

import com.hva.helios.APIConfig;
import com.hva.helios.models.JWToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private APIConfig apiConfig;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // get the encrypted token string from the authorization request header
        String encryptedToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String servletPath = request.getServletPath();

        // block the request if no token was found
        if (HttpMethod.OPTIONS.matches(request.getMethod()) || this.apiConfig.SECURED_PATHS.stream().noneMatch(servletPath::startsWith)) {
            chain.doFilter(request, response);
            return;
        }
        try {
            // decode the encoded and signed token, after removing optional Bearer prefix
            JWToken jwToken = JWToken.decode(encryptedToken.replace("Bearer ", ""), this.apiConfig.getIssuer(), this.apiConfig.getPassphrase());

            // pass-on the token info as an attribute for the request
            request.setAttribute(JWToken.KEY, jwToken);

            System.out.println("SOUT1" + jwToken + " " + JWToken.KEY);

            // proceed along the chain of filters towards the REST controller
            chain.doFilter(request, response);
        } catch (RuntimeException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    e.getMessage() + " You need to logon first.");
            return;
        }
    }
}

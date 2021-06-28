package br.com.senai.api.controller;

import br.com.senai.domain.model.AuthenticationResponse;
import br.com.senai.domain.model.Usuario;
import br.com.senai.security.ImplementUserDetailsService;
import br.com.senai.security.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;
    private ImplementUserDetailsService implementUserDetailsService;
    private JWTUtil jwtUtil;

    @PostMapping("/autheticate")
    public ResponseEntity<?> createAuthenticationToken (@RequestBody Usuario usuario) throws Exception{
        try {authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuario.getUsername(), usuario.getPassword())
            );
        } catch (BadCredentialsException ex){
            throw new Exception("Usuário ou senha inválidos", ex);
        }

        final UserDetails userDetails = implementUserDetailsService.loadUserByUsername(usuario.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }

}

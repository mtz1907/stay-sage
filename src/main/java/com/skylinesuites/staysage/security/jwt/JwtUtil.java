/*package com.skylinesuites.staysage.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUtil {
    private String claveSecreta = "yesIamASecretKey1654765465AndPostmanSayTheLengthIsNotOkItHasToBeMoreThan32Characters";

    public String getToken(String usuario){
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("staysage")
                .setSubject(usuario)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000)) // 10 minutos
                .signWith(SignatureAlgorithm.HS512, claveSecreta.getBytes())
                .compact();

        return "Bearer " + token;
    }


}
*/
package com.zigzag.messenger.security;

import com.zigzag.messenger.API.security.CryptService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by zigza on 17.02.2017.
 */
@Component(value="tokenCryptService")
public class TokenCryptService implements CryptService {
    private final static Logger logger = LoggerFactory.getLogger(TokenCryptService.class);
    Key key = MacProvider.generateKey();
    @Override
    public String decrypt(String compactJws) {
        try {
            assert Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("Joe");
        }
        catch(SignatureException e){
            //don't trust the JWT!
            logger.info("Token Error, Don't trust him !");
        }
        return null;
    }

    @Override
    public String encrypt(String source) {


        String hashedToken = Jwts.builder()
                .setIssuer("http://localhost:8080/messenger/")
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
        return hashedToken;
    }
}

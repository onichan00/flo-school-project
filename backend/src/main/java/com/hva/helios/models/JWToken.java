package com.hva.helios.models;

import io.jsonwebtoken.*;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
public class JWToken {

    String callName;
    Long userType;
    Long accountId;
    public static final String KEY = "tokenInfo";
    private static final String JWT_ISSUER_CLAIM = "iss";
    private static final String JWT_CALLNAME_CLAIM = "sub";
    private static final String JWT_ACCOUNTID_CLAIM = "id";

    public static final String JWT_USERTYPE_CLAIM = "userType";

    public JWToken(String callName, Long accountId, Long userType) {
        this.callName = callName;
        this.accountId = accountId;
        this.userType = userType;
    }

    public static JWToken decode(String token, String issuer, String passphrase) throws ExpiredJwtException, MalformedJwtException {
        Key key = getKey(passphrase);

        Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

        Claims claims = jws.getBody();

        if (!claims.get(JWT_ISSUER_CLAIM).toString().equals(issuer)) {
            throw new MalformedJwtException("Invalid issuer");
        }

        return  new JWToken(
                claims.get(JWT_CALLNAME_CLAIM).toString(),
                Long.valueOf(claims.get(JWT_ACCOUNTID_CLAIM).toString()),
                Long.valueOf(claims.get(JWT_USERTYPE_CLAIM).toString())
                );
    }

    public String encode(String issuer, String passphrase, int expiration, long userType) {

        Key key = getKey(passphrase);

        return Jwts.builder()
                .claim(JWT_CALLNAME_CLAIM, this.callName)
                .claim(JWT_ACCOUNTID_CLAIM, this.accountId)
                .claim(JWT_USERTYPE_CLAIM, this.userType)
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    private static Key getKey(String passphrase) {
        byte[] hmacKey = passphrase.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
    }

    public String getCallName() {
        return callName;
    }

    public Long getUserType() {
        return userType;
    }

    public Long getAccountId() {
        return accountId;
    }
}


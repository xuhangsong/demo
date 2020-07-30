package com.xhs.datasource.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

/**
 * @author xuhan  build  2019/3/15
 */
public class JwtTokenUtils {

    private static Key generatorKey(){
        SignatureAlgorithm ssa = SignatureAlgorithm.HS256;
        byte[] bin = DatatypeConverter.parseBase64Binary("c641395e231c48ecb0de3027b200b635");
        Key key = new SecretKeySpec(bin,ssa.getJcaName());
        return key;
    }

    public static String generatorToken(Map<String,Object> payLoad){
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return Jwts.builder().setPayload(objectMapper.writeValueAsString(payLoad))
                    .signWith(SignatureAlgorithm.HS256,"c641395e231c48ecb0de3027b200b635").compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Claims parseToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(generatorKey()).parseClaimsJws(token);
        return claimsJws.getBody();
    }

}

package com.go4u.keepitfreshplatform.iam.infraestructure.token.jwt;
import com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
public interface BearerTokenService extends TokenService {
    String getBearerTokenFrom(HttpServletRequest token);

    String generateToken(Authentication authentication);

    String generateToken(org.springframework.security.core.Authentication authentication);
}

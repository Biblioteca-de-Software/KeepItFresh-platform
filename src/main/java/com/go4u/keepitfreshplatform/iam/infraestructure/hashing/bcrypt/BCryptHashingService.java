package com.go4u.keepitfreshplatform.iam.infraestructure.hashing.bcrypt;
import com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}

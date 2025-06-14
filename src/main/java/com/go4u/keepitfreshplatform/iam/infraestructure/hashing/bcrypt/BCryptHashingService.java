package com.go4u.keepitfreshplatform.iam.infraestructure.hashing.bcrypt;
import com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}

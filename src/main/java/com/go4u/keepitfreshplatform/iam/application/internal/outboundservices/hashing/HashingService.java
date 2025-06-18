package com.go4u.keepitfreshplatform.iam.application.internal.outboundservices.hashing;


public interface HashingService {
    /**
     * Encode a raw password.
     * @param rawPassword the raw password to encode
     * @return the encoded password
     */
    String encode(CharSequence rawPassword);

    /**
     * Match a raw password with an encoded password.
     * @param rawPassword the raw password to match
     * @param encodedPassword the encoded password to match
     * @return true if the raw password matches the encoded password, false otherwise
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);
}
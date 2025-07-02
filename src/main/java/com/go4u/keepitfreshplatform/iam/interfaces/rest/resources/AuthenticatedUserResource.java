package com.go4u.keepitfreshplatform.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
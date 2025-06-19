package com.go4u.keepitfreshplatform.iam.domain.model.commands;

import com.go4u.keepitfreshplatform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password,List<Role> roles) {

}
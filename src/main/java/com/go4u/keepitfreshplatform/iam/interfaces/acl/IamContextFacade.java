package com.go4u.keepitfreshplatform.iam.interfaces.acl;
import java.util.List;

public interface IamContextFacade {

    Long createUser(String username, String password);
    Long createUser(String username, String password, List<String> roles);
    Long fetchUserIdByUsername(String username);
    String fetchUsernameByUserId(Long userId);




}

package com.go4u.keepitfreshplatform.iam.domain.services;
import com.go4u.keepitfreshplatform.iam.domain.model.aggregates.User;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignInCommand;
import com.go4u.keepitfreshplatform.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserCommandsService {
    Optional<ImmutablePair<User,String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);


}

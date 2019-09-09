package com.trackdesk.domain.usecases;

import com.trackdesk.domain.entities.login.LoginRequestEntity;
import com.trackdesk.domain.entities.login.LoginResponseEntity;
import com.trackdesk.domain.repositories.LoginRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public final class LoginUseCase implements UseCase<LoginRequestEntity, LoginResponseEntity> {

    private final LoginRepository loginRepository;

    @Inject
    public LoginUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Single<LoginResponseEntity> execute(LoginRequestEntity input) {
        return loginRepository.doLogin(input.getUsername(), input.getPassword());
    }
}

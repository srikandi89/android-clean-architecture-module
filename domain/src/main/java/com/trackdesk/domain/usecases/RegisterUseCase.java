package com.trackdesk.domain.usecases;

import com.trackdesk.domain.entities.register.RegisterRequestEntity;
import com.trackdesk.domain.entities.register.RegisterResponseEntity;
import com.trackdesk.domain.repositories.RegisterRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class RegisterUseCase implements UseCase<RegisterRequestEntity, RegisterResponseEntity> {

    private RegisterRepository registerRepository;

    @Inject
    public RegisterUseCase(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public Single<RegisterResponseEntity> execute(RegisterRequestEntity input) {
        return registerRepository.doRegister(input);
    }
}

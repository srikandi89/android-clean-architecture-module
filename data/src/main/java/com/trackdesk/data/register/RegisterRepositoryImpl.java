package com.trackdesk.data.register;

import com.trackdesk.domain.entities.register.RegisterRequestEntity;
import com.trackdesk.domain.entities.register.RegisterResponseEntity;
import com.trackdesk.domain.repositories.RegisterRepository;

import io.reactivex.Single;

public class RegisterRepositoryImpl implements RegisterRepository {
    @Override
    public Single<RegisterResponseEntity> doRegister(RegisterRequestEntity requestEntity) {
        RegisterResponseEntity entity = new RegisterResponseEntity(200, "ad3");
        return Single.just(entity);
    }
}

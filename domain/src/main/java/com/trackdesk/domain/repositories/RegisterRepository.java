package com.trackdesk.domain.repositories;

import com.trackdesk.domain.entities.register.RegisterRequestEntity;
import com.trackdesk.domain.entities.register.RegisterResponseEntity;

import io.reactivex.Single;

public interface RegisterRepository {
    Single<RegisterResponseEntity> doRegister(RegisterRequestEntity requestEntity);
}

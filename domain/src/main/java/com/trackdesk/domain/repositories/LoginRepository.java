package com.trackdesk.domain.repositories;

import com.trackdesk.domain.entities.login.LoginResponseEntity;

import io.reactivex.Single;

public interface LoginRepository {
    Single<LoginResponseEntity> doLogin(String username, String password);
}

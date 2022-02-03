package com.example.a20220203_harshraj_nycschools.api.base;

public interface ApiResponseCallback<S> {

    void onSuccess(S value);

    void onError(String error);
}

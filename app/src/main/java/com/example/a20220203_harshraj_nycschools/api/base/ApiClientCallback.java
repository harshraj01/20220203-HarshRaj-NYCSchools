package com.example.a20220203_harshraj_nycschools.api.base;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class implements retrofit Callback to get the success response or failure of API.
 */
public class ApiClientCallback implements Callback{

    private ApiResponseCallback apiResponseCallback;

    public ApiClientCallback(ApiResponseCallback apiResponseCallback) {
        this.apiResponseCallback = apiResponseCallback;
    }

    /**
     * Take actions based of successful or error response.
     * For error we have different error codes to show in UI.
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call call, Response response) {
        if(apiResponseCallback != null) {
            if (response.isSuccessful()) {
                onSuccess(response);
            } else {
                apiResponseCallback.onError("Error");
            }
        }
    }

    /**
     * Take action for failure response.
     * From here we can have different error codes implemented to show different kind of errors in UI.
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call call, Throwable t) {
        System.out.println("Error : " + t.toString());
        apiResponseCallback.onError("Error");
    }

    /**
     * In case of success and reponse body is not null call onSuccess callback.
     * @param response
     */
    private void onSuccess(Response response) {
        if(response.body() != null) {
            apiResponseCallback.onSuccess(response.body());
        } else {
            apiResponseCallback.onError("Error");
        }
    }
}

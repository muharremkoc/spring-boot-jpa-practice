package org.springbootjpapractice.model.response;

public class SuccessDataResponse<T> extends DataResponse<T>{

    public SuccessDataResponse(String message, T data) {
        super(true, message, data);
    }
}

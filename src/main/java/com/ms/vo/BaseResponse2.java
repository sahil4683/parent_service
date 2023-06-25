package com.ms.vo;

import lombok.Data;

@Data
public class BaseResponse2<T> {
	
    private boolean success;
    private T data;
    private String errorMessage;
    private int statusCode;

    public BaseResponse2() {
    }

    public BaseResponse2(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BaseResponse2(boolean success, T data, String errorMessage, int statusCode) {
        this.success = success;
        this.data = data;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    
    /**
     * Sample Code
     */
//    @GetMapping("/api/data")
//    public CustomResponse<List<String>> getData() {
//        try {
//            List<String> data = getDataFromService();
//            CustomResponse<List<String>> response = new CustomResponse<>(true, data);
//            return response;
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
//            CustomResponse<List<String>> errorResponse = new CustomResponse<>(false, null, errorMessage, statusCode);
//            return errorResponse;
//        }
//    }
    
}

package com.ms.vo;

import lombok.Data;

@Data
public class BaseResponse {
    
	private String status;
    private Object data;
    private String errorMessage;
    private int statusCode;

    // Constructors
    public BaseResponse() {
    }

    public BaseResponse(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public BaseResponse(String status, Object data, String errorMessage, int statusCode) {
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
    
   
    /**
     * Sample Code
     */
//    @GetMapping("/api/data")
//    public CustomResponse getData() {
//        try {
//            List<String> data = getDataFromService();
//            CustomResponse response = new CustomResponse("success", data);
//            return response;
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
//            CustomResponse errorResponse = new CustomResponse("error", null, errorMessage, statusCode);
//            return errorResponse;
//        }
//    }
}

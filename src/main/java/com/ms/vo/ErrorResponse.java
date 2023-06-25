package com.ms.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
	public ErrorResponse() {
		timestamp = LocalDateTime.now();
	}
    
    
}

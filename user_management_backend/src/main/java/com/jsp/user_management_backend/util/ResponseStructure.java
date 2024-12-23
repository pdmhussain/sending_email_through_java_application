package com.jsp.user_management_backend.util;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseStructure {
	private int status;
	private String msg;
	private Object data;
	private LocalDateTime dateTime;

}

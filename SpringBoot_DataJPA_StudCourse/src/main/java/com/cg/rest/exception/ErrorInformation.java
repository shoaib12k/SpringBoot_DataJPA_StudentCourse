package com.cg.rest.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInformation {

	private String uri;
	private String msg;
	private LocalDateTime dateTime;
}

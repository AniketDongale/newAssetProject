package com.company.exceptions;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidEmployeeId.class)
	public ResponseEntity<ExceptionResponce>handleInvalidEmployeeId(InvalidEmployeeId e){
		ExceptionResponce error = new ExceptionResponce("Invalid Employee Id",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidAssetId.class)
	public ResponseEntity<ExceptionResponce>handleInvalidAssetId(InvalidAssetId e){
		ExceptionResponce error = new ExceptionResponce("No Asset With This Id",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoAuthority.class)
	public ResponseEntity<ExceptionResponce>handleNoAuthority(NoAuthority e){
		ExceptionResponce error = new ExceptionResponce("You do not have Authority",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(InvalidOrderId.class)
	public ResponseEntity<ExceptionResponce>handleInvalidOrderId(InvalidOrderId e){
		ExceptionResponce error = new ExceptionResponce("Order does not exist",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateAsset.class)
	public ResponseEntity<ExceptionResponce>handleDuplicateAsset(DuplicateAsset e){
		ExceptionResponce error = new ExceptionResponce("Order already exist",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidEmployeeDetails.class)
	public ResponseEntity<ExceptionResponce>handleInvalidEmployeeDetails(InvalidEmployeeDetails e){
		ExceptionResponce error = new ExceptionResponce("Employee details are invalid",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NoAssetsFound.class)
	public ResponseEntity<ExceptionResponce>handleNoAssetsFound(NoAssetsFound e){
		ExceptionResponce error = new ExceptionResponce("Not found",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoOrderFound.class)
	public ResponseEntity<ExceptionResponce>handleNoOrderFound(NoOrderFound e){
		ExceptionResponce error = new ExceptionResponce("Not found",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.NOT_FOUND);
	}
}
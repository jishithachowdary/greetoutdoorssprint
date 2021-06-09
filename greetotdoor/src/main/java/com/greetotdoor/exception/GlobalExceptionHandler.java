package com.greetotdoor.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CartException.class)
	public ResponseEntity<?> handleCartException(CartException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(GrowthReportException.class)
	public ResponseEntity<?> handleGrowthReportException(GrowthReportException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e, WebRequest req){
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<?> handleIDNotFoundException(IDNotFoundException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<?> handleOrderException(OrderException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<?> handleProductException(ProductException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SalesReportException.class)
	public ResponseEntity<?> handleSalesReportException(SalesReportException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(WishlistException.class)
	public ResponseEntity<?> handleWishlistException(WishlistException e,WebRequest req){
		ErrorDetails ed=new ErrorDetails(new Date(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.NOT_FOUND);
	}

	
}

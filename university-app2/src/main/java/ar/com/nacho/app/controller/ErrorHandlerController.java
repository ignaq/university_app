package ar.com.nacho.app.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ar.com.nacho.app.error.NotFoundException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(NotFoundException.class)
	public String notFoundException(NotFoundException notFound, Model model) {
		model.addAttribute("error", "Error: No encontrado!");
		model.addAttribute("message", notFound.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("time", new Date());
		return "error/data_error";
	}
}

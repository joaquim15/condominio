package br.com.intera.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.HttpStatus;

@RestController
@ControllerAdvice
public class ApiExceptionHandler {

	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErroView handleException(Exception ex) {
		return new ErroView(ex.getMessage());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(LoginInvalido.class)
	public ErroView usuarioNaoEncontrado(Exception ex) {
		return new ErroView(ex.getMessage());
	}

}

package br.com.intera.Exception;

/**
 * Exceção para reservas já existentes
 * 
 * @author vagner
 *
 */
public class BlocoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1097579080784954670L;

	public BlocoNaoExisteException() {
	}

	public BlocoNaoExisteException(String message, Object object) {
		super(message);
	}

	public BlocoNaoExisteException(Throwable cause) {
		super(cause);
	}

	public BlocoNaoExisteException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlocoNaoExisteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

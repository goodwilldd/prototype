package kr.pe.goodwilldd.core.exception;

/**
 * 일반적인 오류에 대한 Exception 처리 : 테스트
 * 
 * @author sylee
 * 
 */
public class GenericException extends RuntimeException {
	private String message;

	public GenericException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

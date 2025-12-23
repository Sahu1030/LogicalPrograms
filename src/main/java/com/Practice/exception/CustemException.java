package com.Practice.exception;



class CustemException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustemException(String message) {
        super(message);
    }
}

 class BusinessException extends Exception {
    private int errorCode;

    public BusinessException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

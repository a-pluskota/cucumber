package com.stackoverflow.configs;

public class IncorrectParameterException extends Exception{

    public IncorrectParameterException() {
        super();
    }

    public IncorrectParameterException(
            String message
    ) {
        super(message);
    }

    public IncorrectParameterException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }

    public IncorrectParameterException(
            Throwable cause
    ) {
        super(cause);
    }

    protected IncorrectParameterException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

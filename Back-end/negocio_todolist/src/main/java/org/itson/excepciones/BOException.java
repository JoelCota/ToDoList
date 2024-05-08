/**
 * BOException.java
 * Jun 23, 2023 2:31:41 PM
 */
package org.itson.excepciones;

/**
 * Descripción de la clase:
 *
 */
public class BOException extends RuntimeException {

    /**
     *
     */
    public BOException() {

    }

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BOException(Throwable cause) {
        super(cause);
    }

    public BOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

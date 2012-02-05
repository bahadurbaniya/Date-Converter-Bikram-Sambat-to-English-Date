/**
 * 
 */
package com.fa.converter;

/**
 * @author bbaniya
 *
 */
public class InvalidBsDayOfMonthException extends RuntimeException {


    private static final long serialVersionUID = 2360070484241288062L;

    public InvalidBsDayOfMonthException(String message){
	super(message);	
    }
}

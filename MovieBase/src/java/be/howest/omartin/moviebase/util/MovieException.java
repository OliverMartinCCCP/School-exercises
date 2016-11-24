/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.moviebase.util;

/**
 *
 * @author frederic
 */
public class MovieException
        extends RuntimeException
{
    
    public MovieException()
    {
        super();
    }
    
    public MovieException(String message)
    {
        super(message);
    }
    
    public MovieException(Throwable t)
    {
        super(t);
    }
    
    public MovieException(String message, Throwable t)
    {
        super(message, t);
    }
    
}

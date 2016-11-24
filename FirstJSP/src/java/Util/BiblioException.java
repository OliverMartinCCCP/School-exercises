package Util;

/**
 *
 * @author frederic
 */
public class BiblioException
        extends RuntimeException
{
    
    public BiblioException()
    {
        super();
    }
    
    public BiblioException(String message)
    {
        super(message);
    }
    
    public BiblioException(Throwable t)
    {
        super(t);
    }
    
    public BiblioException(String message, Throwable t)
    {
        super(message, t);
    }
    
}

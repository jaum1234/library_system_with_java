package exceptions;

public class DuplicatedEntryException extends Exception
{
    public DuplicatedEntryException(String message)
    {
        super(message);
    }
}

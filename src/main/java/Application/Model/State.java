package Application.Model;

public enum State
{
    TODO("to do"),
    ACTIVE("active"),
    DONE("done");

    private final String displayText;

    State(String displayText)
    {
        this.displayText = displayText;
    }

    @Override
    public String toString()
    {
        return displayText;
    }

}

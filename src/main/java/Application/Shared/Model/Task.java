package Application.Shared.Model;

public class Task
{
    protected User creator;
    protected String title;
    protected String description;
    protected State state;

    public User getCreator()
    {
        return creator;
    }

    public void setCreator(User creator)
    {
        this.creator = creator;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }
}

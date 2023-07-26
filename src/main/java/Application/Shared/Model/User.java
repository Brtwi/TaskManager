package Application.Shared.Model;

import lombok.Data;

@Data
public class User
{
    private String username;
    private String password;
    private String email;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public User(String username)
    {
        this.username = username;
    }
}

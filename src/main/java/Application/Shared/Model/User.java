package Application.Shared.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

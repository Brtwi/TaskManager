package Application.Model.Entities;

import lombok.Data;

@Data
public class User
{
    private String username;
    private String password;
    private String email;

    private User(UserBuilder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
    }
    public static class UserBuilder
    {
        private final String username;
        private String password;
        private String email;

        public UserBuilder(String username)
        {
            this.username = username;
        }

        public UserBuilder password(String password)
        {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }

        public User build()
        {
            return new User(this);
        }
    }
}

package Application.Model.Network;

import Application.Model.UserModel;

public class APIData
{
    public static final String REGISTRATION_URI = "http://localhost:8080/api/v1/user/register";
    public static final String LOGIN_URI = "http://localhost:8080/api/v1/user/login";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_APP_JSON = "application/json";
    public static final String GET_TASK_URI = "http://localhost:8080/api/v1/task/" + UserModel.getUser().getUsername().toLowerCase();
}

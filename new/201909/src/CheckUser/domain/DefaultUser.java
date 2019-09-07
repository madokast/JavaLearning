package CheckUser.domain;

public class DefaultUser {
    public static User getDefaultUser(){
        final User user = new User();
        user.setUsername("zrx");
        user.setPassword("123456");

        return user;
    }
}

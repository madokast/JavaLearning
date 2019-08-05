package Test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanUtilsTest {
    @Test
    public void getPropertyTest(){
        final User user = new User();
        user.setId(1);
        user.setUsername("zrx");
        user.setPassword("123");

        try {
            final String id = BeanUtils.getProperty(user, "id");
            System.out.println("id = " + id);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void setPropertyTest(){
        final User user = new User();

        try {
            BeanUtils.setProperty(user,"username","zrx");
            System.out.println("user = " + user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void populateTest(){
        final HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("id","223");
        stringStringHashMap.put("username","miao");
        stringStringHashMap.put("password","abc123");

        final User user = new User();

        try {
            BeanUtils.populate(user,stringStringHashMap);
            System.out.println("user = " + user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

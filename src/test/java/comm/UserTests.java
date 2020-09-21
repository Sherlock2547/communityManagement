package comm;

import community.entity.User;
import org.junit.Test;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/5 18:56 下午
 **/
public class UserTests {
    @Test
    public void testRun() {
        User user=new User();
        user.setId(1222);
        user.setName("小明");
        user.setPwd("215434");
        user.run();
    }
}

import com.zt.dao.Impl.UserDaoImpl;
import com.zt.entity.Users;
import com.zt.mapper.UserMapper;

/**
 * @author scj
 * @create 2020-04-15 17:04
 */

public class test1 {
    public static void main(String[] args) {
        UserMapper um = new UserDaoImpl();
        int a= um.deluser(4);
        System.out.println(a);
    }

}

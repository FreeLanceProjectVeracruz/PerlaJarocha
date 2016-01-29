package model.jhernandez.interfaces;

import java.util.List;
import model.jhernandez.vo.UsersVo;

/**
 *
 * @author WIN 8
 */
public interface IUsersDao {

    /**
     *
     * @return
     */
    public List<UsersVo> getAllUsers();

    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public UsersVo getUser(String user, String pass);
}

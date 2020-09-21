package community.repository;

import community.entity.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
/**
 * Created by 17206133--周文林
 * Date: 2020/5/4 22:11 下午
 **/
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select * from users where name like :name")
    Collection<User> findByName(@Param("name") String name);

    @Query("delete from users where name= :name")
    @Modifying
    Integer deleteByName(@Param("name")String name);

}

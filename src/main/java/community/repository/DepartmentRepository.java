package community.repository;

import community.entity.Department;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by 17206133--周文林
 * Date: 2020/6/28 22:12 下午
 **/
@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>
{
    @Query("select * from department where name like :name")
    Collection<Department> findByName(@Param("name") String name);

    @Query("delete from department where name= :name")
    @Modifying
    Integer deleteByName(@Param("name")String name);
}

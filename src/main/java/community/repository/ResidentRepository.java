package community.repository;

import community.entity.Resident;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/8 15:35 下午
 **/
@Repository
public interface ResidentRepository extends CrudRepository<Resident,Integer> {
    @Query("select * from residents where name like :name")
    Collection<Resident> findByName(@Param("name") String name);

    @Query("delete from residents where name= :name")
    @Modifying
    Integer deleteByName(@Param("name")String name);
}

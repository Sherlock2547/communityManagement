package community.repository;

import community.entity.House;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
import java.util.Collection;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/8 15:19 下午
 **/
@Repository
public interface HouseRepository extends CrudRepository<House,Integer> {

    @Query("select * from houses where address like :address")
    Collection<House> findByAddress(@Param("address") String address);

    @Query("delete from houses where address= :address")
    @Modifying
    Integer deleteByAddress(@Param("address")String address);
}

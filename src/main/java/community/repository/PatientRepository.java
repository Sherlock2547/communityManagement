package community.repository;

import community.entity.Patient;
import community.entity.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by 17206133--周文林
 * Date: 2020/6/28 21:27 下午
 **/
@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {
    @Query("select * from patient where name like :name")
    Collection<Patient> findByName(@Param("name") String name);

    @Query("delete from patient where name= :name")
    @Modifying
    Integer deleteByName(@Param("name")String name);
}

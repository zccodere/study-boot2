package com.zccoder.boot2.ch6.jpa.repository;

import com.zccoder.boot2.ch6.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <br>
 * 标题: 用户Repository<br>
 * 描述: 用户Repository<br>
 * 时间: 2018/06/26<br>
 *
 * @author zc
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 通过名称查询
     *
     * @param name 名称
     * @return 用户
     */
    User findByName(String name);

    /**
     * 通过名称和部门ID查询
     *
     * @param name         名称
     * @param departmentId 部门ID
     * @return 用户
     */
    @Query("select u from User u where u.name=?1 and u.department.id=?2")
    User findUserByDepartment(String name, Integer departmentId);

    /**
     * 通过名称和部门ID查询
     *
     * @param name         名称
     * @param departmentId 部门ID
     * @return 用户
     */
    @Query(value = "select * from user where name=?1 and department_id=?2", nativeQuery = true)
    User nativeQuery(String name, Integer departmentId);

    /**
     * 通过名称和部门ID查询
     *
     * @param name         名称
     * @param departmentId 部门ID
     * @return 用户
     */
    @Query(value = "select * from user where name=:name and department_id=:departmentId", nativeQuery = true)
    User nativeQuery2(@Param("name") String name, @Param("departmentId") Integer departmentId);

    /**
     * 分组统计每个部门的用户数
     *
     * @return 每个部门的用户数
     */
    @Query(value = "select department_id,count(1) total from user group by department_id", nativeQuery = true)
    List<Object[]> queryUserCount();

    /**
     * 通过部门ID查询用户ID集合
     *
     * @param departmentId 部门ID
     * @return 用户ID集合
     */
    @Query(value = "select id from user where department_id=?1", nativeQuery = true)
    List<Integer> queryUserIds(Integer departmentId);

    /**
     * 通过部门ID分页查询
     *
     * @param departmentId 部门ID
     * @param page         分页参数
     * @return 用户集合
     */
    @Query(value = "select u from User u where u.department.id=?1")
    Page<User> queryUsers(Integer departmentId, Pageable page);


}

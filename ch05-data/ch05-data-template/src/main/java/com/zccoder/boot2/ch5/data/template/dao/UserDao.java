package com.zccoder.boot2.ch5.data.template.dao;

import com.zccoder.boot2.ch5.data.template.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <br>
 * 标题: 用户 DAO<br>
 * 描述: 用户 DAO<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer totalUserInDepartment(Long departmentId) {
        String sql = "select count(1) from user where department_id=?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, departmentId);
        return count;
    }

    public Integer totalUserInDepartment2(Long departmentId) {
        String sql = "select count(1) from user where department_id=:deptId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("deptId", departmentId);
        Integer count = namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  Integer.class) ;
        return count;
    }

    public User findUserById(Long userId) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), 1);
        return user;
    }

    public List<User> getUserByDepartmentId(Long departmenetId) {
        String sql = "select * from user where department_id=? ";
        List<User> user = jdbcTemplate.query(sql, new UserRowMapper(), 1);
        return user;
    }

    public Map findUserById2(Integer userId) {
        String sql = "select * from user where id=?";
        Map map = jdbcTemplate.queryForMap(sql, userId);
        return map;
    }

    public void updateInfo(User user) {
        String sql = "update user set name=? and departmet_id=? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getDepartmentId(), user.getId());
    }

    public void updateInfoByNamedJdbc(User user) {
        String sql = "update user set name=:name and departmet_id=:departmentId where id = :id";
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, source);

    }

    public Integer insertUser(final User user) {
        final String sql = "insert into user (name, departmet_id ) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((PreparedStatementCreator) connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, user.getName());
            ps.setInt(2, user.getDepartmentId());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setDepartmentId(rs.getInt("department_id"));
            user.setCreateTime(rs.getDate("create_time"));
            return user;
        }
    }
}

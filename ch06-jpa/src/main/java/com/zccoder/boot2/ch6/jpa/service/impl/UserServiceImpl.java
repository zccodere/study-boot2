package com.zccoder.boot2.ch6.jpa.service.impl;

import java.util.*;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.zccoder.boot2.ch6.jpa.entity.Department;
import com.zccoder.boot2.ch6.jpa.entity.User;
import com.zccoder.boot2.ch6.jpa.repository.UserRepository;
import com.zccoder.boot2.ch6.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <br>
 * 标题: 用户服务实现<br>
 * 描述: 用户服务实现<br>
 * 时间: 2018/06/26<br>
 *
 * @author zc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("hhaancd");
        entityManager.merge(user);
    }

    @Override
    public User findUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Integer addUser(User user) {
        userRepository.save(user);
        user.setName("1" + user.getName());
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<User> getAllUser(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<User> pageObject = userRepository.findAll(pageable);
        int totalPage = pageObject.getTotalPages();
        int realSize = pageObject.getSize();
        long count = pageObject.getTotalElements();

        return pageObject.getContent();
    }

    @Override
    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getUser(String name, Integer departmentId) {
//		getUser(departmentId);
        return userRepository.nativeQuery2(name, departmentId);
//		return userRepository.findUserByDepartment(name, departmentId);
    }

    private void getUser(Integer departmentId) {
        List<Object[]> list = userRepository.queryUserCount();
        List<Integer> ids = userRepository.queryUserIds(departmentId);
        int a = 1;
    }

    @Override
    public Page<User> queryUser(Integer departmentId, Pageable page) {
        return userRepository.queryUsers(departmentId, page);
    }

    @Override
    public Page<User> queryUser2(Integer departmentId, Pageable page) {
        //构造JPQL和实际的参数
        StringBuilder baseJpql = new StringBuilder("from User u where 1=1 ");
        Map<String, Object> paras = new HashMap<>(page.getPageSize());
        if (departmentId != null) {
            baseJpql.append("and  u.department.id=:deptId");
            paras.put("deptId", departmentId);
        }
        //查询满足条件的总数
        long count = getQueryCount(baseJpql, paras);
        if (count == 0) {
            return new PageImpl(Collections.emptyList(), page, 0);
        }
        //查询满足条件结果集
        List list = getQueryResult(baseJpql, paras, page);

        //返回结果
        Page ret = new PageImpl(list, page, count);
        return ret;
    }

    @Override
    public List<User> getByExample(String name) {
        User user = new User();
        Department dept = new Department();
        user.setName(name);
        dept.setId(1);
        user.setDepartment(dept);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
        Example<User> example = Example.of(user, matcher);
        List<User> list = userRepository.findAll(example);
        return list;
    }

    private List getQueryResult(StringBuilder baseJpql, Map<String, Object> paras, Pageable page) {
        Query query = entityManager.createQuery("select u " + baseJpql.toString());
        setQueryParameter(query, paras);
        query.setFirstResult((int) page.getOffset());
        query.setMaxResults(page.getPageNumber());
        List list = query.getResultList();
        return list;
    }

    private Long getQueryCount(StringBuilder baseJpql, Map<String, Object> paras) {
        Query query = entityManager.createQuery("select count(1) " + baseJpql.toString());
        setQueryParameter(query, paras);
        Number number = (Number) query.getSingleResult();
        return number.longValue();
    }

    private void setQueryParameter(Query query, Map<String, Object> paras) {
        for (Entry<String, Object> entry : paras.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

}

package com.zccoder.boot2.ch13.elasticsearch.dao;

import java.util.List;

import com.zccoder.boot2.ch13.elasticsearch.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <br>
 * 标题: 书籍Dao<br>
 * 描述: 书籍Dao<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@Repository
public interface BookDao extends CrudRepository<BookEntity, String> {

    /**
     * 通过信息查询
     *
     * @param key 信息
     * @return 书籍集合
     */
    List<BookEntity> getByMessage(String key);

    /**
     * 通过信息查询
     *
     * @param key      信息
     * @param pageable 分页信息
     * @return 分页书籍集合
     */
    Page<BookEntity> getByMessage(String key, Pageable pageable);

    /**
     * 通过名称查询
     *
     * @param name     名称
     * @param pageable 分页信息
     * @return 分页书籍集合
     */
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?0\"}}}}")
    Page<BookEntity> findByName(String name, Pageable pageable);
}

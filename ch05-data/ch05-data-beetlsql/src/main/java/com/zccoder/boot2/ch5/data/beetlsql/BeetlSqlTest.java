package com.zccoder.boot2.ch5.data.beetlsql;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zccoder.boot2.ch5.data.beetlsql.dao.UserDao;
import com.zccoder.boot2.ch5.data.beetlsql.entity.User;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;

/**
 * <br>
 * 标题: 测试类<br>
 * 描述: 一个单独的类体验Beetlsql，可以测试代码生成，内置的crud，还有sql查询<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
public class BeetlSqlTest {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
	static String userName="root";
	static String password="root";
	
	public static void main(String[] args) throws Exception {
		ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
		DBStyle mysql = new MySqlStyle();
		// sql语句放在classpagth的/sql 目录下
		SQLLoader loader = new ClasspathLoader("/sql");
		// 数据库命名跟java命名转化规则，UnderlinedNameConversion 指数据库表和列是下划线分割
		UnderlinedNameConversion nc = new  UnderlinedNameConversion();
		// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
		SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
		queryUser(sqlManager);
	}
	
	public static void gen(SQLManager sqlManager) throws Exception{
		sqlManager.genPojoCodeToConsole("user");
		
	}
	public static void genCode(SQLManager sqlManager) throws Exception{
		sqlManager.genPojoCode("user", "com.bee.sample.ch5.entity");
	}
	
	public static void addUser(SQLManager sqlManager) {
		User user = new User();
		user.setDepartmentId(1);
		user.setCreateTime(new Date());
		user.setName("xiandafu");
		sqlManager.insert(user);
	}
	
	public static void findUser(SQLManager sqlManager) {
		Integer key = 1;
		User user = sqlManager.unique(User.class, key);
		
	}
	
	public static void updateUser(SQLManager sqlManager){
		Integer key = 1;
		User user = sqlManager.unique(User.class, key);
		user.setName("NewName");
		sqlManager.updateById(user);
	}
	
	public static void updateTemplateUser(SQLManager sqlManager){
		Integer key = 1;
		User user = new User();
		user.setId(key);
		user.setName("NewName");
		sqlManager.updateTemplateById(user);
		
	}
	
	public static void queryUser(SQLManager sqlManager){
		User query = new User();
		query.setName("NewName");
		List<User> list = sqlManager.select("user.selectSample", User.class,query);

	}
	
	public static void queryUserByMap(SQLManager sqlManager){
		Map paras = new HashMap(16);
		paras.put("name", "NewName");
		List<User> list = sqlManager.select("user.selectSample", User.class,paras);
	}
	
	public static void daoQuery(SQLManager sqlManager){
		User query = new User();
		query.setName("NewName");
		UserDao dao = sqlManager.getMapper(UserDao.class);
		List<User> list  = dao.selectSample(query);
	}

}

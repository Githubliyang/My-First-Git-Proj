package mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import dao.user;
public interface userMapper {

	public List<user> finduserList();
	public List<user> selectuserByid(int id);
	public boolean updateconfirm(user u);
	public List<user> selectUserByPage(@Param(value="startPos") Integer startPos,
	        @Param(value="pageSize") Integer pageSize);
	 
	/**
	 * 用户总数
	 */
	public long getUserCount();
}

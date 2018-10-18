package service;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import dao.user;

public interface userService {

	public List<user> finduserList();
	public List<user> selectuserByid(int id);
	public boolean updateconfirm(user u);
	public void showUserByPage(HttpServletRequest request,Model model); 
}

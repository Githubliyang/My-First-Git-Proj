package interfaceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import dao.Page;
import dao.user;
import mapper.userMapper;
import service.userService;

public class userImpl implements userService {

	@Resource
	public userMapper user;
	@Override
	public List<user> finduserList() {
		// TODO Auto-generated method stub
		return  user.finduserList();
	}
	@Override
	public List<dao.user> selectuserByid(int id) {
		// TODO Auto-generated method stub
		return user.selectuserByid(id);
	}
	@Override
	public boolean updateconfirm(dao.user u) {
		return user.updateconfirm(u);
	}
	@Override
	public void showUserByPage(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		String pageNow = request.getParameter("pageNow"); 
        Page page = null;     
        List<user> u = new ArrayList<user>(); 
      //查询用户总数
        int totalCount = (int) user.getUserCount();      
        if (pageNow != null) { 
            page = new Page(totalCount, Integer.parseInt(pageNow)); 
            u = this.user.selectUserByPage(page.getStartPos(), page.getPageSize()); 
        } else { 
            page = new Page(totalCount, 1); 
            u = this.user.selectUserByPage(page.getStartPos(), page.getPageSize()); 
        }        
        model.addAttribute("user", u); 
        model.addAttribute("page", page); 
	}
	
}

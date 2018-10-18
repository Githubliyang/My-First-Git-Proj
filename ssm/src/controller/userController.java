package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.userService;

@Controller
public class userController {

	@Resource
	public userService userservice;

	@RequestMapping(value = "/demo.do")
	public ModelAndView selectAlluser() {
		ModelAndView model = new ModelAndView();
		model.addObject("list", userservice.finduserList());
		model.setViewName("default.jsp");
		return model;
	}

	@RequestMapping(value = "/update.do")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		model.addObject("list", userservice.selectuserByid(id));
		model.setViewName("test.jsp");
		return model;
	}

	@RequestMapping(value = "/updateconfirm.do")
	public void updateconfirm(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("age") int age,HttpServletResponse resp,HttpServletRequest req) {
		try {
			resp.setContentType("text/html;charset=utf-8");  
		    req.setCharacterEncoding("utf-8"); 
			user u = new user();
			u.setId(id);
			u.setName(name);
			u.setAge(age);
			userservice.updateconfirm(u);
			System.out.println(u.getName());
			resp.sendRedirect("page.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/page.do")
    public String pageUser(HttpServletRequest request,Model model){
        userservice.showUserByPage(request, model);
		return "page.jsp";
    }
	@RequestMapping(value="/test.do")
    public void test(HttpServletRequest req,HttpServletResponse resp){
       try {
    	    req.setAttribute("name", "李阳");
		req.getRequestDispatcher("demo.jsp").forward(req, resp);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}

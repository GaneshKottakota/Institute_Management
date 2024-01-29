package in.ganeshIT.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ganeshIT.Application.binding.Dashboard;
import in.ganeshIT.Application.entity.Counsellor;
import in.ganeshIT.Application.service.CounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	@Autowired
	private CounsellorService service;
	@GetMapping("/")
	public String logIn(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "Login";
	}
	@GetMapping("/register")
	public String recoverPwdPage(Model model) {
		
		
		return "pwdview";
		
		
	}
	@GetMapping("/dashboardview")
	public String dashboard(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		 Object object = session.getAttribute("cid");
		     int cid= (Integer)object;
		 Dashboard dashboard = service.dashboardResponse(cid);
		 model.addAttribute("db", dashboard);
		return "dashboard";
		
	}
	@GetMapping("/regform")
	public String RegisterCounsellor(Model model) {
		      model.addAttribute("con", new Counsellor());
		      return "regform";
		      
	}
	@PostMapping("/registerc")
	public String registration(Counsellor c,Model model) {
		       String msg = service.saveCounsellor(c);
		       model.addAttribute("msg", msg);
		       return "redirect:/"
		       ;
	}
	@PostMapping("/loginview")
	public String handleLogin( Counsellor counsellor,HttpServletRequest req, Model model) {
		Counsellor obj = service.loginCheck(counsellor.getEmail(),counsellor.getPwd());
		if(obj==null){
			model.addAttribute("errmsg","invalid credentials!!!");
			return "Login";
			
		}
		HttpSession session = req.getSession(true);
		        session.setAttribute("cid",obj.getCid());
		
			return "redirect:/dashboardview";
		
		 
	}
	@GetMapping("/recover-pwd")
	public String recoverpwd(@RequestParam String email,Model model) {
		          boolean status = service.recoverPwd(email);
		          if(status) {
		        	  model.addAttribute("sucmsg", "pwd sent to your mailid");
		          }
		          else {
		          model.addAttribute("errmsg", "invalid mailid");
		          }
		          return "forgotpwdview";
		
	}

}

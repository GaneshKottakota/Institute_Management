package in.ganeshIT.Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ganeshIT.Application.binding.SearchCriteria;
import in.ganeshIT.Application.entity.StudentEnq;
import in.ganeshIT.Application.service.EnqService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	EnqService service;
	
	
	@GetMapping("/getForm")
	public String getForm(Model model) {
		model.addAttribute("enq", new StudentEnq());
		return "Enqform";
		
	}
	
	
	
	@PostMapping("/addEnq")
	public String enqForm(@ModelAttribute("enq") StudentEnq enq, HttpServletRequest req, Model model) {
		 HttpSession session = req.getSession(false);
		    Object object = session.getAttribute("cid");
		      int id=         (Integer)object;
		      enq.setCid(id);
		        boolean addEnq = service.addEnq(enq);
		        if(addEnq) {
		        	model.addAttribute("smsg", "enquiry added");
		        }
		        else {
		        	model.addAttribute("fmsg", "failed to add Enquiry");
		        }
		        return "Enqform";
		        
		      
		
		
	}
	@GetMapping("/getEnquiries")
	public String getAllEnquiries(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		              Object attribute = session.getAttribute("cid");
		                      int id=         (Integer)attribute;
		                      model.addAttribute("sc", new SearchCriteria());
		 List<StudentEnq> list = service.getEnquiries(id, new SearchCriteria());
		   model.addAttribute("list",list);
		   return "enq";
		
	}
	@PostMapping("/filter")
	public String filter(@ModelAttribute("sc")SearchCriteria sc, HttpServletRequest req,Model model) {
		           HttpSession session = req.getSession(false);
		                        Object attribute = session.getAttribute("cid");
		                            int id=       (Integer )attribute;
		
		       List<StudentEnq> list = service.getEnquiries(id, sc);
		       model.addAttribute("list", list);
		       return "enq";
		       
		
	}

}

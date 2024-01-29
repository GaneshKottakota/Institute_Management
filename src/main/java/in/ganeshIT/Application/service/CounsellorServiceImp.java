package in.ganeshIT.Application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ganeshIT.Application.binding.Dashboard;
import in.ganeshIT.Application.entity.Counsellor;
import in.ganeshIT.Application.entity.StudentEnq;
import in.ganeshIT.Application.repo.CounsellorRepo;
import in.ganeshIT.Application.repo.StudentEnqRepo;
@Service
public class CounsellorServiceImp implements CounsellorService {
	@Autowired
	private CounsellorRepo repo;
	@Autowired
	private StudentEnqRepo seRepo;

	@Override
	public String saveCounsellor(Counsellor counsellor) {
		Counsellor save = repo.save(counsellor);
		
			return  "registered successfully";
		
	}

	@Override
	public Counsellor loginCheck(String email, String pwd) {
		return  repo.findByEmailAndPwd(email, pwd);
		
	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dashboard dashboardResponse(Integer cid) {
		 List<StudentEnq> list = seRepo.findByCid(cid);
		    int enrolled = list.stream()
		    .filter(e->e.getEnqStatus().equals("Enrolled"))
		    .collect(Collectors.toList())
		    .size();
		    Dashboard db= new Dashboard();
		    db.setTotalEnq(list.size());
		    db.setEnrolledEnq(enrolled);
		    db.setLostEnq(list.size()-enrolled);
		    
		
		return db;
	}

}

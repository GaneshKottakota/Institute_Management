package in.ganeshIT.Application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ganeshIT.Application.binding.SearchCriteria;
import in.ganeshIT.Application.entity.StudentEnq;
import in.ganeshIT.Application.repo.StudentEnqRepo;
@Service
public class EnqServiceImpl implements EnqService {
	@Autowired
	StudentEnqRepo steRepo;

	@Override
	public boolean addEnq(StudentEnq se) {
		  StudentEnq enq = steRepo.save(se);
		         
		
		return enq.getCid()!=null;
	}

	@Override
	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria sc) {
		List<StudentEnq> list = steRepo.findByCid(cid);
		 StudentEnq se= new StudentEnq();
		 se.setCid(cid);
		 
		 if(sc.getMode()!=null&&!sc.getMode().equals("")){
			 se.setClassMode(sc.getMode());
		 }
		 if(sc.getCourseName()!=null&&!sc.getCourseName().equals("")){
			 se.setCourseName(sc.getCourseName());
		 }
		 if(sc.getEnqStatus()!=null&&!sc.getEnqStatus().equals("")){
			 se.setEnqStatus(sc.getEnqStatus());
		 }
		                Example<StudentEnq> of = Example.of(se);
		                List<StudentEnq> findAll = steRepo.findAll(of);
            
		return  findAll ;
	}

}

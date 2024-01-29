package in.ganeshIT.Application.service;

import java.util.List;

import in.ganeshIT.Application.binding.SearchCriteria;
import in.ganeshIT.Application.entity.StudentEnq;

public interface EnqService {
	public   boolean addEnq(StudentEnq se);
	public  List<StudentEnq> getEnquiries(Integer cid,SearchCriteria s);

}

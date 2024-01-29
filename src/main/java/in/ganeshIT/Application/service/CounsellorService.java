package in.ganeshIT.Application.service;

import in.ganeshIT.Application.binding.Dashboard;
import in.ganeshIT.Application.entity.Counsellor;

public interface CounsellorService {
	 public   String saveCounsellor(Counsellor counsellor);
	 public  Counsellor loginCheck(String email,String pwd);
	 public boolean recoverPwd(String email);
	 public Dashboard dashboardResponse(Integer cid);
	 

}

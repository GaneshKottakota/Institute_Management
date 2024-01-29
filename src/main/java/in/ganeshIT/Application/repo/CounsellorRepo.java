package in.ganeshIT.Application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ganeshIT.Application.entity.Counsellor;
@Repository
public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	public Counsellor findByEmailAndPwd(String email,String pwd);
	

}

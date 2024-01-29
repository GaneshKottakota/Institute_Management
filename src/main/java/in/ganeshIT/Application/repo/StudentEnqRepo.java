package in.ganeshIT.Application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ganeshIT.Application.entity.StudentEnq;
@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnq, Integer> {
  public List<StudentEnq> findByCid( Integer cid);
}

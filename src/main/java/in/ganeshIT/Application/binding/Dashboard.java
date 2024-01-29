package in.ganeshIT.Application.binding;

public class Dashboard {
	private Integer totalEnq;
	private Integer enrolledEnq;
	private Integer lostEnq;
	public Integer getTotalEnq() {
		return totalEnq;
	}
	public void setTotalEnq(Integer totalEnq) {
		this.totalEnq = totalEnq;
	}
	public Integer getEnrolledEnq() {
		return enrolledEnq;
	}
	public void setEnrolledEnq(Integer enrolledEnq) {
		this.enrolledEnq = enrolledEnq;
	}
	public Integer getLostEnq() {
		return lostEnq;
	}
	public void setLostEnq(Integer lostEnq) {
		this.lostEnq = lostEnq;
	}
	public Dashboard(Integer totalEnq, Integer enrolledEnq, Integer lostEnq) {
		super();
		this.totalEnq = totalEnq;
		this.enrolledEnq = enrolledEnq;
		this.lostEnq = lostEnq;
	}
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dashboard [totalEnq=" + totalEnq + ", enrolledEnq=" + enrolledEnq + ", lostEnq=" + lostEnq + "]";
	}
	

}

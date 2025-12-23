package com.Practice.sarat.java8;


public class Department1 {
	private String deptName;
    private String deptGrp;
    
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptGrp() {
		return deptGrp;
	}
	public void setDeptGrp(String deptGrp) {
		this.deptGrp = deptGrp;
	}
	public Department1(String deptName, String deptGrp) {
		super();
		this.deptName = deptName;
		this.deptGrp = deptGrp;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptGrp=" + deptGrp + "]";
	}

    @Override
    public int hashCode() {
 
        return this.deptName.length() + this.deptGrp.length();
    }

    @Override
    public boolean equals(Object obj) {
 
    	Department1 other = (Department1) obj;
 
        if (other.getDeptName().equals(this.deptName) && other.getDeptGrp().equals(this.deptGrp))
            return true;
        return false;
    }
}
package com.insurance.insuranceCompany.model;

public class Disease {
	long disc_id ;
    String disc_name;
    String disc_icdcode ;
    String disc_desc ;
    String disc_status ;
    
    
    public Disease() {
    	
    }
	public Disease(int disc_id, String disc_name, String disc_icdcode, String disc_desc, String disc_status) {
		super();
		this.disc_id = disc_id;
		this.disc_name = disc_name;
		this.disc_icdcode = disc_icdcode;
		this.disc_desc = disc_desc;
		this.disc_status = disc_status;
	}
	@Override
	public String toString() {
		return "Disease [disc_id=" + disc_id + ", disc_name=" + disc_name + ", disc_icdcode=" + disc_icdcode
				+ ", disc_desc=" + disc_desc + ", disc_status=" + disc_status + "]";
	}
	public long getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(long disc_id) {
		this.disc_id = disc_id;
	}
	public String getDisc_name() {
		return disc_name;
	}
	public void setDisc_name(String disc_name) {
		this.disc_name = disc_name;
	}
	public String getDisc_icdcode() {
		return disc_icdcode;
	}
	public void setDisc_icdcode(String disc_icdcode) {
		this.disc_icdcode = disc_icdcode;
	}
	public String getDisc_desc() {
		return disc_desc;
	}
	public void setDisc_desc(String disc_desc) {
		this.disc_desc = disc_desc;
	}
	public String getDisc_status() {
		return disc_status;
	}
	public void setDisc_status(String disc_status) {
		this.disc_status = disc_status;
	}
    
}

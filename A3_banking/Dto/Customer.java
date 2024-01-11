package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// javax.xml.crypto.Data;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//here the annodetion start randomly
	int cid;
	
	String name;
	
	String pwd;
	
	long mob;
	
	String Email;
	
	String grnder;
	
	Date date;
	@OneToMany
	List<Bank_account> bankacconts;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGrnder() {
		return grnder;
	}
	public void setGrnder(String grnder) {
		this.grnder = grnder;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Bank_account> getBankacconts() {
		return bankacconts;
	}
	public void setBankacconts(List<Bank_account> bankacconts) {
		this.bankacconts = bankacconts;
	}


}

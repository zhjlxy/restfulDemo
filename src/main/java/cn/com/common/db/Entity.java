package cn.com.common.db;


import java.io.Serializable;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public interface Entity extends Serializable{
	public Serializable getId() ;
}

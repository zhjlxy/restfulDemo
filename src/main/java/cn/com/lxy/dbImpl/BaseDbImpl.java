package cn.com.lxy.dbImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.com.lxy.entry.Book;

public class BaseDbImpl {
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	 /**
     * 
     * @return session
     */
    public Session getSession() {
        //需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	public List<Book> query(){
		return this.getSession().createQuery("select * from Book").list();
	}
}

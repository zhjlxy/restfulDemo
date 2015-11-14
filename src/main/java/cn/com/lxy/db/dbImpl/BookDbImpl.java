package cn.com.lxy.db.dbImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import cn.com.common.db.BaseHibernateDaoSupport;
import cn.com.lxy.entry.dto.Book;

@Component
public class BookDbImpl  extends BaseHibernateDaoSupport<Book>{
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 根据Id查询
	 * @param id 书的Id
	 * @return
	 */
	public Book queryById(int id){
		String sql = "from Book where id=?";
		
		@SuppressWarnings("unchecked")
		List<Book> result =this.list(new Object[]{id,sql});
		return result.get(0);
	}
}

package cn.com.lxy.dbImpl;

import java.util.List;

import cn.com.lxy.entry.Book;

public class BookDbImpl  extends BaseDbImpl{

	public Book queryById(String id) {
		String sql ="from Book where id = %s";
		
		@SuppressWarnings("unchecked")
		List<Book> list = this.getSession().createQuery(String.format(sql, id)).list();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}

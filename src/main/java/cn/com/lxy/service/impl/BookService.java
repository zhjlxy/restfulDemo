package cn.com.lxy.service.impl;

import javax.annotation.Resource;

import cn.com.lxy.db.dbImpl.BookDbImpl;
import cn.com.lxy.entry.dto.Book;

public class BookService {

	@Resource
	public BookDbImpl bookDbImpl;
	
	public Book queryById(String id) {
		return bookDbImpl.queryById(Integer.parseInt(id));
	}

}

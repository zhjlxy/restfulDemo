package cn.com.lxy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.lxy.dbImpl.BookDbImpl;
import cn.com.lxy.entry.Book;

@Service
public class BookService {

	@Resource
	public BookDbImpl bookDbImpl;
	public Book queryById(String id) {
		return bookDbImpl.queryById(id);
	}

}

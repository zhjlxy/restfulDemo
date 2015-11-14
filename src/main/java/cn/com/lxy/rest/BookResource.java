package cn.com.lxy.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.lxy.entry.dto.Book;
import cn.com.lxy.service.impl.BookService;

import com.alibaba.fastjson.JSONObject;

@Path("book")
@Component
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response queryById(@PathParam("id") String id){
		Book book = bookService.queryById(id);
		String response = JSONObject.toJSONString(book);
		return  Response.status(200).entity(response).build();
	}
	
}

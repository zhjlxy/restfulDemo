package cn.com.lxy.rest;


import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.com.lxy.entry.Book;
import cn.com.lxy.service.BookService;

@Path("book")
@Component
public class BookResource {
	
	@Resource
	private BookService bookService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response queryById(@PathParam("id")String  id){
		Book book = bookService.queryById(id);
		String response = JSONObject.toJSONString(book);
		return  Response.status(200).entity(response).build();
	}
	
}

package com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.book.bean.Book;
import com.book.dao.BookDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/com/book/resource/Beans.xml");
        BookDao bd=(BookDao)ctx.getBean("bdao");
        Book b=new Book();
        b.setBid(4);
        b.setBname("spring");
        bd.saveBook(b);
    }
}

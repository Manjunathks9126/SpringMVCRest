package com.boraji.tutorial.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.exception.BookBadRequestException;
import com.boraji.tutorial.spring.exception.BookNotFoundException;
import com.boraji.tutorial.spring.model.Book;

@Repository
public class BookDaoImp implements BookDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Book book) {
      sessionFactory.getCurrentSession().save(book);
      return book.getId();
   }

   @Override
   public Book get(long id) {
      return sessionFactory.getCurrentSession().get(Book.class, id);
   }

   @Override
   public List<Book> list() {
      Session session = sessionFactory.getCurrentSession();
//      CriteriaBuilder cb = session.getCriteriaBuilder();
//      CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//      Root<Book> root = cq.from(Book.class);
//      cq.select(root);
//      Query<Book> query = session.createQuery(cq);
      
     // return query.getResultList();
      return session.createQuery("from Book").list();
   }

   @Override
   public void update(long id, Book book) {
      Session session = sessionFactory.getCurrentSession();
      Book book2 = session.byId(Book.class).load(id);
      System.out.println("book2:"+book2);
      if(book2==null) {
    	  throw new BookNotFoundException("book with id:"+id+" not found");
      }
      if(book.getAuthor()==null) {
    	  throw new BookBadRequestException("book authorName should not be Null");
      }
      BeanUtils.copyProperties(book, book2, getNullPropertyNames(book));
      sessionFactory.getCurrentSession().update(book2);
      session.flush();
   }

  
@Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Book book = session.byId(Book.class).load(id);
      session.delete(book);
   }
   
   
private String[] getNullPropertyNames(Object source) {
	   final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> returnValues = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) returnValues.add(pd.getName());
	    }
	    String[] result = new String[returnValues.size()];
	    return returnValues.toArray(result);
	
}


}

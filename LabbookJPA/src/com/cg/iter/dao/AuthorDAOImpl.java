//package com.cg.iter.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import com.cg.iter.bean.Author;
//
//public class AuthorDAOImpl implements AuthorDAO{
//
//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
//	EntityManager manager = factory.createEntityManager();
//	
//
//	@Override
//	public boolean addAuthor(Author author) {
//		try {
//			manager.getTransaction().begin();
//			manager.persist(author);
//			manager.getTransaction().commit();
//			return true;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public boolean deleteAuthor(Author author) {
//		try {
//			manager.remove(author);
//			return true;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	
//	@Override
//	public Author updateAuthor(Author author) {
//		try {
//			Author temp = findAuthor(author.getAuthorId());
//			temp.setFirstName(author.getFirstName());
//			temp.setLastName(author.getLastName());
//			temp.setMiddleName(author.getMiddleName());
//			temp.setPhoneNo(author.getPhoneNo());
//			return temp;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//
//	
//	@Override
//	public Author findAuthor(Integer id) {
//		return manager.find(Author.class, id);
//	}
//
//}

package com.cg.iter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.iter.bean.Author;
import com.cg.iter.util.JpaUtil;

public class AuthorDAOImpl implements AuthorDAO {

EntityManager em = JpaUtil.getEntityManager();
EntityTransaction et = em.getTransaction();

@Override
public boolean addAuthor(Author author) {
try {
//EntityManager em = JpaUtil.getEntityManager();

em.getTransaction().begin();
em.persist(author);
em.getTransaction().commit();
return true;

} catch (Exception e) {
e.printStackTrace();
return false;
}
}

@Override
public Author findAuthor(int id) {

return em.find(Author.class, id);
}

@Override
public Author updateAuthor(Author author) {
try {
Author temp = findAuthor(author.getAuthorId());

temp.setFirstName(author.getFirstName());
temp.setLastName(author.getLastName());
temp.setMiddleName(author.getMiddleName());
temp.setPhoneNo(author.getPhoneNo());

et.begin();
em.merge(temp);
et.commit();

return temp;

}catch(Exception e) {
e.printStackTrace();
return null;
}
}

@Override
public boolean deleteAuthor(int id) {
try {
Author author = findAuthor(id);
et.begin();
em.remove(author);
et.commit();
return true;
} catch (Exception e) {
e.printStackTrace();
return false;
}
}



}



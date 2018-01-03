/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.test;


import com.eduza.member.jpa.pojo.UserProfile;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jeasydev
 */
//@PropertySource(value = { "classpath:application.properties" })
@Controller
//@Repository
//@Transactional
@Transactional
@Repository("userProfile")
public class HomeController {

    @Autowired
    private SessionFactory sessionFactory;
//    @PersistenceContext(unitName = "testP")
//    private EntityManager em;
//    
//    
//    private UserTransaction utx;
//    public void setUserTransaction(UserTransaction utx) {
//        this.utx = utx;
//    }
//    public TestServiceImpl() throws Exception{
//        throw new Exception("xxx");
//    }
    //Inject by blueprint
//    public void setEntityManager(EntityManager em) throws NamingException {
//        this.em = em;
//    }
    private static final Logger logger = Logger.getLogger(HomeController.class);
//    @Autowired
//    EntityManager em;

    @RequestMapping("/")
    public String index() {

//        Query query = sessionFactory.getCurrentSession().createQuery("from UserProfile as user where user.id = :id ");
//        query.setParameter("id", "1");
//        List list = query.list();
        UserProfile user = (UserProfile) sessionFactory.getCurrentSession().get(UserProfile.class, 1L);
        logger.warn("TestObject: " + user.getUsername());

// List<Film> filmList = null;
        //    try {
        //        org.hibernate.Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        //        Query q  = sessionFactory.getCurrentSession().createQuery("from UserProfile as user where user.id = 1");
        //        
        //        logger.warn("TestObject: " + q.list().get(0));
        //Query q = session.createQuery ("from Film as film where film.filmId between '"+startID+"' and '"+endID+"'");
        //        filmList = (List<Film>) q.list();
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //    }
        //        Criteria c = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
        //        c.add(Restrictions.eq("ID", 1));
        //        UserProfile user = (UserProfile) c.uniqueResult();
        //         logger.info("TestLog : " + user.getFirstName());
        // UserProfile user = new UserProfile(1, "userA", "pw", "ss", "f", "m", "e", true, true);
        // try {
        //utx.begin();
        // em.persist(user);
        //utx.commit();
        // } catch (NotSupportedException | SystemException | HeuristicMixedException | HeuristicRollbackException | IllegalStateException | RollbackException | SecurityException ex) {
        // java.util.logging.Logger.getLogger(TestServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        //  logger.warn("CommintError", ex);
        //  try {
        //     utx.rollback();
        // } catch (IllegalStateException | SecurityException | SystemException ex1) {
        //     logger.warn("CommintError2", ex1);
        //     //java.util.logging.Logger.getLogger(TestServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
        //}
        // }
        //        logger.info("Inside getAllIssuers() method...");
        return "index";

    }

}

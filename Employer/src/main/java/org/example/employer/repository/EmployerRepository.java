package org.example.employer.repository;

import org.example.employer.model.Employer;
import org.example.employer.service.EmployerService;
import org.hibernate.Transaction;

import java.util.List;

public class EmployerRepository extends BaseRepository<Employer>{

    public EmployerRepository(){super();}

    @Override
    public Employer add(Employer entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public Employer finfById(long id) {
        Employer employer = null;

        try {
            session = sessionFactory.openSession();
            employer = session.get(Employer.class,id);
            if (employer == null){
                throw new Exception("Employer not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employer;
    }

    @Override
    public List<Employer> findALl() {

        List<Employer> employer = null;

        try {
            session = sessionFactory.openSession();
            employer = session.createQuery("from Employer ").list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employer;

    }


    @Override
    public Employer update(Employer entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public boolean delete(Employer entity) {
        Transaction transaction = null;
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return result;
    }
}

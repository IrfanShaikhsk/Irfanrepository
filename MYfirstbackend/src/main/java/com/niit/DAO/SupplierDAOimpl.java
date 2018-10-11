package com.niit.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
import com.niit.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOimpl implements SupplierDAO {
@Autowired
SessionFactory sessionFactory;
	public boolean addSupplier(Supplier suplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(suplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		e.printStackTrace();
		return false;
		}
		}

	public boolean deleteSupplier(Supplier suplier) {
		try
		{
		sessionFactory.getCurrentSession().delete(suplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		e.printStackTrace();
		return false;
		}}

	public boolean updateSupplier(Supplier suplier) {
		try
		{
		sessionFactory.getCurrentSession().update(suplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		e.printStackTrace();
		return false;
		}}

	public Supplier getsupplier(int suppid) {
		
		Session session=sessionFactory.openSession();
		Supplier suplier=(Supplier)session.get(Supplier.class ,suppid);
			
		session.close();
		return suplier;
	}

	public List<Supplier> listSupplier() {
		
		return null;
	}

	public List<Supplier> listSupplierbyCategory(int catid) {
	
		return null;
	}

}

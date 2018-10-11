package com.niit.MYfirstbackend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOtestcase {
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
			
	}
@Test
	public void addsupp()
	{
		
		Supplier suplier =new Supplier();
		suplier.setCatid(1);
		suplier.setSuppliername("1st supplier");
		assertTrue(supplierDAO.addSupplier(suplier));
	}
@Ignore
@Test
public void deletesupplierTestCase()
{
	Supplier suplier=supplierDAO.getsupplier(97);
	assertTrue(supplierDAO.deleteSupplier(suplier));
}
@Ignore
@Test
public void updatesupplierTestcase()
{
	Supplier suplier=supplierDAO.getsupplier(97);
	suplier.setSuppliername("Updated supplier");
	assertTrue(supplierDAO.updateSupplier(suplier));
 }
@Ignore
@Test
public void getlistsupplier()
{
	List<Supplier> listsupplier=supplierDAO.listSupplier();
	
			assertNotNull(supplierDAO.listSupplier());
}

}

package com.niit.DAO;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier suplier);
	public boolean deleteSupplier(Supplier suplier);
	public boolean updateSupplier(Supplier suplier);
	
	public Supplier getsupplier(int suppid);
	public List<Supplier> listSupplier();
	public List<Supplier> listSupplierbyCategory(int catid);
}

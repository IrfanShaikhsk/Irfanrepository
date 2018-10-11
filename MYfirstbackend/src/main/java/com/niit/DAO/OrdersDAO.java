package com.niit.DAO;

import com.niit.model.Orders;

public interface OrdersDAO
{
	public boolean receiptGenerate(Orders order);
	public boolean updateCartItemStatus(String username);
}

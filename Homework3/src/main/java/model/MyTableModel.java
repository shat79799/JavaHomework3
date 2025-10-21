package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import service.impl.MyOrderServiceImpl;
import util.Tool;

public class MyTableModel extends AbstractTableModel {
	
	List<MyOrder> allOrder = new MyOrderServiceImpl().readAllOrder();

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return allOrder.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Tool.getColumnNames().length;
	}

	@Override
	public String getColumnName(int column) {
		return Tool.getColumnNames()[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		MyOrder o = allOrder.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return o.getId();
		case 1: 
			return o.getBlackTea();
		case 2:
			return o.getGreenTea();
		case 3:
			return o.getOolongTea();
		case 4:
			return o.getMilkTea();
		case 5:
			return o.getTotal();
		case 6:
			return o.getPayType();
		case 7:
			return o.getUserId();
		default:
			return null;
		}
	}

}

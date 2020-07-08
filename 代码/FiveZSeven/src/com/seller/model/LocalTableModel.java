package com.seller.model;

import javax.swing.table.DefaultTableModel;

public class LocalTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	Class[] types = new Class[] { java.lang.Object.class, java.lang.String.class, 
			java.lang.String.class,java.lang.String.class,java.lang.String.class,
			java.lang.String.class,java.lang.String.class,java.lang.String.class,
			java.lang.String.class,java.lang.String.class,java.lang.String.class };
	boolean[] canEdit=new boolean[] {false,false,false,false,false,false,false,false,
			false,false,false};
	public LocalTableModel() {
		super(new Object[][] {},new String[] {"���", "�ͻ�����", "��ַ", "��ϵ��", "��ϵ�绰", "����", "�ʱ�", "�����˺�", "��ַ", "EMail", "��ע"});
	}
	
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}

}

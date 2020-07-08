package com.daoimpl;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Goods;
import com.dao.GoodsDao;

public class GoodsDaoImpl extends GenericDaoImpl<Goods, Integer> implements GoodsDao{

	private static final long serialVersionUID = 1L;

	public GoodsDaoImpl() throws RemoteException {
		super();
	}

	@Override
	protected Object[] getObjects(Goods t) {
		return new Object[] {t.getId(),t.getWareName(),t.getWareBewrite(),t.getSpec(),t.getStockPrice(),
				t.getRetallPrice(),t.getAssoclatorPrice()};
	}

	@Override
	protected Goods getObject(ResultSet rs) throws SQLException {
		Goods t = new Goods();
		t.setId(rs.getInt("id"));
		t.setWareName(rs.getString("wareName"));
		t.setWareBewrite(rs.getString("wareBewrite"));
		t.setSpec(rs.getString("spec"));
		t.setStockPrice(rs.getFloat("stockPrice"));
		t.setRetallPrice(rs.getFloat("retallPrice"));
		t.setAssoclatorPrice(rs.getFloat("assoclatorPrice"));
		return t;
	}
	//��return null�޸�Ϊʵ�ֲ����Ĵ���
	@Override
	protected String getInsertSQL() {
		return "insert into tb_goods(id,wareName,wareBewrite,spec,fax,stockPrice,retallPrice,assoclatorPrice) values(?,?,?,?,?,?,?,?)";
	}

	@Override
	protected String getListSQL() {
		return "select * from tb_goods";
	}

	@Override
	protected String getSelectByIdSQL(Integer id) {
		return "select * from tb_goods where id="+id;
	}

	@Override
	protected String getSearchSQL(Goods t) {
		StringBuffer sql = new StringBuffer("select * from tb_goods where 1=1");
		if(t.getWareName()!=null && !"".equals(t.getWareName())) {
			sql.append(" and wareName like '%"+t.getWareName()+"%'");
		}
		return sql.toString();
	}

	@Override
	protected String getUpdateSQL() {
		return "update tb_goods set wareName=?,wareBewrite=?,spec=?,fax=?,stockPrice=?,retallPrice=?,assoclatorPrice=? where id=?";
	}

	@Override
	protected String getDeleteSQL(Integer id) {
		return "delete from tb_goods where id="+id;
	}

}

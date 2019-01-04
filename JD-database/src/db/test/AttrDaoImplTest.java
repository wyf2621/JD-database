package db.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import db.dao.AttrDao;
import db.dao.AttrDaoImpl;
import db.entity.Attr;


public class AttrDaoImplTest {


	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindAll() {
		System.out.println("列出所有商品属性信息");
		AttrDao dao = new AttrDaoImpl();
		List<Attr> attr = dao.findAll();
		for(int i = 0; i < attr.size(); i++) {
			Attr a = attr.get(i);
			System.out.println(a.getAttr_id()+" "+a.getAttr_name());
		}
		System.out.println("列出所有商品属性信息成功!");
	}

	@Test
	public void testFindByID() {
		System.out.println("通过商品属性ID输出一行信息");
		AttrDao dao = new AttrDaoImpl();
		int i=13;
		Attr a = dao.findByID(i);
		//测试是否找到该属性ID
		if(a == null) {
			System.out.println("没有属性ID为 "+i+" 的属性信息");
		}
		else {
			System.out.println("查找属性ID为"+" 的一行属性信息成功!");}
	}

	@Test
	public void testSave() {
		System.out.println("增加商品属性信息");
		int i=18;
		int j=19;
		AttrDao dao = new AttrDaoImpl();
		Attr a1=dao.findByID(i);
		Attr a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该属性ID!");
		}
		else {
			Attr attr = new Attr();
			attr.setAttr_id(i);
			attr.setAttr_name("abc");
			dao.save(attr);
			attr.setAttr_id(j);
			attr.setAttr_name("abc");
			dao.save(attr);
			//验证是否增加属性信息成功
			Attr a = dao.findByID(i);
			Attr b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加属性ID为 "+i+" 和 "+j+" 的属性信息成功!");
			}
		}
	}

	

	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=18;
		AttrDao dao = new AttrDaoImpl();
		Attr attr=dao.findByID(i);
		//判断该属性ID是否存在
		if(attr==null) {
			System.out.println("Find Error!");
		}
		else {
			attr.setAttr_name("change");
			dao.update(attr);
			//验证是否更新属性信息成功
			Attr a = dao.findByID(i);
			if(!a.getAttr_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新商品ID为"+i+" 的属性信息成功!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("删除一行指定商品属性ID信息");
		int i=19;
		AttrDao dao = new AttrDaoImpl();
		Attr attr= dao.findByID(i);
		if(attr!=null) {
			try {
				dao.delete(attr);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除属性信息成功
		Attr a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除商品ID为 "+i+" 的属性信息成功!");
		}
	}

}

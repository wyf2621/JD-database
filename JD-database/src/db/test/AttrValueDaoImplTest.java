package db.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import db.dao.AttrValueDao;
import db.dao.AttrValueDaoImpl;
import db.entity.AttrValue;

public class AttrValueDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByID() {
		System.out.println("通过属性值ID输出一行信息");
		AttrValueDao dao = new AttrValueDaoImpl();
		int i=1;
		AttrValue a = dao.findByID(i);
		//测试是否找到该属性值ID
		if(a == null) {
			System.out.println("没有属性值ID为 "+i+" 的属性值信息");
		}
		else {
			System.out.println("查找属性值ID为"+i+" 的一行信息成功!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("列出所有商品属性值信息");
		AttrValueDao dao = new AttrValueDaoImpl();
		List<AttrValue> attrva = dao.findAll();
		for(int i = 0; i < attrva.size(); i++) {
			AttrValue a = attrva.get(i);
			System.out.println(a.getAttr_value_id()+" "+a.getAttr_attr_id()+" "+a.getAttr_value_name());
		}
		System.out.println("列出所有属性值信息成功!");
	}

	@Test
	public void testFindByAttrID() {
		System.out.println("通过查找属性ID输出所有属性值信息");
		AttrValueDao dao = new AttrValueDaoImpl();
		int i=1;
		List<AttrValue> attrva = dao.findByAttrID(i);
		for(int j = 0; j < attrva.size(); j++) {
			AttrValue a = attrva.get(j);
			System.out.println(a.getAttr_value_id()+" "+a.getAttr_attr_id()+" "+a.getAttr_value_name());}
		System.out.println("查找属性ID为"+i+" 的所有属性值信息成功!");
	}

	@Test
	public void testSave() {
		System.out.println("增加属性值信息");
		int i=18;
		int j=19;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue a1=dao.findByID(i);
		AttrValue a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("已经存在该属性值ID!");
		}
		else {
			AttrValue attrva = new AttrValue();
			attrva.setAttr_value_id(i);
			attrva.setAttr_attr_id(1);
			attrva.setAttr_value_name("abc");
			dao.save(attrva);
			attrva.setAttr_value_id(j);
			attrva.setAttr_attr_id(1);
			attrva.setAttr_value_name("abc");
			dao.save(attrva);
			//验证是否增加属性值信息成功
			AttrValue a = dao.findByID(i);
			AttrValue b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("增加属性值ID为 "+i+" 和 "+j+" 的信息成功!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("删除一行指定属性值ID信息");
		int i=18;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue attrva= dao.findByID(i);
		if(attrva!=null) {
			try {
				dao.delete(attrva);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//验证是否删除属性值信息成功
		AttrValue a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("删除属性值ID为 "+i+" 的信息成功!");
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("更新一行信息某列元素");
		int i=1;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue attrva=dao.findByID(i);
		//判断该属性值ID是否存在
		if(attrva==null) {
			System.out.println("Find Error!");
		}
		else {
			attrva.setAttr_value_name("CHANGE");
			dao.update(attrva);
			//验证是否更新属性值信息成功
			AttrValue a = dao.findByID(i);
			if(!a.getAttr_value_name().equals("CHANGE")) {
				System.out.println("Update Error!");
			}
			System.out.println("更新属性值ID为"+i+" 的信息成功!");
		}
	}
}

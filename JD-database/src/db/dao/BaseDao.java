package db.dao;

public interface BaseDao {
	
	/**
	 * TODO 保存对象到数据库
	 * @param obj 需要保存的对象
	 */
	public void save(Object obj);
	
	/**
	 * TODO 从数据库中删除某一对象
	 * @param obj 需要删除的对象
	 */
	public void delete(Object obj);
	
	/**
	 * TODO 更新数据库中的某个对象
	 * @param obj 需要更新的记录
	 */
	public void update(Object obj);
	
	
}

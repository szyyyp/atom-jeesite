/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.ConfigDAO;

import java.util.Map;
import com.github.obullxl.jeesite.dal.dto.ConfigDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.ConfigDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Sun Jan 05 12:58:45 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisConfigDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements ConfigDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>ConfigDTO</tt> object to DB table <tt>atom_config</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_config(id,catg,name,state,value,cvalue,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param config
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(ConfigDTO config) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.insert");
	try {
    	if (config == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            config.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-CONFIG.insert", config);

        return config.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>atom_config</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_config set state='STATE', value='VALUE', cvalue='CVALUE', gmt_modify='NOW' where ((catg = 'CATG') AND (name = 'NAME'))</tt>
	 *
	 *	@param catg
	 *	@param name
	 *	@param state
	 *	@param value
	 *	@param cvalue
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(String catg, String name, String state, String value, String cvalue) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.update");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("name", name);
        param.put("state", state);
        param.put("value", value);
        param.put("cvalue", cvalue);

        return this.getSqlSession().update("ATOM-CONFIG.update", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_config</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_config where ((catg = ?) AND (name = ?))</tt>
	 *
	 *	@param catg
	 *	@param name
	 *	@return ConfigDTO
	 *	@throws DataAccessException
	 */	 
    public ConfigDTO find(String catg, String name) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.find");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("name", name);

        return this.getSqlSession().selectOne("ATOM-CONFIG.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_config</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_config where (catg = ?)</tt>
	 *
	 *	@param catg
	 *	@return List<ConfigDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ConfigDTO> findCatg(String catg) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.findCatg");
	try {

        return this.getSqlSession().selectList("ATOM-CONFIG.findCatg", catg);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_config</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_config</tt>
	 *
	 *	@return List<ConfigDTO>
	 *	@throws DataAccessException
	 */	 
    public List<ConfigDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-CONFIG.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_config</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_config where ((catg = ?) AND (name = ?))</tt>
	 *
	 *	@param catg
	 *	@param name
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String catg, String name) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.delete");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("catg", catg);
        param.put("name", name);

        return this.getSqlSession().delete("ATOM-CONFIG.delete", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_config</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_config where (id >= 0)</tt>
	 *
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CONFIG.deleteAll");
	try {

        return this.getSqlSession().delete("ATOM-CONFIG.deleteAll", null);
	} finally {
		Profiler.release();
	}
}
}
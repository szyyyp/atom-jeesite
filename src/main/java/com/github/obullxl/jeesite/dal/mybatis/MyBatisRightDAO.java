/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.RightDAO;

import com.github.obullxl.jeesite.dal.dto.RightDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.RightDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Sat Jan 11 15:35:31 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisRightDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements RightDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>RightDTO</tt> object to DB table <tt>atom_right</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_right(id,code,name,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param right
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(RightDTO right) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.insert");
	try {
    	if (right == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            right.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-RIGHT.insert", right);

        return right.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Query DB table <tt>atom_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_right where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return RightDTO
	 *	@throws DataAccessException
	 */	 
    public RightDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-RIGHT.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_right where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return RightDTO
	 *	@throws DataAccessException
	 */	 
    public RightDTO findCode(String code) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.findCode");
	try {

        return this.getSqlSession().selectOne("ATOM-RIGHT.findCode", code);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_right order by code ASC</tt>
	 *
	 *	@return List<RightDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RightDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-RIGHT.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_right</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_right where (code = 'user-rgt-codes')</tt>
	 *
	 *	@param value
	 *	@return List<RightDTO>
	 *	@throws DataAccessException
	 */	 
    public List<RightDTO> findUserRgts(String value) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.findUserRgts");
	try {

        return this.getSqlSession().selectList("ATOM-RIGHT.findUserRgts", value);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Update DB table <tt>atom_right</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_right set code=?, name=? where (code = ?)</tt>
	 *
	 *	@param right
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(RightDTO right) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.update");
	try {
    	if (right == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-RIGHT.update", right);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_right</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_right where (code = ?)</tt>
	 *
	 *	@param code
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String code) throws DataAccessException{
	Profiler.enter("DAO: ATOM-RIGHT.delete");
	try {

        return this.getSqlSession().delete("ATOM-RIGHT.delete", code);
	} finally {
		Profiler.release();
	}
}
}

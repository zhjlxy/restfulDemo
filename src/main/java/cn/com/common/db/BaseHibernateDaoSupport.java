package cn.com.common.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseHibernateDaoSupport<T> extends HibernateDaoSupport {
	
	public Object getCache(Serializable id) {
		getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().get(id.getClass(), id);
	}
	
	

	@SuppressWarnings("rawtypes")
	public List list(Object[] arguments) {
		int len = arguments.length;
		if(len > 1){
			Object sql = arguments[len -1];
			arguments[len -1] = null;
			Object args[] = new Object[len -1];
			for(int i = 0; i < len -1; i++){
				args[i] = arguments[i];
			}
			return getHibernateTemplate().find(sql.toString(), args);
		}else{
			return getHibernateTemplate().find((String)arguments[0]);
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public List list(final Object[] arguments, boolean sql,final Class entityClass) {
		if(sql){
			return getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException {
					SQLQuery query = null;
					
					int len = arguments.length;
					if(len > 1){
						Object sql = arguments[len -1];
						arguments[len -1] = null;
						Object args[] = new Object[len -1];
						query =  session.createSQLQuery(sql.toString());
						query.setResultTransformer(new AliasToBeanResultTransformer(entityClass));
						for(int i = 0; i < len -1; i++){
							args[i] = arguments[i];
							query.setParameter(i, args[i]);
						}
						
					}else{
						query = session.createSQLQuery((String)arguments[0]);
						query.setResultTransformer(new AliasToBeanResultTransformer(entityClass));
					}
					
					return query.list();
				}
			});
		}else{
			return this.list(arguments);
		}
	}

	public void save(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	public void update(T t){
		getHibernateTemplate().update(t);
	}
	
}
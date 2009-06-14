package Project.Server.Database;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccountIdCourseId entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Project.Server.Database.AccountIdCourseId
 * @author MyEclipse Persistence Tools
 */

public class AccountIdCourseIdDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(AccountIdCourseIdDAO.class);
	// property constants
	public static final String ACCOUNT_ID = "accountId";
	public static final String COURSE_ID = "courseId";

	public void save(AccountIdCourseId transientInstance) {
		log.debug("saving AccountIdCourseId instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AccountIdCourseId persistentInstance) {
		log.debug("deleting AccountIdCourseId instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccountIdCourseId findById(java.lang.String id) {
		log.debug("getting AccountIdCourseId instance with id: " + id);
		try {
			AccountIdCourseId instance = (AccountIdCourseId) getSession().get(
					"Project.Server.Database.AccountIdCourseId", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AccountIdCourseId instance) {
		log.debug("finding AccountIdCourseId instance by example");
		try {
			List results = getSession().createCriteria(
					"Project.Server.Database.AccountIdCourseId").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AccountIdCourseId instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AccountIdCourseId as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccountId(Object accountId) {
		return findByProperty(ACCOUNT_ID, accountId);
	}

	public List findByCourseId(Object courseId) {
		return findByProperty(COURSE_ID, courseId);
	}

	public List findAll() {
		log.debug("finding all AccountIdCourseId instances");
		try {
			String queryString = "from AccountIdCourseId";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AccountIdCourseId merge(AccountIdCourseId detachedInstance) {
		log.debug("merging AccountIdCourseId instance");
		try {
			AccountIdCourseId result = (AccountIdCourseId) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AccountIdCourseId instance) {
		log.debug("attaching dirty AccountIdCourseId instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccountIdCourseId instance) {
		log.debug("attaching clean AccountIdCourseId instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
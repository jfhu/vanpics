package Project.Server.Database;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * ActivityGroup entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Project.Server.Database.ActivityGroup
 * @author MyEclipse Persistence Tools
 */

public class ActivityGroupDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ActivityGroupDAO.class);
	// property constants
	public static final String PERCENT = "percent";
	public static final String COURSE_ID = "courseId";

	public void save(ActivityGroup transientInstance) {
		log.debug("saving ActivityGroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActivityGroup persistentInstance) {
		log.debug("deleting ActivityGroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActivityGroup findById(java.lang.String id) {
		log.debug("getting ActivityGroup instance with id: " + id);
		try {
			ActivityGroup instance = (ActivityGroup) getSession().get(
					"Project.Server.Database.ActivityGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ActivityGroup instance) {
		log.debug("finding ActivityGroup instance by example");
		try {
			List results = getSession().createCriteria(
					"Project.Server.Database.ActivityGroup").add(
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
		log.debug("finding ActivityGroup instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ActivityGroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPercent(Object percent) {
		return findByProperty(PERCENT, percent);
	}

	public List findByCourseId(Object courseId) {
		return findByProperty(COURSE_ID, courseId);
	}

	public List findAll() {
		log.debug("finding all ActivityGroup instances");
		try {
			String queryString = "from ActivityGroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ActivityGroup merge(ActivityGroup detachedInstance) {
		log.debug("merging ActivityGroup instance");
		try {
			ActivityGroup result = (ActivityGroup) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ActivityGroup instance) {
		log.debug("attaching dirty ActivityGroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActivityGroup instance) {
		log.debug("attaching clean ActivityGroup instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
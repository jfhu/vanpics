package Project.Server.Database;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * GradeId entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Project.Server.Database.GradeId
 * @author MyEclipse Persistence Tools
 */

public class GradeIdDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GradeIdDAO.class);
	// property constants
	public static final String HIGH = "high";
	public static final String LOW = "low";
	public static final String TYPE = "type";

	public void save(GradeId transientInstance) {
		log.debug("saving GradeId instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GradeId persistentInstance) {
		log.debug("deleting GradeId instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GradeId findById(java.lang.String id) {
		log.debug("getting GradeId instance with id: " + id);
		try {
			GradeId instance = (GradeId) getSession().get(
					"Project.Server.Database.GradeId", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GradeId instance) {
		log.debug("finding GradeId instance by example");
		try {
			List results = getSession().createCriteria(
					"Project.Server.Database.GradeId").add(
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
		log.debug("finding GradeId instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GradeId as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHigh(Object high) {
		return findByProperty(HIGH, high);
	}

	public List findByLow(Object low) {
		return findByProperty(LOW, low);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findAll() {
		log.debug("finding all GradeId instances");
		try {
			String queryString = "from GradeId";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GradeId merge(GradeId detachedInstance) {
		log.debug("merging GradeId instance");
		try {
			GradeId result = (GradeId) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GradeId instance) {
		log.debug("attaching dirty GradeId instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GradeId instance) {
		log.debug("attaching clean GradeId instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
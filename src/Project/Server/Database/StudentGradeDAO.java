package Project.Server.Database;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentGrade entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Project.Server.Database.StudentGrade
 * @author MyEclipse Persistence Tools
 */

public class StudentGradeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StudentGradeDAO.class);
	// property constants
	public static final String STUDENT_ID = "studentId";
	public static final String COURSE_ID = "courseId";
	public static final String ACTIVITY_ID = "activityId";
	public static final String GRADE = "grade";
	public static final String GRADE_ID = "gradeId";

	public void save(StudentGrade transientInstance) {
		log.debug("saving StudentGrade instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentGrade persistentInstance) {
		log.debug("deleting StudentGrade instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentGrade findById(java.lang.String id) {
		log.debug("getting StudentGrade instance with id: " + id);
		try {
			StudentGrade instance = (StudentGrade) getSession().get(
					"Project.Server.Database.StudentGrade", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentGrade instance) {
		log.debug("finding StudentGrade instance by example");
		try {
			List results = getSession().createCriteria(
					"Project.Server.Database.StudentGrade").add(
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
		log.debug("finding StudentGrade instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StudentGrade as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentId(Object studentId) {
		return findByProperty(STUDENT_ID, studentId);
	}

	public List findByCourseId(Object courseId) {
		return findByProperty(COURSE_ID, courseId);
	}

	public List findByActivityId(Object activityId) {
		return findByProperty(ACTIVITY_ID, activityId);
	}

	public List findByGrade(Object grade) {
		return findByProperty(GRADE, grade);
	}

	public List findByGradeId(Object gradeId) {
		return findByProperty(GRADE_ID, gradeId);
	}

	public List findAll() {
		log.debug("finding all StudentGrade instances");
		try {
			String queryString = "from StudentGrade";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentGrade merge(StudentGrade detachedInstance) {
		log.debug("merging StudentGrade instance");
		try {
			StudentGrade result = (StudentGrade) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentGrade instance) {
		log.debug("attaching dirty StudentGrade instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentGrade instance) {
		log.debug("attaching clean StudentGrade instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
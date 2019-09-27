package harshal.temkar.management.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import harshal.temkar.management.dao.AbstractDao;
import harshal.temkar.management.model.user.UserModel;

@Repository
public class UserDaoImpl extends AbstractDao<Long, UserModel> implements UserDao {

	@Override
	public void createUser(UserModel userModel) {
		save(userModel);
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		return update(userModel);
	}

	@Override
	public void deleteUser(Long id) {
		deleteById(id);
	}

	@Override
	public boolean userIsPresent(Long id) {
		return isPresent(id);
	}

	@Override
	public List<UserModel> getAllUsers() {
		return findAll();
	}

	@Override
	public UserModel getUserById(Long id) {
		return getById(id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> getActiveUsers() {
		Criteria cr = getSession().createCriteria(UserModel.class);
		cr.add(Restrictions.eq("isActive", true));
		return cr.list();
	}

	@Override
	public List<UserModel> getDeletedUsers() {
		Criteria cr = getSession().createCriteria(UserModel.class);
		cr.add(Restrictions.eq("isDeleted", true));
		return cr.list();
	}

	@Override
	public List<UserModel> getArchivedUsers() {
		Criteria cr = getSession().createCriteria(UserModel.class);
		cr.add(Restrictions.eq("isArchived", true));
		return cr.list();
	}

	@Override
	public UserModel updateActive(UserModel userModel) {
		userModel.setIsActive(true);
		userModel.setIsDeleted(false);
		userModel.setIsArchived(false);
		return update(userModel);
	}

	@Override
	public UserModel updateDelete(UserModel userModel) {
		userModel.setIsActive(false);
		userModel.setIsDeleted(true);
		userModel.setIsArchived(false);
		return update(userModel);
	}

	@Override
	public UserModel updateArchive(UserModel userModel) {
		userModel.setIsActive(false);
		userModel.setIsDeleted(false);
		userModel.setIsArchived(true);
		return update(userModel);
	}

}

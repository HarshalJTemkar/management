package harshal.temkar.management.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import harshal.temkar.management.dao.user.UserDao;
import harshal.temkar.management.model.user.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(UserModel userModel) {
		userDao.createUser(userModel);
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		return userDao.updateUser(userModel);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteUser(id);
	}

	@Override
	public boolean userIsPresent(Long id) {
		return userDao.userIsPresent(id);
	}

	@Override
	public List<UserModel> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public UserModel getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<UserModel> getActiveUsers() {
		return userDao.getActiveUsers();
	}

	@Override
	public List<UserModel> getDeletedUsers() {
		return userDao.getDeletedUsers();
	}

	@Override
	public List<UserModel> getArchivedUsers() {
		return userDao.getArchivedUsers();
	}

	@Override
	public UserModel updateActive(UserModel userModel) {
		return userDao.updateActive(userModel);
	}

	@Override
	public UserModel updateDelete(UserModel userModel) {
		return userDao.updateDelete(userModel);
	}

	@Override
	public UserModel updateArchive(UserModel userModel) {
		return userDao.updateArchive(userModel);
	}
}

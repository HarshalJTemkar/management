package harshal.temkar.management.service.user;

import java.util.List;

import harshal.temkar.management.model.user.UserModel;

public interface UserService {

	public void createUser(UserModel userModel);

	public UserModel updateUser(UserModel userModel);

	public void deleteUser(Long id);

	public boolean userIsPresent(Long id);

	public List<UserModel> getAllUsers();

	public UserModel getUserById(Long id);

	public List<UserModel> getActiveUsers();

	public List<UserModel> getDeletedUsers();

	public List<UserModel> getArchivedUsers();

	public UserModel updateActive(UserModel userModel);

	public UserModel updateDelete(UserModel userModel);

	public UserModel updateArchive(UserModel userModel);
}

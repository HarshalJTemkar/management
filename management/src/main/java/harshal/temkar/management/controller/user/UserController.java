package harshal.temkar.management.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import harshal.temkar.management.model.user.UserModel;
import harshal.temkar.management.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel, HttpServletRequest request)
			throws JsonProcessingException {
		try {
			userService.createUser(userModel);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel userModel,
			HttpServletRequest request) throws JsonProcessingException {
		try {
			UserModel currentUser = userService.getUserById(id);
			if (currentUser == null || id == null || id.equals(null) || id != userModel.getId()) {
				return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			} else {
				userService.updateUser(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@PutMapping("update_active/{id}")
	public ResponseEntity<UserModel> updateActiveUser(@PathVariable Long id, HttpServletRequest request)
			throws JsonProcessingException {
		UserModel userModel;
		try {
			userModel = userService.getUserById(id);
			if (id == null || id.equals(null)) {
				return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			} else {
				userService.updateActive(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@PutMapping("update_delete/{id}")
	public ResponseEntity<UserModel> updateDeleteUser(@PathVariable Long id, HttpServletRequest request)
			throws JsonProcessingException {
		UserModel userModel;
		try {
			userModel = userService.getUserById(id);
			if (id == null || id.equals(null)) {
				return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			} else {
				userService.updateDelete(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@PutMapping("update_archive/{id}")
	public ResponseEntity<UserModel> updateArchiveUser(@PathVariable Long id, HttpServletRequest request)
			throws JsonProcessingException {
		UserModel userModel;
		try {
			userModel = userService.getUserById(id);
			if (id == null || id.equals(null)) {
				return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			} else {
				userService.updateArchive(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserModel> deleteUser(@PathVariable Long id) {
		UserModel userModel = null;
		if (userService.userIsPresent(id)) {
			userModel = userService.getUserById(id);
		}
		if (userModel == null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(id);
		return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/")
	public List<UserModel> getUsers(HttpServletRequest request) throws JsonProcessingException {
		List<UserModel> users = null;
		try {
			users = userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id, HttpServletRequest request)
			throws JsonProcessingException {
		UserModel userModel = null;
		try {
			if (userService.userIsPresent(id)) {
				userModel = userService.getUserById(id);
			}
			if (userModel == null) {
				return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}

	@GetMapping("/active")
	public List<UserModel> getActiveUsers(HttpServletRequest request) throws JsonProcessingException {
		List<UserModel> users = null;
		try {
			users = userService.getActiveUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@GetMapping("/delete")
	public List<UserModel> getDeletedUsers(HttpServletRequest request) throws JsonProcessingException {
		List<UserModel> users = null;
		try {
			users = userService.getDeletedUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@GetMapping("/archive")
	public List<UserModel> getArchivedUsers(HttpServletRequest request) throws JsonProcessingException {
		List<UserModel> users = null;
		try {
			users = userService.getArchivedUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}

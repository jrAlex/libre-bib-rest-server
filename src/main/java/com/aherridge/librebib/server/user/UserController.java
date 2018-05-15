package com.aherridge.librebib.server.user;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class UserController {

  private UserRepository userRepository;
  private GoogleDirectoryService googleDirectoryService;

  @Autowired
  public UserController(UserRepository userRepository,
      GoogleDirectoryService googleDirectoryService) {
    this.userRepository = userRepository;
    this.googleDirectoryService = googleDirectoryService;
  }

  @RequestMapping(method = GET, value = "/users/{id}")
  @ResponseBody
  public Optional<User> findById(@PathVariable("id") String id) {
    Optional<User> user = userRepository.findById(id);

    if (!user.isPresent()) {
      user = googleDirectoryService.findById(id);
    }

    return user;
  }
}

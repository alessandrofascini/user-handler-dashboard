package it.eforhum.users;

import it.eforhum.users.entity.User;
import it.eforhum.users.service.UserService;
import it.eforhum.users.utils.DateGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class UsersApplicationTests {
	private static Random randomGenerator = new Random();
	private static List<User> users = new ArrayList<>();

	static  {
		System.out.println("Pre Load elements");
		users.add(new User());
		users.get(0).setUsername("root");
		users.get(0).setPassword("root");
		users.get(0).setBornDate(DateGenerator.defaultLocalDate());
		users.get(0).setLastLoginDate(DateGenerator.defaultZonedDateTime());
		users.get(0).setRoles("ROLES_ROOT");

		IntStream.range(1, 5).forEach(userId -> {
			User user = new User();
			user.setUsername("user#" + userId);
			user.setPassword("user:pwd#" + userId);
			user.setBornDate(DateGenerator.defaultLocalDate());
			user.setLastLoginDate(DateGenerator.defaultZonedDateTime());
			user.setRoles("ROLES_SIMPLE");
			users.add(user);
		});
	}

	@Test
	void contextLoads() {
	}

}

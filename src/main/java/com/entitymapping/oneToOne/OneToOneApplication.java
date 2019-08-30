package com.entitymapping.oneToOne;

import com.entitymapping.oneToOne.models.Gender;
import com.entitymapping.oneToOne.models.User;
import com.entitymapping.oneToOne.models.UserProfile;
import com.entitymapping.oneToOne.repositories.UserProfileRepository;
import com.entitymapping.oneToOne.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Override
	public void run(String [] args) throws Exception {
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		User user = new User("Rajeev", "Singh", "rajeev@callicoder.com", "mypassword");
		UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, "Bangalore",  "Karnataka", "India", "560008");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		userRepository.save(user);
	}

}

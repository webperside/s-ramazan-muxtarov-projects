package com.company.springbootdemo;

import com.company.springbootdemo.dao.inter.UserDaoInter;
import com.company.springbootdemo.models.User;
import com.company.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	@Autowired
	private UserDaoInter userDao;

	@Autowired
	private User user;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(userRepository.findAll());
		Optional<User> optUser = userRepository.findByEmailAndPassword("hs123@gmail.com","hs123");
		optUser.ifPresent(System.out::println);

	}
}

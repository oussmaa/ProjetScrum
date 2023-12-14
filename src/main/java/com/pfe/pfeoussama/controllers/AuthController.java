package com.pfe.pfeoussama.controllers;


import com.pfe.pfeoussama.models.Chapitre;
import com.pfe.pfeoussama.models.SalonDisscussion;
import com.pfe.pfeoussama.models.User;
import com.pfe.pfeoussama.payload.request.LoginRequest;
import com.pfe.pfeoussama.payload.request.SignupRequest;
import com.pfe.pfeoussama.payload.response.JwtResponse;
import com.pfe.pfeoussama.payload.response.MessageResponse;
import com.pfe.pfeoussama.repository.UserRepository;
import com.pfe.pfeoussama.security.jwt.JwtUtils;
import com.pfe.pfeoussama.security.services.UserDetailsImpl;
import com.pfe.pfeoussama.security.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;




	@Autowired
	PasswordEncoder encoder;



	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				userDetails.getRoles(),userDetails.getNumero(), userDetails.getImage()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Email is already in use!"));
		}
		if(signUpRequest.getRoles().equals(null))
		{
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Roles is not find!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getNumero(),signUpRequest.getImage(),signUpRequest.getRoles());




		userRepository.save(user);



		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("/GetAllUser")
	public List<User> getAlluser() {
		return userRepository.findAll();
	}

	@GetMapping("/find/{id}")
	public Optional<User> getuser(@PathVariable String id) {

		Optional<User> emp = userRepository.findById(id);

		return emp;
	}
	@DeleteMapping("/deletuser/{id}")
	public ResponseEntity<HttpStatus> deleteSalon(@PathVariable("id") String id) {
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateuserrole(@PathVariable("id") String id, @RequestBody User user) {
		Optional<User> user1 = userRepository.findById(id);
		if(user1.isPresent())
		{
			User use = user1.get();
			use.setRoles(user.getRoles());
			use.setUsername(user.getUsername());
			use.setEmail(user.getEmail());

			return new ResponseEntity<>(userRepository.save(use), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}

	@GetMapping("/findRoles/{Roles}")
	public List<User> getByRoles(@PathVariable("Roles") String Roles){
		List<User> list = this.userRepository.findByRoles(Roles);

		return list;
	}

	@PutMapping("/updatepassword/{email}")
	public ResponseEntity<User> updatepassword(@PathVariable("email") String email, @RequestBody User user) {
		Optional<User> user1 = userRepository.findByEmail(email);
		if(user1.isPresent())
		{
			User use = user1.get();
			use.setPassword(encoder.encode(user.getPassword()));

			return new ResponseEntity<>(userRepository.save(use), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}
	@PutMapping("/updateprofile/{id}")
	public ResponseEntity<User> updateuser(@PathVariable("id") String id, @RequestBody User user) {
		Optional<User> user1 = userRepository.findById(id);
		if(user1.isPresent())
		{
			User use = user1.get();
			use.setUsername(user.getUsername());
			use.setNumero(user.getNumero());
			use.setImage(user.getImage());
			return new ResponseEntity<>(userRepository.save(use), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}
	@PutMapping("/updateprofile2/{id}")
	public ResponseEntity<User> updateuser2(@PathVariable("id") String id, @RequestBody User user) {
		Optional<User> user1 = userRepository.findById(id);
		if(user1.isPresent())
		{
			User use = user1.get();
			use.setUsername(user.getUsername());
			use.setNumero(user.getNumero());

			return new ResponseEntity<>(userRepository.save(use), HttpStatus.OK);

		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}
	@PostMapping("/validusername")
	public ResponseEntity<?> valiname(@RequestBody User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Username is already taken!"));
		}


		return ResponseEntity.ok(new MessageResponse("Username successfully!"));
	}
}



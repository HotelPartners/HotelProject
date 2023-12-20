package com.backend.auth;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.config.JwtService;
import com.backend.daos.IUserDAO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;
import com.backend.pojos.enums.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final ModelMapper modelMapper;
	private final IUserDAO userDao;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user=UserPOJO.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.userEmail(request.getEmail())
				.mobileNumber(request.getMobileNumber())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(UserRole.CUSTOMER)
				.registeredDate(LocalDate.now())
				.build();
		userDao.save(user);
		
		var jwtToken=jwtService.generateToken(user);
		
				
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build(); 
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
	       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			var user=userDao.findByUserEmail(request.getEmail()).orElseThrow();
	        UserDTO u=modelMapper.map(user,UserDTO.class);
			var jwtToken=jwtService.generateToken(user);
			return AuthenticationResponse.builder()
					.token(jwtToken)
					.user(u)
					.userId(user.getUserId())
					.build();
		}


	

}

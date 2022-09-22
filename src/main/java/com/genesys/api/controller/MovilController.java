package com.genesys.api.controller;



import java.util.HashMap;

import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.api.dao.entity.Menssage;
import com.genesys.api.dao.entity.MovilEntity;


@RestController
@RequestMapping("/api/v2")
public class MovilController {

	private static final Logger logger = LogManager.getLogger(MovilController.class);
	@GetMapping("/token")
	public ResponseEntity<?> getToken(){
		Map<String, Object> response = new HashMap<String, Object>();
		MovilEntity moviles = new MovilEntity();
		String uuid=UUID.randomUUID().toString();
		moviles.setId(uuid);
		moviles.setToken(getJWTToken(uuid));

		response.put("moviles", moviles);
		//To clear context
		//ThreadContext.clearAll();
		logger.info("Token creado: "+moviles.getToken());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	@PostMapping("/mesagge")
	public ResponseEntity<?> save(@RequestBody Menssage movil){
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info(movil.toString());
		response.put("OK", "");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	private String getJWTToken(String UUID) {
		String secretKey = "14a2fecb-ddd7-4823-a9cc-67515bc01734";
		/*SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");*/
	/*	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject("123456")
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(signatureAlgorithm,signingKey)
				.compact();
*/
		return "Bearer " + UUID+"-"+secretKey; 
	}
}

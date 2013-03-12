package kr.pe.goodwilldd.security.mapper.normal;

import kr.pe.goodwilldd.core.database.CoreMapper;
import kr.pe.goodwilldd.security.model.AuthenticationModel;

import org.springframework.stereotype.Repository;

@Repository
public interface SecurityMapper extends CoreMapper {
	public AuthenticationModel getUser(String username);
}

package kr.pe.goodwilldd.example.mapper.normal;

import kr.pe.goodwilldd.core.database.CoreMapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ExampleMapper extends CoreMapper {
	public String getUserName(String userId);
}

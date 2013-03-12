package kr.pe.goodwilldd.example.service;

import kr.pe.goodwilldd.example.mapper.normal.ExampleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService implements ExampleServiceIF {

	@Autowired
	private ExampleMapper exampleMapper;

	@Override
	public String getUserName(String user_id) {
		return exampleMapper.getUserName(user_id);
	}
}

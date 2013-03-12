package kr.pe.goodwilldd.example.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * 객체를 json 이나, xml로 반환하기 위해서는 반드시 아래 2가지 Annotation을 선언해야한다
 * 
 * @author sylee
 * 
 */
@XmlRootElement
@JsonAutoDetect
public class ExampleModel {
	public ExampleModel() {

	}

	public ExampleModel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

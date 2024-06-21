package jp.co.axiz.kanri.entity;

/*
 * genderテーブル用エンティティ
 */

public class Gender {

	private Integer genderId;

	private String genderName;


	//引数なしコンストラクタ
	public Gender() {

	}

	//引数ありコンストラクタ
	public Gender(Integer genderId, String genderName) {
		this.genderId = genderId;
		this.genderName = genderName;
	}


	public Integer getGenderId() {
		return genderId;
	}
	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}


}

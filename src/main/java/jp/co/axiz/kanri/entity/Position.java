package jp.co.axiz.kanri.entity;

/*
 * positionテーブル用エンティティ
 */

public class Position {

	private Integer positionId;

	private String positionName;


	//引数なしコンストラクタ
	public Position() {

	}

	//引数ありコンストラクタ
	public Position(Integer positionId, String positionName) {
		this.positionId = positionId;
		this.positionName = positionName;
	}


	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}

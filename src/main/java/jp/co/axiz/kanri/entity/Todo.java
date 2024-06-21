package jp.co.axiz.kanri.entity;

/*
 * todoテーブル用エンティティ
 */

public class Todo {

	private String loginId;

	private Integer todoId;

	private String text;

	private Integer priority;

	private String due;



	// 引数無しコンストラクタ
	public Todo() {
	}


	// 引数ありコンストラクタ
	public Todo(String loginId, Integer todoId, String text, Integer priority, String due) {
		this.loginId = loginId;
		this.todoId = todoId;
		this.text = text;
		this.priority = priority;
		this.due = due;
	}



	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}


}

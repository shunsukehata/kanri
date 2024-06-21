package jp.co.axiz.kanri.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * ToDoリスト画面用フォーム
 */

public class TodoForm {

	@NotBlank
	private String text;

	@NotNull
	private Integer priority;

	@NotBlank
	private String due;



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

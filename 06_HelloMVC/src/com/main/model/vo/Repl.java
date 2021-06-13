package com.main.model.vo;

public class Repl {
	private String seq, content;
	
	public Repl() {
		// TODO Auto-generated constructor stub
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Repl [seq=" + seq + ", content=" + content + "]";
	}
	
	
	
}

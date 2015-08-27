package com.zehao.first_test;

public class TextEditor {
	
	private SpellCheck spellCheck;
	
	public TextEditor(SpellCheck spellCheck){
		this.spellCheck = spellCheck;
	}
	
	public void spellCheck(){
		spellCheck.checkSpelling();
	}

}

package com.zehao.first_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// @Import(ConfigA.class)
public class TextEditorConfig {
	@Bean
	// @Bean(initMethod = "init", destroyMethod = "cleanup" )
	public TextEditor textEditor() {
		return new TextEditor(spellCheck());
	}

	@Bean
	@Scope("prototype")
	public SpellCheck spellCheck() {
		return new SpellCheck();
	}

}

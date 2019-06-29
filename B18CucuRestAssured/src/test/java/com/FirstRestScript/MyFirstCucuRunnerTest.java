package com.FirstRestScript;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/com/FirstRestScript/"},
		glue={"com/FirstRestScript/"}
		
		)

public class MyFirstCucuRunnerTest {

}

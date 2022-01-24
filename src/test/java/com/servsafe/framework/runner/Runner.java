
package com.servsafe.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/Demo.feature" }, glue = {
		"classpath:com.servsafe.framework.stepdefinition",
		"classpath:com.servsafe.framework.helper" }, plugin = { "pretty", "json:target/Runner.json" })

public class Runner extends AbstractTestNGCucumberTests {

}

package com.cisco.ci.sudo.exam;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AreaTeamTest.class,
		LineTeamTest.class,
		SudoUtilTest.class, SuPersonsWorldTest.class,
		SudoResolverTest.class})
public class SudoTestSuites {
}

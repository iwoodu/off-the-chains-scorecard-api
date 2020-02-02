package com.rhitm.scorecard.domain;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.rhitm.scorecard.AbstractJavaBeanTest;

class ScorecardTemplateTest extends AbstractJavaBeanTest<ScorecardTemplate> {
	
	@Test
	public void testAllArgumentConstructor() {
		new ScorecardTemplate("My Home Course", new ArrayList<Hole>());
	}
	
	@Override
	protected ScorecardTemplate getBeanInstance() {
		return new ScorecardTemplate();
	}

}
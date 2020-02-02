package com.rhitm.scorecard.dto.create;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.rhitm.scorecard.AbstractJavaBeanTest;

class ScorecardTemplateRequestTest extends AbstractJavaBeanTest<ScorecardTemplateRequest> {

	@Test
	public void testAllArgsConstructor() {
		Assert.notNull(new ScorecardTemplateRequest("My Home Course", new ArrayList<HoleRequest>()), "Cannot be null");
	}
	
	@Override
	protected ScorecardTemplateRequest getBeanInstance() {
		return new ScorecardTemplateRequest();
	}

}

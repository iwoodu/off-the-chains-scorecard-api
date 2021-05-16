package com.rhitm.scorecard.dto.create;

import com.rhitm.scorecard.AbstractJavaBeanTest;
import com.rhitm.scorecard.domain.TeeDescription;

import org.junit.jupiter.api.Test;

class HoleRequestTest extends AbstractJavaBeanTest<HoleRequest> {

	@Test
	public void testAllArgsConstructor() {
		new HoleRequest(1, TeeDescription.BLUE, 285, 3);
	}
	
	@Override
	protected HoleRequest getBeanInstance() {
		return new HoleRequest();
	}

}

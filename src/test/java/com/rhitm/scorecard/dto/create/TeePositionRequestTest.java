package com.rhitm.scorecard.dto.create;

import org.junit.jupiter.api.Test;

import com.rhitm.scorecard.AbstractJavaBeanTest;
import com.rhitm.scorecard.domain.TeeDescription;

class TeePositionRequestTest extends AbstractJavaBeanTest<TeePositionRequest> {

	@Test
	public void testAllArgsConstructor() {
		new TeePositionRequest(TeeDescription.BLUE, 350, 3);
	}
	
	@Override
	protected TeePositionRequest getBeanInstance() {
		return new TeePositionRequest();
	}

}

package com.rhitm.scorecard.dto.create;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.rhitm.scorecard.AbstractJavaBeanTest;

class HoleRequestTest extends AbstractJavaBeanTest<HoleRequest> {

	@Test
	public void testAllArgsConstructor() {
		new HoleRequest(1, new ArrayList<TeePositionRequest>());
	}
	
	@Override
	protected HoleRequest getBeanInstance() {
		return new HoleRequest();
	}

}

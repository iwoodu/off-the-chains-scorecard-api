package com.rhitm.scorecard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Off the Chains Scorecard API",
        version = "v1",
		description = "REST APIs to create and manage disc golf scorecards"
			+ "<p><b>Key Concepts</b></p><ul>"
			+ "<li>A scorecard template defines one or more layouts of a disc golf course</li>"
			+ "<li>A scorecard is created from a scorecard template</li>"
			+ "<li>A scorecard records scores for a round of disc golf</li></ul>",
        contact = @Contact(
            name = "David",
            email = "iwoodu@tutanota.com",
            url = "https://github.com/iwoodu/off-the-chains-scorecard-api"
        )
    )
)
public class OffTheChainsScorecardApiApplication {

    private static final Logger logger = LoggerFactory.getLogger(OffTheChainsScorecardApiApplication.class);

	public static void main(final String[] args) {
        logger.info("Off the Chains Scorecard API v1.0.0");
		SpringApplication.run(OffTheChainsScorecardApiApplication.class, args);
	}

}

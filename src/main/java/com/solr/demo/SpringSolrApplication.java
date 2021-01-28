package com.solr.demo;

import com.solr.demo.model.SolrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSolrApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringSolrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringSolrApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			SolrResponse quote = restTemplate.getForObject(
					"http://localhost:8983/solr/mycore/select?q=*:*&rows=1", SolrResponse.class);
			log.info(quote.toString());
		};
	}

}

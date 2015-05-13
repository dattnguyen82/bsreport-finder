package org.dtn82;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultsController {

	private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> index()
    {
            String message = "BS Report Finder" ;

		return new ResponseEntity<String>(message, new HttpHeaders(), HttpStatus.OK);
	}

}

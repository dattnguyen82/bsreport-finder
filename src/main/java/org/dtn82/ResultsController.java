package org.dtn82;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultsController {

	private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BSRInformationRepository bsrInformationRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> index()
    {
        String message = "BS Report Finder" ;

        return new ResponseEntity<String>(message, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<BSRInformation>> all()
    {
        System.out.println("FindAll():");
        System.out.println("-------------------------------");
        List<BSRInformation> list =  bsrInformationRepository.findAll();

        System.out.println("Count: " + list.size());

        for (BSRInformation info : list) {
            System.out.println(info.toJson());
        }
        System.out.println();

        return new ResponseEntity<List<BSRInformation>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}

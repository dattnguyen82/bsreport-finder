package org.dtn82;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<BSRInformation> list =  bsrInformationRepository.findAll();
        return new ResponseEntity<List<BSRInformation>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<BSRInformation>> get(@RequestParam(value = "keys") String keys)
    {
        keys = keys.toLowerCase();
        keys = keys.replaceAll("\\s+", "");

        String[] tokens = keys.split(",");

        List<BSRInformation> list =  bsrInformationRepository.findByTokens(tokens);
        return new ResponseEntity<List<BSRInformation>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<BSRInformation> save(@RequestBody BSRInformation input)
    {
        bsrInformationRepository.save(input);
        return new ResponseEntity<BSRInformation>(input, new HttpHeaders(), HttpStatus.OK);
    }


}

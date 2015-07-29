package org.dtn82;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class ResultsController {

	private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    private final String dateFormat = "yyyy-M-dd";

    @Autowired
    BSRInformationRepository bsrInformationRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
      public ResponseEntity<List<BSRInformation>> all()
    {
        List<BSRInformation> list =  bsrInformationRepository.findAll();
        return new ResponseEntity<List<BSRInformation>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<BSRInformation>> get(@RequestParam(value = "keys", required = false) String keys, @RequestParam(value = "start_date", required = false) String start, @RequestParam(value = "end_date", required = false) String end)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String tokens = null;
        Date start_date = null;
        Date end_date = null;

        if (keys != null)
        {
            keys = keys.toLowerCase();
            keys = keys.replaceAll("\\s+", "");
            tokens = keys.replaceAll(",", "|");
            //tokens += "/i";
        }
        else
        {
            tokens = new String("");
        }


        if (start == null)
        {
            start_date = new GregorianCalendar(2007, 6, 14).getTime();
        }
        else
        {
            try {
                start_date = sdf.parse(start);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (end == null)
        {
            end_date = new GregorianCalendar(2015, 5, 8).getTime();
        }
        else
        {
            try {
                end_date = sdf.parse(end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String startDateString = sdf.format(start_date);
        String endDateString = sdf.format(end_date);

        System.out.println(startDateString);
        System.out.println(endDateString);
        System.out.println(tokens);

        List<BSRInformation> list = bsrInformationRepository.get(tokens, startDateString, endDateString, new Sort(Sort.Direction.ASC, "date"));

//        for (BSRInformation l : list)
//        {
//            System.out.println(l.toString()) ;
//        }

        return new ResponseEntity<List<BSRInformation>>(list, new HttpHeaders(), HttpStatus.OK);
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ResponseEntity<BSRInformation> save(@RequestBody BSRInformation input)
//    {
//        bsrInformationRepository.save(input);
//        return new ResponseEntity<BSRInformation>(input, new HttpHeaders(), HttpStatus.OK);
//    }


}

package com.train.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class CsvWriter {

    private static final String CSV_SEPARATOR = ",";

    @RequestMapping(value = "/writeCsv", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseEntity write(generated.Invoice product)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/Documents/projects/products.csv"), "UTF-8"));

            StringBuffer oneLine = new StringBuffer();
            oneLine.append("issue,nr,total");
            oneLine.append("\n");
            oneLine.append(product.getNr() <=0 ? "" : product.getNr());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(product.getIssue()<=0? "" : product.getIssue());
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(product.getTotal() < 0 ? "" : product.getTotal());
//                oneLine.append(product.isVatApplicable() ? "Yes" : "No");
            bw.write(oneLine.toString());
            bw.newLine();
            System.out.print("aici s a ajuns");
            bw.flush();
            bw.close();

        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}

        return ResponseEntity.ok("added");
    }


}

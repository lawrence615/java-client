package com.mobidev.pdsl.controllers;

import com.mobidev.pdsl.Client;
import com.mobidev.pdsl.Client2;
import com.mobidev.pdsl.Client3;
import com.mobidev.pdsl.model.*;
import com.mobidev.pdsl.repository.LogRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PawaController {

    @Autowired
    Client client;

    @Autowired
    Client2 client2;

    @Autowired
    Client3 client3;

    @Autowired
    LogRepository logRepository;

    /**
     * Simple Vend Request example
     *
     * @param token
     * @return
     */
    @PostMapping("/token")
    public ResponseEntity<TokenResponse> purchase(@RequestBody Token token) {
        String value = "";

        if (token != null) {
            Log logResponse = log("request", "amount: " + token.getAmount() + " meter: " + token.getAmount() + " quantity: " + token.getQuantity());

            String message = "<ipayMsg client=\"TEGEMEO\" term=\"00001\" seqNum=\"" + logResponse.getId() + "\" time=\"" + new DateTime().plusHours(2).toString("yyyy-MM-dd H:m:s") + "\">\n" +
                    "            <elecMsg ver=\"2.44\">\n" +
                    "                <vendReq>\n" +
                    "                    <ref>" + logResponse.getId() + "</ref>\n" +
                    "                    <amt cur=\"KES\">" + token.getAmount() + "</amt>\n" +
                    "                    <numTokens>" + token.getQuantity() + "</numTokens>\n" +
                    "                    <meter>" + token.getMeter() + "</meter>\n" +
                    "                    <payType>cash</payType>\n" +
                    "                </vendReq>\n" +
                    "            </elecMsg>\n" +
                    "        </ipayMsg>";
//            value = client.write(message);

            try {
                value = client2.connect(message);
                client2.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }


        log("pdsl-response", value);


        return ResponseEntity.ok().body(new TokenResponse(token.getAmount(), token.getQuantity(), value));
    }

    /**
     * Customer Info Request Example
     *
     *
     * @param customer
     * @return
     * @throws IOException
     */
    @PostMapping("/customer")
    public ResponseEntity<CustorInfoResponse> getCustomerInfo(@RequestBody Customer customer) throws IOException {
        String value = "";

        if (customer != null) {
            Log logResponse = log("customer-info-request", customer.getMeter());

            String message = "<ipayMsg client=\"ipay\" term=\"1\" seqNum=\"" + logResponse.getId() + "\" time=\"" + new DateTime().plusHours(2).toString("yyyy-MM-dd H:m:s") + "\">\n" +
                    "<elecMsg ver=\"2.44\">\n" +
                    "<custInfoReq>\n" +
                    "<ref>" + logResponse.getId() + "</ref>\n" +
                    "<meter>" + customer.getMeter() + "</meter>\n" +
                    "</custInfoReq>\n" +
                    "</elecMsg>\n" +
                    "</ipayMsg>";

            value = client2.connect(message);
            client2.close();

            log("pdsl-customer-response", value);
        }

        return ResponseEntity.ok().body(new CustorInfoResponse(customer.getMeter(), value));
    }

    private Log log(String desc, String content) {
        Log log = new Log();
        log.setDescription(desc);
        log.setContent(content);

        return logRepository.save(log);
    }
}

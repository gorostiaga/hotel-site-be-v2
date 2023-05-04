package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.booking.BookingDto;
import com.taras.hotelsitebev2.dtos.payment.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;

// For Local Storage for BNB
@Service
public class QrServiceBnb implements QrServiceInterface{
//    @Value("$(test.qr.accountId)")
//    private String accountId;
//    @Value("$(test.qr.authorizationId)")
//    private String authorizationId;
//    @Value("$(test.url.token)")
//    private String tokenUrl;
//    @Value("$(test.url.qr)")
//    private String qrUrl;
//    @Value("$(image.directory)")
//    private String imageDirectory;

    private final RestTemplate restTemplate;
    private final QrApiBnbDto qrApiBnbDto;
    private final QrPaymentService qrPaymentService;

    public QrServiceBnb(RestTemplate restTemplate, QrApiBnbDto qrApiBnbDto, QrPaymentService qrPaymentService) {
        this.restTemplate = restTemplate;
        this.qrApiBnbDto = qrApiBnbDto;
        this.qrPaymentService = qrPaymentService;
    }

    @Override
    public String getQrUrl(BookingDto bookingDto) {

        QrResponseBnb qrResponseBnb = getQrResponseBnb(bookingDto);

        //turn the string into and image and store it locally
        String image = qrResponseBnb.getQr();
        byte[] decodedImage = Base64.getDecoder().decode(image);
        String fileName = "qr_image_" + bookingDto.getId().toString() + ".png";

        Path imagePath = Paths.get(qrApiBnbDto.getImageDirectory(), fileName);

        try{
            Files.write(imagePath, decodedImage);
            String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/qrImages/")
                    .path(fileName)
                    .toUriString();

            //create a new qr entity in the database
            qrPaymentService.save(Double.valueOf(qrResponseBnb.getId()), bookingDto.getId());

            return imageUrl;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //get the array of bytes from the Bank API along with other information
    private QrResponseBnb getQrResponseBnb (BookingDto bookingDto) {
        //get the JSON from the API
        RequestBodyQrBnb requestBodyQrBnb = new RequestBodyQrBnb();
        String bearerToken = getBearerToken(qrApiBnbDto.getId(), qrApiBnbDto.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);
        headers.setCacheControl("no-cache");

        requestBodyQrBnb.setCurrency("BOB");
        requestBodyQrBnb.setGloss("Pago de reserva" + bookingDto.getId().toString());
        requestBodyQrBnb.setAmount(bookingDto.getPaidAmount());
        requestBodyQrBnb.setSingleUse(true);
        requestBodyQrBnb.setExpirationDate(LocalDate.now().plusDays(2).toString());
        requestBodyQrBnb.setAdditionalData("Prueba");
        requestBodyQrBnb.setDestinationAccountId("1");

        HttpEntity<RequestBodyQrBnb> requestEntity = new HttpEntity<>(requestBodyQrBnb, headers);

        ResponseEntity<QrResponseBnb> response = restTemplate.exchange(qrApiBnbDto.getQrUrl(), HttpMethod.POST, requestEntity, QrResponseBnb.class);

        return response.getBody();
    }

    //get the token
    private String getBearerToken (String account, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        TokenRequestBnb tokenRequestBnb = new TokenRequestBnb();
        tokenRequestBnb.setAccountId(account);
        tokenRequestBnb.setAuthorizationId(password);

        HttpEntity<TokenRequestBnb> requestEntity = new HttpEntity<>(tokenRequestBnb, headers);
        ResponseEntity<TokenResponseBnb> response = restTemplate.exchange(qrApiBnbDto.getTokenUrl(), HttpMethod.POST, requestEntity, TokenResponseBnb.class);

        return  response.getBody().getMessage();
    }
}

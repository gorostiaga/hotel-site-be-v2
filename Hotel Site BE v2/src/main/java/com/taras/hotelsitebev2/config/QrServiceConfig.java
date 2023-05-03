package com.taras.hotelsitebev2.config;

import com.taras.hotelsitebev2.dtos.payment.QrApiBnbDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:apibnb.properties")
public class QrServiceConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    QrApiBnbDto qrApiBnbDto(@Value("${test.qr.accountId}") String accountId, @Value("${test.qr.authorizationId}") String authorizationId,
        @Value("${test.url.token}") String tokenUrl, @Value("${test.url.qr}") String qrUrl, @Value("${image.directory}") String imageDirectory) {
        QrApiBnbDto qrApiBnbDto = new QrApiBnbDto();
        qrApiBnbDto.setId(accountId);
        qrApiBnbDto.setPassword(authorizationId);
        qrApiBnbDto.setTokenUrl(tokenUrl);
        qrApiBnbDto.setQrUrl(qrUrl);
        qrApiBnbDto.setImageDirectory(imageDirectory);
        return qrApiBnbDto;
    }


}

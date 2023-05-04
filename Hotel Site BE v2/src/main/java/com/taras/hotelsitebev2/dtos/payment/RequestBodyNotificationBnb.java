package com.taras.hotelsitebev2.dtos.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyNotificationBnb {
    @JsonProperty(value = "QRId")
    private String qrId;
    @JsonProperty(value = "Gloss")
    private String gloss;
    @JsonProperty(value = "sourceBankId")
    private Integer sourceBankId;
    @JsonProperty(value = "originName")
    private String originName;
    @JsonProperty(value = "VoucherId")
    private String voucherId;
    @JsonProperty(value = "TransactionDateTime")
    private String transactionDateTime;
}

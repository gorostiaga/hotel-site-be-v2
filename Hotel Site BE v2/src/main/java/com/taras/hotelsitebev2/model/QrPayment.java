package com.taras.hotelsitebev2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qr_payments")
public class QrPayment extends BaseEntity{

    @Column(name = "id_bank")
    private Double idBank;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "modification_date")
    private Date modificationDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "qr_status")
    private QrStatus qrStatus;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "gloss")
    private String gloss;

    @Column(name = "source_bank_id")
    private Integer sourceBankId;

    @Column(name = "origin_name")
    private String originName;

    @Column(name = "voucher_id")
    private String voucherId;

    @Column(name = "transaction_date_time")
    private Date transactionDateTime;

}

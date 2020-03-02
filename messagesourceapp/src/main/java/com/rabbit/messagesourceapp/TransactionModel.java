package com.rabbit.messagesourceapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {
     private int orderId;
     private int itemId;
     private String region;

}

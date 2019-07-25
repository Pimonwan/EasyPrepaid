package com.codemobiles.myfirebase.hackatonpractice

//data class DeeplinkBody(
//    val accountTo: String,
//    val paymentAmount: Int,
//    val ref1: String,
//    val ref2: String,
//    val ref3: String,
//    val transactionSubType: String,
//    val transactionType: String
//)
//
//data class MerchantMetaData(
//    val analytics: AnalyticsDetail,
//    val paymentInfo: List<PaymentInfo>
//)
//
//data class AnalyticsDetail(
//    val Detail1: String,
//    val Partner: String
//)
//
//data class PaymentInfo(
//    val description: String,
//    val header: String,
//    val title: String,
//    val type: String
//)

data class DeeplinkBody(
    val accountTo: String,
    val paymentAmount: Double,
    val ref1: String,
    val ref2: String,
    val ref3: String,
    val transactionSubType: String,
    val transactionType: String
)

data class MerchantMetaData(
    val analytics: Analytics,
    val paymentInfo: List<PaymentInfo>
)

data class Analytics(
    val Detail1: String,
    val Detail2: String,
    val Detail3: String,
    val Detail4: String,
    val Detail5: String,
    val Detail6: String,
    val Partner: String
)

data class PaymentInfo(
    val description: String,
    val header: String,
    val imageUrl: String,
    val title: String,
    val type: String
)
package com.benyissa;


import com.benyissa.proxy.BankService;
import com.benyissa.proxy.BankWebService;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello, I am a soap client , let's test the BankWebService");
        BankService stub = new BankWebService().getBankServicePort();
        System.out.println(stub.convertToMAD(10));
    }
}
package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//POJO (a simple class of java , it stands for plain old java object)

@WebService(serviceName = "BankWebService")
public class BankService {

    @WebMethod(operationName = "convertToMAD")
    public double convertToMAD(@WebParam(name = "balance") double balance) {
        return balance * 11;
    }

    @WebMethod
    public Account getAccount(@WebParam(name = "code") int code) {
        return new Account(code, Math.random() * 957, new Date());
    }

    @WebMethod
    public List<Account> accountsList() {
        List<Account> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new Account(i, Math.random() * 193, new Date()));
        }
        return list;
    }
}

import jakarta.xml.ws.Endpoint;
import ws.BankService;

//oracle ===> java
//jee ===>jakarta
public class ServerJWS {

    public static void main(String[] args) {

//    start a http server , used for connecting with the webservice
//    0.0.0.0 means we can connect from any host of my LAN
        Endpoint.publish("http://0.0.0.0:9191/", new BankService());

        System.out.println("Web server is running in http://0.0.0.0:9191/");
    }
}

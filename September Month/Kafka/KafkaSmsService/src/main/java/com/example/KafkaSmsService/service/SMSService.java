import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;

@Service
public class SMSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    public static final String FROM_NUMBER = "+919676278087";

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSMS(String toNumber, String textMessage) {
        Message message = Message.creator(new PhoneNumber(toNumber), new PhoneNumber(FROM_NUMBER), textMessage).create();
        System.out.println("SMS sent successfully with SID: " + message.getSid());
    }
}
//    public static final String ACCOUNT_SID="ACbc1f7a3898128c481c3196d8c90f228f";
//    public static final String AUTH_TOKEN="42be0d0279dc6caddd15b8c8a90c6d91";
//    public static final String FROM_NUMBER="+919676278087";

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
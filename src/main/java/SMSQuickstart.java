import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;
import com.messagebird.exceptions.GeneralException;
import com.messagebird.exceptions.UnauthorizedException;
import com.messagebird.objects.MessageResponse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SMSQuickstart {
    public static void main(String[] args) {
        // Create a MessageBirdService
        final MessageBirdService messageBirdService = new MessageBirdServiceImpl("YOUR-API-KEY");
        // Add the service to the client
        final MessageBirdClient messageBirdClient = new MessageBirdClient(messageBirdService);

        // convert String number into acceptable format
        BigInteger phoneNumber = new BigInteger("31970YYYYYYY");
        final List<BigInteger> phones = new ArrayList<BigInteger>();
        phones.add(phoneNumber);

        try {
            final MessageResponse response = messageBirdClient.sendMessage("31970XXXXXXX", "Hello World, I am a text message and I was hatched by Java code!", phones);
            System.out.println(response.toString());
        } catch (UnauthorizedException | GeneralException ex) {
            System.out.println(ex.toString());
        }
    }
}
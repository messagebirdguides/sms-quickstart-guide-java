# Send your first SMS with MessageBird

### ⏱ 10 MIN BUILD TIME

It's time to send your first SMS using the MessageBird SMS Messaging API! Before we get started, have you set up your Java development environment and project directory with the MessageBird SDK?

* **No** - make sure you [read this MessageBird Developer Tutorial](https://developers.messagebird.com/tutorials/setup-local-dev-environment) before getting started.
* **Yes!** - Great! Now you can make your first API request and send an SMS message with MessageBird using Java.

## Getting started

First, let's create a new file in the directory of your `src/main/java` folder and call it `SMSQuickstart.java`.

In this file, let's include the MessageBird SDK using `import`. The SDK expects a single argument - your [API key](https://dashboard.messagebird.com/en/developers/access). Next, in order to start testing the SDK, you can simply replace the string _YOUR-API-KEY_ in the following Java code and hardcode your API key. **Pro-tip:** For production applications, we recommended storing the key in a configuration file or environment variable instead and pass this variable with the key to the client. You'll see this in practice later in our MessageBird Developer Tutorials for building common use cases.

``` java
// Create a MessageBirdService
final MessageBirdService messageBirdService = new MessageBirdServiceImpl("YOUR-API-KEY");
// Add the service to the client
final MessageBirdClient messageBirdClient = new MessageBirdClient(messageBirdService);
```

Now, to send a message with the SDK, we call `message_create` on the SDK object and pass a few required arguments:

``` Java
// convert String number into acceptable format
BigInteger phoneNumber = new BigInteger("31970YYYYYYY");
final List<BigInteger> phones = new ArrayList<BigInteger>();
phones.add(phoneNumber);

final MessageResponse response = messageBirdClient.sendMessage("31970XXXXXXX", "Hello World, I am a text message and I was hatched by Java code!", phones);
```

But wait, what do these attributes mean?

* The first argument is the `originator`, and it is the sender for the message, i.e., from where the recipients see the message coming. It can be a telephone number including country code or an alphanumeric string. In case of an alphanumeric string, the maximum length is 11 characters. Alphanumeric senders are not supported in every country, and they prevent recipients from replying to the message. If you bought a number as part of the [Getting Started tutorial](https://developers.messagebird.com/tutorials/getting-started-101), you can use that number here. When recipients reply you will receive those messages, and we have another **Quickstart Tutorial** to show you how to handle incoming messages programmatically.

* The second argument is the `body`, and it is the content of the message. Note that SMS messages are limited to 160 characters, and if you enter a longer value for the body it will be split into multiple parts which are each sent and billed as a separate message.

* The third argument is the `recipients`, and they are the phone numbers that will receive the message. All numbers should be in the international format with country code. You _must_ specify this attribute as an array even if you have just a single recipient. You can send a message to up to 50 numbers at a time. For testing, add your own mobile telephone number here so you can receive the test message on your phone.

Make sure to replace the values in the sample code with adequate data for testing. There are additional optional attributes as well and you can find them in the [SMS Messaging API documentation](https://developers.messagebird.com/docs/sms-messaging#send-a-message).

If this call fails, the MessageBird client throws an `UnauthorizedException` or `GeneralException` error. We can `catch` this to provide more error information to a user if need be:

``` java
try {
    final MessageResponse response = messageBirdClient.sendMessage("31970XXXXXXX", "Hello World, I am a text message and I was hatched by Java code!", phones);
} catch (UnauthorizedException | GeneralException ex) {
    System.out.println(ex.toString())
}
```

Great! Your first Java app is ready. Let's go ahead and save it.

In production applications, you should not expose the raw values for `error` and provide user-friendly error handling instead, but the current implementation is great for testing.

Enough said, let's try running it from your IDE.

If everything works fine, you should see the API response as output from the script. If you used a live API key and have [verified your number or added test credits to your account](https://support.messagebird.com/hc/en-us/articles/115002599309-Test-credits) the message will arrive on your phone in seconds.

Nice work! You've just sent your first SMS message with MessageBird's SMS Messaging API using Java!

## Next steps

Head over to the next MessageBird Developer Tutorial and [learn how to set up inbound messaging functionality](https://developers.messagebird.com/tutorials/handle-incoming-calls-and-sms).

Want to start building your solution but not quite sure how to get started? Please feel free to let us know at support@messagebird.com, we'd love to help!

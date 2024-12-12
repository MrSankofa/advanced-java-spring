/* CodingNomads (C)2024 */
package com.codingnomads.gettingstarted.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class InspirationService {
    private Map<String, String> quotes = new HashMap<String, String>();

    public InspirationService() {
        this.quotes.put("0", "The only way to do great work is to love what you do. \n- Steve jobs");
        this.quotes.put("1", "Believe you can and you're halfway there. \n- Theodore Roosevelt");
        this.quotes.put("2", "Your time is limited, so don’t waste it living someone else’s life. \n-Steve Jobs");
        this.quotes.put(
                "3",
                "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful. \n-Albert Scheweitzer");
        this.quotes.put(
                "4", "The future belongs to those who believe in the beauty of their dreams. \n-Eleanor Roosevelt");
        this.quotes.put("5", "Don't watch the clock; do what it does. Keep going. \n-Sam Levenson");
        this.quotes.put("6", "You are never too old to set another goal or to dream a new dream. \n-C.S. Lewis");
        this.quotes.put("7", "It does not matter how slowly you go as long as you do not stop. \n-Confucius");
        this.quotes.put(
                "8",
                "What lies behind us and what lies before us are tiny matters compared to what lies within us. \n-Ralph Waldo Emerson");
        this.quotes.put("9", "The best way to predict the future is to create it. \n-Peter Drucker");
    }

    protected String getRandomQuote() {
        Random rand = new Random();

        int randomQuoteKey = rand.nextInt(this.quotes.size());

        return (String) this.quotes.get(String.valueOf(randomQuoteKey));
    }
}

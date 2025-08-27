package ECommerce.Model;

import java.util.*;

class OTP
{
      String code;
       boolean expired = false;

    public OTP()
    {
        generateCode();        // Generate new OTP
        startExpiryTimer();    // Start 30s expiry timer
    }

    static Scanner sc = new Scanner(System.in);

       void generateCode()
    {
        code = String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    public String getCode()
    {
        return code;
    }

    public boolean isExpired()
    {
        return expired;
    }

    public boolean verify(String input)
    {
        if (expired)   // OTP already expired
        {
            return false;
        }
        else if (!code.equals(input))   // Wrong OTP entered
        {
            System.out.println("\n[System] Incorrect OTP.");
            return false;
        }
        return true;
    }

    void startExpiryTimer()
    {
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(30000);
                    expired = true;
                }
                catch (InterruptedException e)
                {
                    System.out.println("Enter OTP within time");
                }
            }
        };
        timer.start();
    }
}

package org.example.ch0;

public class User {

    private String password;

    public void initPassword(PasswordGenerator randomPasswordGenerator) {
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = randomPasswordGenerator.generatePassword();

        if (randomPassword.length() >= 8 && randomPassword.length() <=12) {
            password = randomPassword;
        }
    }

    public String getPassword() {
        return password;
    }
}

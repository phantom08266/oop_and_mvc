package org.example.ch0;

import org.example.ch0.PasswordGenerator;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "aabbccdd";
    }
}

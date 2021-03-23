package com.au.conformity.util;

import org.apache.commons.lang3.RandomStringUtils;

public class HelperMethods {

    public static String generateUserNamePassword() {
        String generatedStringAlphabet = RandomStringUtils.randomAlphanumeric(6);
        String generatedStringNum = RandomStringUtils.randomNumeric(2);
        return generatedStringAlphabet+generatedStringNum;
    }
}

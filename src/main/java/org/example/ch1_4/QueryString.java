package org.example.ch1_4;

/**
 * Key Value가 한개인 클래스
 */
public class QueryString {
    private final String key;
    private final String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean exists(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }
}

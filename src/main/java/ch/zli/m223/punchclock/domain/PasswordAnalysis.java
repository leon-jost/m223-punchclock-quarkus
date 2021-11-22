package ch.zli.m223.punchclock.domain;

public class PasswordAnalysis {
    private int passwordLength;
    private int amountOfOccurrences;

    public int getPasswordLength() {
        return passwordLength;
    }
    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }
    public int getAmountOfOccurrences() {
        return amountOfOccurrences;
    }
    public void setAmountOfOccurrences(int amountOfOccurrences) {
        this.amountOfOccurrences = amountOfOccurrences;
    }    
}

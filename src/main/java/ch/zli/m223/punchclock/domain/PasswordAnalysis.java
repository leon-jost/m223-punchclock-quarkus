package ch.zli.m223.punchclock.domain;

public class PasswordAnalysis {
    private int passwordLenght;
    private int amountOfOccurrences;

    public int getPasswordLenght() {
        return passwordLenght;
    }
    public void setPasswordLenght(int passwordLenght) {
        this.passwordLenght = passwordLenght;
    }
    public int getAmountOfOccurrences() {
        return amountOfOccurrences;
    }
    public void setAmountOfOccurrences(int amountOfOccurrences) {
        this.amountOfOccurrences = amountOfOccurrences;
    }    
}

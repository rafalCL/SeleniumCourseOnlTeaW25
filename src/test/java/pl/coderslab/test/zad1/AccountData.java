package pl.coderslab.test.zad1;

import java.time.LocalDate;

public class AccountData {
    private boolean isMr;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate dateOfBirth;
    private boolean isSignForNewsletter;
    private boolean isRecieveSpecialOffers;

    public boolean isMr() {
        return isMr;
    }

    public AccountData setMr(boolean mr) {
        isMr = mr;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AccountData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AccountData setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public AccountData setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public boolean isSignForNewsletter() {
        return isSignForNewsletter;
    }

    public AccountData setSignForNewsletter(boolean signForNewsletter) {
        isSignForNewsletter = signForNewsletter;
        return this;
    }

    public boolean isRecieveSpecialOffers() {
        return isRecieveSpecialOffers;
    }

    public AccountData setRecieveSpecialOffers(boolean recieveSpecialOffers) {
        isRecieveSpecialOffers = recieveSpecialOffers;
        return this;
    }
}

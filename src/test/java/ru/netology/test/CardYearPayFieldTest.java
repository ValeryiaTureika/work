package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class CardYearPayFieldTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfPastYear() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getPastYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldExpiredDatePassNotification();
    }

    @Test
    public void shouldSuccessPayIfLettersYear() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getLettersYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfYearWithOneDigit() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getYearWithOneDigit(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfLastYear() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getLastYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldInvalidExpiredDateNotification();
    }

    // issue 2
    @Test
    public void shouldSuccessPayIf23Year() {
        val cardData = new CardData(getUnknownCardNumber(), getValidMonth(), get23Year(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();
        payPage.shouldSuccessNotificationHidden();
    }

    // issue 2
    @Test
    public void shouldSuccessPayIf27Year() {
        val cardData = new CardData(getUnknownCardNumber(), getValidMonth(), get27Year(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();
        payPage.shouldSuccessNotificationHidden();
    }

    @Test
    public void shouldSuccessPayIfYearWithSigns() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getYearWithSigns(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 7
    @Test
    public void shouldSuccessPayIfYearEmptyField() {
        val cardData = new CardData(getApprovedCardNumber(), getValidMonth(), getYearEmptyField(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }
}

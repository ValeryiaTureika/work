package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class CardNumberPayFieldTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldFailurePaymentIfWrongBigCardNumber() {
        val cardData = new Data.CardData(getWrongBigCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();
    }

    @Test
    public void shouldFailurePaymentIfLettersCardNumber() {
        val cardData = new Data.CardData(getLettersNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldFailurePaymentIfShortUnknownCardNumber() {
        val cardData = new Data.CardData(getShortUnknownCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldFailurePaymentIfUnknownCardNumber() {
        val cardData = new Data.CardData(getUnknownCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();
    }

    @Test
    public void shouldFailurePaymentIfZerosCardNumber() {
        val cardData = new Data.CardData(getWithZerosCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();
    }

    @Test
    public void shouldFailurePaymentIfCardNumberWithSigns() {
        val cardData = new Data.CardData(getCardNumberWithSigns(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 5
    @Test
    public void shouldFailurePaymentIfCardNumberWithEmptyField() {
        val cardData = new Data.CardData(getCardNumberWithEmptyField(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }
}

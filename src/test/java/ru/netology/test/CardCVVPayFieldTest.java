package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class CardCVVPayFieldTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfCVCLetters() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCLetters());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCOneDigit());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCTwoDigits() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCTwoDigits());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCWithSigns());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCEmptyField());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }
}

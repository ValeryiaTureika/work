package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class CardMonthPayFieldTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfMonthMore12() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthMore12(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldSuccessPayIfLettersMonth() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getLettersMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithOneDigit(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithZeros() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithZeros(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithSigns(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 6
    @Test
    public void shouldSuccessPayIfMonthWithEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithEmptyField(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }
}

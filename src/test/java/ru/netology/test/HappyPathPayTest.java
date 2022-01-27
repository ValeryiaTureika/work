package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.data.SQL;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.data.Data.*;

class HappyPathPayTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldSuccessNotification();

        val expectedStatus = "APPROVED";
        val actualStatus = SQL.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    // issue 1
    @Test
    public void shouldFailurePayIfValidDeclinedCards() {
        val cardData = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();

        val expectedStatus = "DECLINED";
        val actualStatus = SQL.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }
}
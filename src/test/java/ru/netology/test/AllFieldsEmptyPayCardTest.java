package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class AllFieldsEmptyPayCardTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    // issue 12
    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(getCardNumberWithEmptyField(), getMonthWithEmptyField(), getYearEmptyField(), getNameEmptyField(), getCVCEmptyField());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
        payPage.shouldImproperFormatNotificationHidden();
    }
}

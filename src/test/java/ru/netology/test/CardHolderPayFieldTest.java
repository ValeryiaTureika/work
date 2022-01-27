package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;

public class CardHolderPayFieldTest extends ByUIFirstTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    // issue 3
    @Test
    public void shouldSuccessPayIfNameInRussia() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameInRussia(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    //  issue 4
    @Test
    public void shouldSuccessPayIfNameWithNumbers() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWithNumbers(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    //  issue 8
    @Test
    public void shouldSuccessPayIfNameWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWithSigns(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 9
    @Test
    public void shouldSuccessPayIfNameOne() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameOne(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 10
    @Test
    public void shouldSuccessPayIfOneLetter() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getOneLetter(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    // issue 11
    @Test
    public void shouldSuccessPayIfOwnerNameLong() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getOwnerNameLong(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfNameWithHyphens() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWithHyphens(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldSuccessNotification();
    }

    @Test
    public void shouldSuccessPayIfNameEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameEmptyField(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }
}

package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;

public class HappyPathOpeningFieldsTest extends ByUIFirstTest {

    @Test
    void shouldGetPaymentPage() {
        val mainPage = new MainPage();
        mainPage.payWithCard();
    }

    @Test
    void shouldGetCreditPage() {
        val mainPage = new MainPage();
        mainPage.payWithCredit();
    }
}

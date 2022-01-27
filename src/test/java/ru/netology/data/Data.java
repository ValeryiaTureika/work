package ru.netology.data;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class Data {

    private Data() {
    }

    public static Faker faker = new Faker(new Locale("en"));

    @Value
    @RequiredArgsConstructor
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    //number
    public static String getApprovedCardNumber() {
        return ("1111 2222 3333 4444");
    }

    public static String getDeclinedCardNumber() {
        return ("5555 6666 7777 8888");
    }

    public static String getWrongBigCardNumber() {
        return ("5555 6666 7777 9999 8564 033");
    }

    public static String getLettersNumber() {
        return ("ghjkkmeЛджарплл");
    }

    public static String getUnknownCardNumber() {
        return ("3782 8225 6310 0054");
    }

    public static String getShortUnknownCardNumber() {
        return ("3782 8225 6310 005");
    }

    public static String getWithZerosCardNumber() {
        return ("0000 0000 0000 0000");
    }

    public static String getCardNumberWithSigns() {
        return ("&&77 ///4 7856 ****");
    }

    public static String getCardNumberWithEmptyField() {
        return ("");
    }

    //month

    public static String getValidMonth() {
        LocalDate localDate = LocalDate.now();
        return String.format("%02d", localDate.getMonthValue());
    }

    public static String getMonthMore12() {
        return ("24");
    }

    public static String getLettersMonth() {
        return ("Gо");
    }

    public static String getMonthWithOneDigit() {
        return ("5");
    }

    public static String getMonthWithZeros() {
        return ("00");
    }

    public static String getMonthWithSigns() {
        return ("#/");
    }

    public static String getMonthWithEmptyField() {
        return ("");
    }

    //year

    public static String getValidYear() {
        return String.format("%ty", Year.now());
    }

    public static String getPastYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.minusYears(1));
    }

    public static String getLettersYear() {
        return ("Rт");
    }

    public static String getYearWithOneDigit() {
        return ("5");
    }

    public static String getLastYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(7));
    }

    public static String get23Year() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(1));
    }

    public static String get27Year() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(5));
    }

    public static String getYearWithSigns() {
        return ("#)");
    }

    public static String getYearEmptyField() {
        return ("");
    }

    //holder

    public static String getValidName() {
        return faker.name().fullName();
    }

    public static String getNameInRussia() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String getNameWithNumbers() {
        return "1234 4321";
    }

    public static String getNameWithSigns() {
        return "$^& %&*";
    }

    public static String getNameOne() {
        return faker.name().firstName();
    }

    public static String getOneLetter() {
        return "I";
    }

    public static String getOwnerNameLong() {
        return "ERdrdfyugnjl Sdrtfgyvhbujnmklpokijhyugtfrdeszeedxfcgvhb";
    }

    public static String getNameWithHyphens() {
        return "Fujhkjo Ghjjkop-Ghinijokop";
    }

    public static String getNameEmptyField() {
        return "";
    }

    //cvv

    public static String getCVC() {
        return "864";
    }

    public static String getCVCLetters() {
        return "tlm";
    }

    public static String getCVCOneDigit() {
        return "2";
    }

    public static String getCVCTwoDigits() {
        return "25";
    }

    public static String getCVCFourDigits() {
        return "2578";
    }

    public static String getCVCWithSigns() {
        return "$^&";
    }

    public static String getCVCEmptyField() {
        return "";
    }
}

package ru.praktikumservices.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountParameterizedTest {

    private final String userName;
    private final boolean expected;

    public AccountParameterizedTest(String userName, boolean expected) {
        this.userName = userName;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccountData() {
        return new Object[][] {
                {"Н Г", true}, // 3 символа в строке
                {"Нил Гейман", true}, //10 символов в строке
                {"Бенедикт Камбербэтч", true}, // 19 символов в строке
                {"NG", false}, // 2 символа в строке
                {"Константин Хабенский", false}, // 20 символов в строке
                {"", false}, // пустая строке
                {null, false}, // проверка, что нельзя передать null
                {" ", false}, // только пробел
                {"НилГейман", false}, // строка без пробела
                {"Нил  Гейман", false}, // 2 пробела в середине
                {" Нил Гейман", false}, // пробел в начале строки
                {"Нил Гейман ", false}, // пробел в конце строки
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account accountName = new Account(userName);
        boolean actual = accountName.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}

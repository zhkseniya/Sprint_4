package ru.praktikumservices.account;

public class Account {

    private static final String NAME_PATTERN = "(?=(^([а-яА-Яa-zA-Z])+\\s{1}+([а-яА-Яa-zA-Z])+$))(.{3,19})";

    private final String name;

    public Account(String name) {

        this.name = name;
    }

    // метод проверяет, что сохраненная строка с именем соответствует установленным требованиям:
    // - в строке не меньше 3 и не больше 19 символов,
    // - в строке есть только один пробел,
    // - пробел стоит не в начале и не в конце строки.
    public boolean checkNameToEmboss() {
        return name != null && name.matches(NAME_PATTERN);
    }
}

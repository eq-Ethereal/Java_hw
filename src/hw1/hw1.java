package hw1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hw1 {
    public static final String PHONE_REGEXP = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    public static final String EMAIL_REGEXP = "^.+([a-z0-9!#$%^&*?/'\\\";{}~)])@.+([a-z0-9!#$%^&*?/'\\\";{}~)])";
    public static final String FIO_SHIT_REGEXP = ".+([а-я]) .+([а-я]).+([а-я])";

    public static void main(String[] args) {
        String unMaskedString = "<client>(Какие то данные)<data>799 911-13344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        System.out.println("Inputted String is : " + unMaskedString);
        System.out.println(makeMyDataMasked(unMaskedString));

        unMaskedString = "<client>(Какие то данные)<data></data></client>";
        System.out.println("Inputted String is : " + unMaskedString);
        System.out.println(makeMyDataMasked(unMaskedString));

        unMaskedString = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        System.out.println("Inputted String is : " + unMaskedString);
        System.out.println(makeMyDataMasked(unMaskedString));

        unMaskedString = "";
        System.out.println("Inputted String is : " + unMaskedString);
        System.out.println(makeMyDataMasked(unMaskedString));
    }

    private static String makeMyDataMasked(String text) {
        if (text.length() == 0) {
            return "Empty string input, nothing to mask";
        }
        String mainMatchGroup = "";
        String subMatchGroup = "";
        String dataString = "";

        Pattern pattern = Pattern.compile("<client>(.+?)<data>(.+?)<\\/data>");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            subMatchGroup = matcher.group(1);
            mainMatchGroup = matcher.group(2);
        }

        String[] strings = mainMatchGroup.split(";");

        if (!strings[0].matches("")) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].matches(PHONE_REGEXP)) {
                    StringBuilder phone = new StringBuilder(strings[i].replaceAll("[ +()-]", ""));
                    for (int j = 4; j < 7; j++) {
                        phone.setCharAt(j, '*');
                    }
                    strings[i] = phone.toString();
                    continue;
                }
                if (strings[i].matches(EMAIL_REGEXP)) {
                    StringBuilder email = new StringBuilder(strings[i]);
                    email.setCharAt(email.indexOf("@") - 1, '*');
                    for (int j = email.indexOf("@") + 1; j < email.lastIndexOf("."); j++) {
                        email.setCharAt(j, '*');
                    }
                    strings[i] = email.toString();
                    continue;
                }
                if (strings[i].matches(FIO_SHIT_REGEXP)) {
                    String finalFioString;
                    String[] fioString = strings[i].split(" ");
                    StringBuilder sbFioString = new StringBuilder(fioString[0]);
                    for (int j = 1; j < sbFioString.length() - 1; j++) {
                        sbFioString.setCharAt(j, '*');
                    }
                    finalFioString = sbFioString.toString();
                    finalFioString += " " + fioString[1];
                    if (fioString.length > 2) {
                        finalFioString += " " + fioString[2].charAt(0) + ".";
                    }
                    strings[i] = finalFioString;
                }
            }
        } else {
            Pattern pattern1 = Pattern.compile("<client>(.+?)<data>");
            matcher = pattern1.matcher(text);
            if (matcher.find()) {
                return "<client>" + matcher.group(1) + "<data></data></client>";
            }
        }
        return "Masked string is : <client>" + subMatchGroup + "<data>" + Arrays.toString(strings).replaceAll("[\\[\\]]", "") + "</data></client>";
    }
}

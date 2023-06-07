import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTest {
  @Test
  void name() {
    // i18n = internationalization
    // l10n = localization
    Locale us = Locale.US;
    Locale ru = new Locale("ru", "RU", "win");

    NumberFormat usIntegers = NumberFormat.getIntegerInstance(us);
    NumberFormat ruIntegers = NumberFormat.getIntegerInstance(ru);

    int value = 1_000_000;
    assertThat(usIntegers.format(value)).isEqualTo("1,000,000");
    assertThat(ruIntegers.format(value)).isEqualTo("1 000 000");

    NumberFormat usPercents = NumberFormat.getPercentInstance(us);
    NumberFormat ruPercents = NumberFormat.getPercentInstance(ru);
    assertThat(usPercents.format(0.12)).isEqualTo("12%");
    assertThat(ruPercents.format(0.12)).isEqualTo("12 %");

    NumberFormat usCurrencies = NumberFormat.getCurrencyInstance(us);
    NumberFormat ruCurrencies = NumberFormat.getCurrencyInstance(ru);
    assertThat(usCurrencies.format(value)).isEqualTo("$1,000,000.00");
    assertThat(ruCurrencies.format(value)).isEqualTo("1 000 000,00 ₽");
  }

  @Test
  void dateFormatters() {
    Locale ru = new Locale("ru", "RU", "win");

    DateFormat ruDateTime = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL, Locale.UK);
    String format = ruDateTime.format(new Date());
    System.out.println(format);
  }

  @Test
  void internationalizationAndLocalization() {
    Locale ru = new Locale("ru", "RU", "win");
    Locale us = Locale.US;

    String input_username = "input_username";

    ResourceBundle ruBundle = ResourceBundle.getBundle("messages", ru);
    ResourceBundle usBundle = ResourceBundle.getBundle("messages", us);

    System.out.println(ruBundle.getString(input_username));
    System.out.println(usBundle.getString(input_username));
  }
}

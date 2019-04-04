package fr.insalyon.telecom.mgl;

import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {

  RomanNumberConverter converter;

  @Before
  public void setup() {
    converter = new RomanNumberConverter();
  }

  @Test
  public void check_dictionnary() {
    assertThat(converter.convert("I"))
      .isEqualTo(1);
    assertThat(converter.convert("V"))
      .isEqualTo(5);
    assertThat(converter.convert("X"))
      .isEqualTo(10);
    assertThat(converter.convert("L"))
      .isEqualTo(50);
    assertThat(converter.convert("C"))
      .isEqualTo(100);
    assertThat(converter.convert("D"))
      .isEqualTo(500);
    assertThat(converter.convert("M"))
      .isEqualTo(1000);
  }

  @Test
  public void simple_roman_to_decimal() {
    assertThat(converter.convert("XV")).isEqualTo(15);
  }

  @Test
  public void difficult_roman_to_decimal() {
    assertThat(converter.convert("IX")).isEqualTo(9);
  }

  @Test
  public void super_difficult_roman_to_decimal() {
    assertThat(converter.convert("MCMLXXXIV")).isEqualTo(1984);
  }

  @Test
  public void check_reversed_dictionnary() {
    assertThat(converter.convert(1)).isEqualTo("I");
    assertThat(converter.convert(1000)).isEqualTo("M");
  }
}

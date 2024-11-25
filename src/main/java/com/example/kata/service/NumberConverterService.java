
package com.example.kata.service;

import org.springframework.stereotype.Service;

@Service
public class NumberConverterService {
  public String convertNumber(int number) {
    StringBuilder result = new StringBuilder();
    if (number % 3 == 0) result.append("FOO");
    if (number % 5 == 0) result.append("BAR");
    result.append(processNumber(number));
    return !result.isEmpty() ? result.toString() : String.valueOf(number);
  }

  private String processNumber(int number) {
    StringBuilder result = new StringBuilder();
    String numberStr = String.valueOf(number);
    for (char c : numberStr.toCharArray()) {
      if (c == '3') result.append("FOO");
      if (c == '5') result.append("BAR");
      if (c == '7') result.append("QUIX");
    }
    return result.toString();
  }
}

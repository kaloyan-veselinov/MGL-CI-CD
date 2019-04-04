package fr.insalyon.telecom.mgl;

import java.util.HashMap;
import java.lang.Integer;
import java.lang.Character;
import java.lang.StringBuilder;
import java.util.stream.Collectors;
import java.util.Map;


public class RomanNumberConverter{
  private HashMap<Character, Integer> dictionnary = new HashMap<>();
  private HashMap<Integer, Character> reversedDictionnary = new HashMap<>();

  public RomanNumberConverter(){
    dictionnary.put('I', 1);
    dictionnary.put('V', 5);
    dictionnary.put('X', 10);
    dictionnary.put('L', 50);
    dictionnary.put('C', 100);
    dictionnary.put('D', 500);
    dictionnary.put('M', 1000);

    reversedDictionnary.put(1, 'I');
    reversedDictionnary.put(5, 'V');
    reversedDictionnary.put(10, 'X');
    reversedDictionnary.put(50, 'L');
    reversedDictionnary.put(100, 'C');
    reversedDictionnary.put(500, 'D');
    reversedDictionnary.put(1000, 'M');
  }

  public int convert(String romanNumber){
    char[] inversedRomanNumber = new StringBuilder(romanNumber).reverse().toString().toCharArray();
    int somme = 0;
    int previous = 0;
    int current;
    for(Character c:inversedRomanNumber) {
      current = dictionnary.get(c);
      if(current < previous) {
        somme -= current ;
      } else {
        somme += current;
      }
      previous = current;
    }
    return somme;
  }

  public String convert(int decimalNumber){
    String romanNumber = ""+reversedDictionnary.get(decimalNumber);
    return romanNumber;
  }
}

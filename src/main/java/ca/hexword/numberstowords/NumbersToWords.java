/*
   Copyright 2024 Hammad Rauf <rauf.hammad@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package ca.hexword.numberstowords;

import java.math.BigDecimal;

/**
 *
 * @author hammad
 */
public class NumbersToWords {

    public static void main(String[] args) {
        System.out.println("Number to Words");
        System.out.println("===============\n");
        BigDecimal n1 = new BigDecimal(516328376.543d);
        //BigDecimal n1 = new BigDecimal(576.543d);
        String fmtstr = String.format("%.04f", n1);
        System.out.println("Number to convert: " + fmtstr + "\n");
        System.out.println("Output:");
        System.out.println(CONVERT_NUMBER_TO_WORDS(n1, "dollars", "cents", 2));

    }

    public static String CONVERT_NUMBER_TO_WORDS(BigDecimal number, String currencyNoteName, String currencyCoinName, int coinPlaces) {
        String words_out = "";
        long whole = floatToWholePart(number);
        int decimal = floatToDecimalPart(number, coinPlaces);
        
        String words = convertOuter(whole, 0);
        String words2 = capitalizeFirstWord(words);
        words2 += " " +currencyNoteName;
              
        if (decimal!=0) {
            String dwords = convertOuter(decimal, 0);
            dwords += " " +currencyCoinName;
            words_out = words2 + " and " + dwords;
        }
        else
            words_out = words2;
        return words_out;
    }

    private static String capitalizeFirstWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split("\\s+");
        words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);

        return String.join(" ", words);
    }

    private static long floatToWholePart(BigDecimal value) {
        double value2 = value.doubleValue();
        long wholePart = (long) value2;

        return (wholePart);
    }

    private static int floatToDecimalPart(BigDecimal value, int coinPlaces) {
       long iPart;
       double fPart;
       int decimalPart;
       double value2 = value.doubleValue();
       int factor = (int) Math.pow(10, coinPlaces);
       
       iPart = (long) value2;
       fPart = value2 - iPart;
       decimalPart = (int)(fPart*factor);
       
       return (decimalPart);
    }


    private static String convertOuter(long numb, int depth) {
        String words = "", words2 = "";
        String part_words = "";
        String part_xx = "", part_xword = "";
        long part_bigger = 0;
        long small_part = 0;
        int last3 = 0;

        if (numb < 1000) {
            words = convertInner(numb);
        } else {
            part_bigger = numb / 1000;
            small_part = numb - (part_bigger * 1000);
            part_words = convertOuter(part_bigger, depth + 1);

            if (part_bigger > 1000) {
                String st = String.valueOf(part_bigger);
                String se = st.substring(st.length() - 3);
                last3 = Integer.parseInt(se);
            } else {
                last3 = (int) part_bigger;
            }
            if (last3 > 0) {
                part_words += " ";
            }
            part_xx = "";
            do {
                part_xx += "X";
                depth--;
            } while (depth >= 0);
            part_xword = matchXtoWords(part_xx);
            if (last3 > 0) {
                part_words += part_xword;
                part_words += " ";
            }

            words2 = convertInner(small_part);
            words = part_words + words2;
        }
        return words;
    }

    private static String convertInner(long numb) {
        String words = "";
        String wordTen = "";
        int hundred = 0;
        int tens = 0;
        int units = 0;
        boolean teens = false;

        if ((numb < 1000) & (numb > 0)) {
            hundred = (int) numb / 100;
            numb -= (hundred * 100);
            tens = (int) numb / 10;
            numb -= (tens * 10);
            units = (int) numb;
        }

        words += matcher(hundred, 100);
        if (hundred != 0) {
            words += " hundred";
        }
        wordTen += matcher(tens, 10);
        if ((wordTen.compareTo("ten") == 0) && (units > 0)) {
            teens = true;
            switch (units) {
                case 1:
                    wordTen = "eleven";
                    break;
                case 2:
                    wordTen = "twelve";
                    break;
                case 3:
                    wordTen = "thirteen";
                    break;
                case 4:
                    wordTen = "fourteen";
                    break;
                case 5:
                    wordTen = "fifteen";
                    break;
                case 6:
                    wordTen = "sixteen";
                    break;
                case 7:
                    wordTen = "seventeen";
                    break;
                case 8:
                    wordTen = "eighteen";
                    break;
                case 9:
                    wordTen = "nineteen";
                    break;
                case 0:
                    break;
            }
        }
        if ((hundred != 0) && ((tens != 0) || (units != 0))) {
            words += " ";
        }
        words += wordTen;
        if ((!teens) && (hundred != 0) && (tens != 0) && (units != 0)) {
            words += " ";
        } else if ((!teens) || (hundred != 0) || (tens != 0)) {
            words += " ";
        }
        if (!teens) {
            words += matcher(units, 1);
        }

        return words;
    }

    private static String matcher(int digit, int placeValue) {
        String result = "";

        if ((placeValue == 1) | (placeValue == 100)) {
            switch (digit) {
                case 1:
                    result = "one";
                    break;
                case 2:
                    result = "two";
                    break;
                case 3:
                    result = "three";
                    break;
                case 4:
                    result = "four";
                    break;
                case 5:
                    result = "five";
                    break;
                case 6:
                    result = "six";
                    break;
                case 7:
                    result = "seven";
                    break;
                case 8:
                    result = "eight";
                    break;
                case 9:
                    result = "nine";
                    break;
                case 0:
                    result = "";
            }
        }

        if (placeValue == 10) {
            switch (digit) {
                case 1:
                    result = "ten";
                    break;
                case 2:
                    result = "twenty";
                    break;
                case 3:
                    result = "thirty";
                    break;
                case 4:
                    result = "forty";
                    break;
                case 5:
                    result = "fifty";
                    break;
                case 6:
                    result = "sixty";
                    break;
                case 7:
                    result = "seventy";
                    break;
                case 8:
                    result = "eighty";
                    break;
                case 9:
                    result = "ninety";
                    break;
                case 0:
                    result = "";
            }
        }

        return result;
    }

    private static String matchXtoWords(String xs) {
        String result = "";

        if (xs.compareTo("X") == 0) {
            result = "thousand";
        } else if (xs.compareTo("XX") == 0) {
            result = "million";
        } else if (xs.compareTo("XXX") == 0) {
            result = "billion";
        } else if (xs.compareTo("XXXX") == 0) {
            result = "trillion";
        } else if (xs.compareTo("XXXXX") == 0) {
            result = "quadrillion";
        } else if (xs.compareTo("XXXXXX") == 0) {
            result = "quintillion";
        } else if (xs.compareTo("XXXXXXX") == 0) {
            result = "sextillion";
        } else if (xs.compareTo("XXXXXXXX") == 0) {
            result = "septillion";
        } else if (xs.compareTo("XXXXXXXXX") == 0) {
            result = "octillion";
        } else if (xs.compareTo("XXXXXXXXXX") == 0) {
            result = "nonillion";
        } else if (xs.compareTo("XXXXXXXXXXX") == 0) {
            result = "decillion";
        } else if (xs.compareTo("XXXXXXXXXXXX") == 0) {
            result = "undecillion";
        } else if (xs.compareTo("XXXXXXXXXXXXX") == 0) {
            result = "duodecillion";
        } else {
            result = xs;
        }

        return result;
    }

}

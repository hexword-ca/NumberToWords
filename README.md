# Number To Words
A Java Method to convert Numbers to Words, for use in Cheque Printing.

## Sample Run - Output
```
C:\> java -jar target/NumbersToWords-0.1-SNAPSHOT.jar
Number to Words
===============

Number to convert: 51328376.54

Output:
Fifty one million three hundred twenty eight thousand three hundred seventy six dollars and fifty four cents
```
## Web Page
[https://andromedabay.ddns.net/number-to-words-in-java/](https://andromedabay.ddns.net/number-to-words-in-java/)

## Method Parameters

<table border="1" cellspacing="0" style="margin-left: auto; margin-right: auto;" >
<thead><tr class="row-1 odd"><th colspan="3" class="column-1">Parameters for NumberToWords (in Java)</th></tr></thead>
<tbody class="row-hover"><tr class="row-2 even">
<td rowspan="3" class="column-1">1</td><td class="column-2">Name</td><td class="column-3">Number</td></tr>
<tr class="row-3 odd"><td class="column-2">Data-Type</td><td class="column-3">BigDecimal</td></tr>
<tr class="row-4 even"><td class="column-2">Description</td>
<td class="column-3">The Double or Float numeric value which needs to be converted into words.</td></tr>
<tr class="row-5 odd"><td rowspan="3" class="column-1">2</td><td class="column-2">Name</td><td class="column-3">currencyNote</td></tr>
<tr class="row-6 even"><td class="column-2">Data-Type</td><td class="column-3">String</td></tr>
<tr class="row-7 odd"><td class="column-2">Description</td><td class="column-3">The currency name that will appear in the output for the whole number part.</td></tr>
<tr class="row-8 even"><td rowspan="3" class="column-1">3</td><td class="column-2">Name</td><td class="column-3">currencyCoin</td></tr>
<tr class="row-9 odd"><td class="column-2">Data-Type</td><td class="column-3">String</td></tr>
<tr class="row-10 even"><td class="column-2">Description</td><td class="column-3">The currency coin name that will appear in the output for the fractional number part.</td></tr>
<tr class="row-11 odd"><td rowspan="3" class="column-1">4</td><td class="column-2">Name</td><td class="column-3">coinPlaces</td></tr>
<tr class="row-12 even"><td class="column-2">Data-Type</td><td class="column-3">Integer</td></tr>
<tr class="row-13 odd"><td class="column-2">Description</td><td class="column-3">Number of digits in the coin output. For example for Dollar and Cents it should be 2. For some currency like Bahraini Dinar and Fills it will be 3.</td></tr>
</tbody>
</table>

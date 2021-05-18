# CipherChef-Zadania

W celu sprawdzenia poprawności swojego rozwiązania możesz odkomentować odpowiednie linie w klasie Main i uruchomić program.

## Zadanie 1

Uzupełnij funkcję encrypt() znajdującą się w klasie Monoalfabetic tak aby poprawnie szyfrowała input. \
Uwzględnij ewentualne białe znaki pojawiające się w tekście.

## Zadanie 2

Uzupełnij metodę generateMatrix() znajdującą się w klasie Playfair, tak aby wypełniła ona macierz "matrix" (z linii 6) zgodnie z szyfrem Playfair'a 
Aby usunąć powtarzające się znaki możesz skorzystać z metody removeDuplicateCharacters(). 


## Zadanie 3
Uzupełnij funkcję soundMorseCode() znajdującą się w klasie MorseCode, tak aby odtworzyć wiadomość z funkcji Main \
Przejdź przez otrzymaną wiadomość i w zależności od znaku (dot lub dash) odtwórz odpowiedni dźwięk 
Pamiętaj o uwzględnieniu spacji (przerwa między literami) oraz slashy (przerwa między słowami) 
Możesz skorzystać z gotowej funkcji w8(), możesz skorzystać z metody Clip.setMicrosecondPosition(0); 


## Zadanie 4
Uzupełnij funkcję encrypt() znajdującą się w klasie AES, tak aby szyfrowała ona wybranym algorytmem AES otrzymany na wejściu ciąg znaków (inputString). 
Proszę wykorzystać zmienną algorithm jako argument metody Cipher.getInstance oraz pamiętać o tym że
oprócz algorytmu ECB wszystkie pozostąłe wykorzystują wektor inicjalizacyjny 
ProTip: W razie trudności posiłkuj się metodą decrypt() 


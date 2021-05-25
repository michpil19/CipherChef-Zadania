package Classes;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MorseCode extends EncryptionMethod{

    Map<Character, String> letterToMorse = new HashMap<Character, String>();
    Map<String, Character> morseToLetter = new HashMap<String, Character>();

    public MorseCode(String plainText) {
        setLetterToMorse();
        setMorseToLetter();
        setInput(plainText.toLowerCase());
    }

    public MorseCode() {
        super.setName("MorseCode");
        setLetterToMorse();
        setMorseToLetter();
    }

    public void setLetterToMorse() {// . -
        letterToMorse.put('a', ".-");
        letterToMorse.put('ą', ".-");
        letterToMorse.put('b', "-...");
        letterToMorse.put('c', "-.-.");
        letterToMorse.put('ć', "-.-.");
        letterToMorse.put('d', "-..");
        letterToMorse.put('e', ".");
        letterToMorse.put('ę', ".");
        letterToMorse.put('f', "..-.");
        letterToMorse.put('g', "--.");
        letterToMorse.put('h', "....");
        letterToMorse.put('i', "..");
        letterToMorse.put('j', ".---");
        letterToMorse.put('k', "-.-");
        letterToMorse.put('l', ".-..");
        letterToMorse.put('ł', ".-..");
        letterToMorse.put('m', "--");
        letterToMorse.put('n', "-.");
        letterToMorse.put('ń', "-.");
        letterToMorse.put('o', "---");
        letterToMorse.put('ó', "---");
        letterToMorse.put('p', ".--.");
        letterToMorse.put('q', "--.-");
        letterToMorse.put('r', ".-.");
        letterToMorse.put('s', "...");
        letterToMorse.put('ś', "...");
        letterToMorse.put('t', "-");
        letterToMorse.put('u', "..-");
        letterToMorse.put('v', "...-");
        letterToMorse.put('w', ".--");
        letterToMorse.put('x', "-..-");
        letterToMorse.put('y', "-.--");
        letterToMorse.put('z', "--..");
        letterToMorse.put('ź', "--..");
        letterToMorse.put('ż', "--..");

        letterToMorse.put('1', ".----");
        letterToMorse.put('2', "..---");
        letterToMorse.put('3', "...--");
        letterToMorse.put('4', "....-");
        letterToMorse.put('5', ".....");
        letterToMorse.put('6', "-....");
        letterToMorse.put('7', "--...");
        letterToMorse.put('8', "---..");
        letterToMorse.put('9', "----.");
        letterToMorse.put('0', "-----");


        letterToMorse.put(' ', "/");
    }

    public void setMorseToLetter() {// . -
        morseToLetter.put(".-",'a');
        morseToLetter.put("-...",'b');
        morseToLetter.put("-.-.",'c');
        morseToLetter.put("-..",'d');
        morseToLetter.put(".",'e');
        morseToLetter.put("..-.",'f');
        morseToLetter.put("--.",'g');
        morseToLetter.put("....",'h');
        morseToLetter.put("..",'i');
        morseToLetter.put(".---",'j');
        morseToLetter.put("-.-",'k');
        morseToLetter.put(".-..",'l');
        morseToLetter.put("--",'m');
        morseToLetter.put("-.",'n');
        morseToLetter.put("---",'o');
        morseToLetter.put(".--.",'p');
        morseToLetter.put("--.-",'q');
        morseToLetter.put(".-.",'r');
        morseToLetter.put("...",'s');
        morseToLetter.put("-",'t');
        morseToLetter.put("..-",'u');
        morseToLetter.put("...-",'v');
        morseToLetter.put(".--",'w');
        morseToLetter.put("-..-",'x');
        morseToLetter.put("-.--",'y');
        morseToLetter.put("--..",'z');

        morseToLetter.put(".----",'1');
        morseToLetter.put("..---",'2');
        morseToLetter.put("...--",'3');
        morseToLetter.put("....-",'4');
        morseToLetter.put(".....",'5');
        morseToLetter.put("-....",'6');
        morseToLetter.put("--...",'7');
        morseToLetter.put("---..",'8');
        morseToLetter.put("----.",'9');
        morseToLetter.put("-----",'0');

        morseToLetter.put("/", ' ');
    }
    public void encrypt() {
        String encryptedInMorse = "";
        for(int i = 0; i < getInput().length();i++){
            String currentSign = letterToMorse.get(getInput().charAt(i));//getinput to teskt do zaszyfrowania
            encryptedInMorse += currentSign + " ";
        }
        setOutput(encryptedInMorse);
    }

    public void decrypt() {//litery w kodzie morsa odseparowuje sie spacjami a slowa "/"
        String decrypted = "";
        String messageInMorseWithSpaces = getInput()+" ";//dodanie jednej spacji pozwala na działanie prostszego algorytmu w petli potem
        ArrayList<String> morseCodeMessage = new ArrayList<String>();

        String letter = "";
        for(int i = 0; i < messageInMorseWithSpaces.length();i++) {
            if(messageInMorseWithSpaces.charAt(i) ==  ' '){
                morseCodeMessage.add(letter);///!- tu jest problem
                letter = "";
            }else{
                letter += messageInMorseWithSpaces.charAt(i);
            }

        }

        int counter = 0;
        while(counter < morseCodeMessage.size()){
            if(morseCodeMessage.get(counter) == ""){
                morseCodeMessage.remove(counter);
            }else{
                counter++;
            }
        }

        for(int i = 0; i < morseCodeMessage.size();i++){ //porwnuje przechowywane ciagi z arraylisty do mapy i zamieniam na normalna wiadomosc
                String cellContent = morseCodeMessage.get(i);
                char a = morseToLetter.get(cellContent);
                decrypted += a;

        }
        setOutput(decrypted);
    }

    public static void w8(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void soundMorseCode(String sequence) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File long_sig = new File("src/long_signal.wav");
        AudioInputStream audioStreamLong = AudioSystem.getAudioInputStream(long_sig);
        Clip clip_long = AudioSystem.getClip();
        clip_long.open(audioStreamLong);

        File short_sig = new File("src/short_signal.wav");
        AudioInputStream audioStreamShort = AudioSystem.getAudioInputStream(long_sig);
        Clip clip_short = AudioSystem.getClip();
        clip_short.open(audioStreamLong);


        long lenOflong = clip_long.getMicrosecondLength()/1000;//μs to ms
        long lenOfshort = clip_long.getMicrosecondLength()/1000;//μs to ms

        //Zadanie3
        //Uzupełnij funkcję soundMorseCode() tak aby odtworzyć wiadomość z funkcji Main
        //Przejdź przez otrzymaną wiadomość i w zależności od znaku (dot lub dash) odtwórz odpowiedni dźwięk
        //Pamiętaj o uwzględnieniu spacji (przerwa między literami) oraz slashy (przerwa między słowami)
        //Możesz skorzystać z gotowej funkcji w8(), możesz skorzystać z metody Clip.setMicrosecondPosition(0);
        //W celu sprawdzenia poprawności swojego rozwiązania możesz odkomentować odpowiednie linie w klasie Main i uruchomić program

    }

    @Override
    public void setInput(String input) {
        super.setInput(input.toLowerCase());
    }

    public Map<Character, String> getLetterToMorse() {
        return letterToMorse;
    }

    public Map<String, Character> getMorseToLetter() {
        return morseToLetter;
    }
}

import java.util.HashMap;

public class Validator implements  ValidatorInterface{

    private static int counter = 10;
    private static HashMap<Character, Integer> lettersToIntegerMap = new HashMap<>();

    static {
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            lettersToIntegerMap.put(alphabet, counter);
            counter++;
        }

        counter = 0;
        for (char i = '0'; i <= '9'; i++) {
            lettersToIntegerMap.put(i, counter);
            counter++;
        }
    }

    public Validator() {
    }

    @Override
    public boolean validate(String idDocument) {

        int numbersOfCharIdDokument = 9;
        if (idDocument == null || checkLenghtIdDocument(idDocument) != numbersOfCharIdDokument) {
            return false;
        }

        if (!checkStructureIdDocument(idDocument)) {
            return false;
        }

        if (!checkControlNumber(idDocument)) {
            return false;
        }

        return true;

    }

    private int checkLenghtIdDocument(String idDoc) {
        return idDoc.length();
    }

    private boolean checkStructureIdDocument(String idDoc) {
        return idDoc.matches("[A-Z]{3}[0-9]{6}");
    }

    private boolean checkControlNumber(String idDoc) {

        int checkNumber = 0;

        for (int i = 0; i < idDoc.length(); i++) {

            Integer a = lettersToIntegerMap.get(idDoc.charAt(i));

            switch(i) {
                case 0 : checkNumber = a * 7;
                    break;
                case 1 :
                    checkNumber += a * 3;
                    break;
                case 2 :
                    checkNumber += a * 1;
                    break;
                case 3 :
                    checkNumber += a * 9;
                    break;
                case 4 :
                    checkNumber += a * 7;
                    break;
                case 5 :
                    checkNumber += a * 3;
                    break;
                case 6 :
                    checkNumber += a * 1;
                    break;
                case 7 :
                    checkNumber += a * 7;
                    break;
                case 8 :
                    checkNumber += a * 3;
                    break;
            }
        }

        return checkNumber%10 == 0;
    }

}

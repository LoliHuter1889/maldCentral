// Group Name (e.g. GXTX) : 
// 
// Instructions  
// 1. You will only submit this file and output_data10000.txt_verify1000.txt.txt in eLearn
// 2. You are only allowed to use the Java Standard Library classes
// 3. Do not modify the variables and methods given except for the implementation of HashCode()
// 4. You can create additional Private variables and methods
// 5. Do not modify any other files to execute the application
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class DNASequence {
    private String sequence;
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public DNASequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public String toString() {
        return sequence;
    }

    private String getValue(char c) {
        switch (c) {
            case 'A':
                return "00";
            case 'C':
                return "01";
            case 'G':
                return "10";
            case 'T':
                return "11";
            default:
                return "";
        }
    }

    public int hashCode() {
        if (map.containsKey(sequence))
            return map.get(sequence);

        StringBuilder sequenceAsBinaryBuilder = new StringBuilder();
        int c = 1;
        for (char DNAChar : sequence.toCharArray()) {
            switch (DNAChar) {
                case 'A':
                    sequenceAsBinaryBuilder.append("00");
                    break;
                case 'C':
                    sequenceAsBinaryBuilder.append("01");
                    break;
                case 'G':
                    sequenceAsBinaryBuilder.append("10");
                    break;
                case 'T':
                    sequenceAsBinaryBuilder.append("11");
                    break;
                default:
                    break;
            }
            if (c % 8 == 0)
                sequenceAsBinaryBuilder.append(" ");
            c++;
        }

        String[] splitted = sequenceAsBinaryBuilder.toString().split(" ");
        int hash = Integer.parseInt(splitted[0], 2);

        Set<Entry<String, Integer>> enntries = map.entrySet();
        for (Entry<String, Integer> entry : enntries) {
            if (countDif(sequence, entry.getKey()) <= 5)
                return entry.getValue();
        }

        map.put(sequence, hash);
        return hash;
    }

    private int countDif(String myString, String myString1) {
        int i = 0;
        int count = 0;
        int length = myString.length();
        while (i < length) {
            if (myString.charAt(i) != myString1.charAt(i)) {
                count++;
            }
            i++;
        }
        return count;
    }

    private List<String> shingle(String text, int k) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < text.length() - k; i++) {
            list.add(text.substring(i, i + k));
        }

        return list;
    }

}


// Group Name (e.g. GXTX) : 
// 
// Instructions  
// 1. You will only submit this file and output_data10000.txt_verify1000.txt.txt in eLearn
// 2. You are only allowed to use the Java Standard Library classes
// 3. Do not modify the variables and methods given except for the implementation of HashCode()
// 4. You can create additional Private variables and methods
// 5. Do not modify any other files to execute the application
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class DNASequence {

    private String sequence;

    public DNASequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return sequence;
    }

    public String toString() {
        return sequence;
    }

    // Start Of Implementation Here:

    // private static String dataFile = "data10000.txt";
    // private static LinkedList<String> dnaList = new LinkedList<>();

    // //readData from the data10000txt file, add inside a new hashMap, remove the
    // sequence entry
    // public static void readData(String sequence) {
    // try (Scanner sc = new Scanner(new File(dataFile))) {
    // while (sc.hasNext()) {
    // //dnaList.add(new DNASequence(sc.next())); //populate the SLL with all the
    // sequences from txt
    // dnaList.add(sc.next());
    // }
    // } catch (FileNotFoundException ex) {
    // System.out.println("Data File not found");
    // }
    // }
    // only modify HashCode!

    // all methods static; private constructor.


    /**
     * Generates 32 bit hash from byte array of the given length and
     * seed.
     * 
     *  data   byte array to hash
     *  length length of the array to hash
     *  seed   initial seed value
     * return 32 bit hash of the given array
     */
    public static int hash32(final byte[] data, int length, int seed) {
        // 'm' and 'r' are mixing constants generated offline.
        // They're not really 'magic', they just happen to work well.
        final int m = 0x5bd1e995;
        final int r = 24;

        // Initialize the hash to a random value
        int h = seed ^ length;
        int length4 = length / 4;

        for (int i = 0; i < length4; i++) {
            final int i4 = i * 4;
            int k = (data[i4 + 0] & 0xff) + ((data[i4 + 1] & 0xff) << 8)
                    + ((data[i4 + 2] & 0xff) << 16) + ((data[i4 + 3] & 0xff) << 24);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }

        // Handle the last few bytes of the input array
        switch (length % 4) {
            case 3:
                h ^= (data[(length & ~3) + 2] & 0xff) << 16;
            case 2:
                h ^= (data[(length & ~3) + 1] & 0xff) << 8;
            case 1:
                h ^= (data[length & ~3] & 0xff);
                h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;

        return h;
    }

   
    public int hashCode() {
        byte[] byteArr = sequence.getBytes();
        
        return hash32(byteArr, 8, 10007);
        //123123
    
        //return 0;
    }
}

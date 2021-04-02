import java.lang.Math;
import java.util.Scanner;

class Encryptor {

    /* Encrypts a given string using the method described in README.md
     *
     * @param s a string to be encrypted. The spec gives the length a range
     *      of 1 <= len <= 81, but it will work for all strings
     * @return The encrypted string
     *
     * @pre s contains no whitespace and is not empty
     * */
    private static String encrypt(String s) {
        // gets the number of columns in the 'matrix' that the string is transformed to
        int cols = (int)Math.ceil(Math.sqrt(s.length()));

        // separate iterators for index and column since we don't make a 2d array
        int curr_col = 0;
        int index = 0;
        StringBuilder encryptBuilder = new StringBuilder();
        while(curr_col < cols) {
            encryptBuilder.append(s.charAt(index));
            index += cols;
            if(index >= s.length()) {
                curr_col++;
                index = curr_col;
                encryptBuilder.append(' ');
            }
        }

        return encryptBuilder.toString();
    }
    
    /* Prints usage instructions for the program to stderr and exits with a nonzero exit code
     * 
     * @post execution will terminate
     */
    private static void printUsage() {
        System.err.println("Please either give a string through command line arguments or pipe one in");
        System.err.println("Examples:");
        System.err.println("\tjava Encryptor have a nice day");
        System.err.println("\tjava Encryptor \"lets walk the dog\"");
        System.err.println("\tjava Encryptor < input.txt");
        System.err.println("\techo 'chill out' | java Encryptor");

        System.exit(-1);
    }


    public static void main(String[] args) {
        // if there are args, joins those args and encrypts, otherwise
        // try to read piped data, else, print usage

        if(args.length > 0) {
            String argsString = String.join("", args).replaceAll("\\s", "");
            if(argsString.isEmpty()) {
                printUsage();
            }
            System.out.println(encrypt(argsString));
        }
        else {
            StringBuilder stdinBuilder = new StringBuilder();
            Scanner stdinScanner = new Scanner(System.in);
            while(stdinScanner.hasNextLine()) {
                stdinBuilder.append(stdinScanner.nextLine());
            }
            stdinScanner.close();
            String stdinString = stdinBuilder.toString().replaceAll("\\s", "");
            if(stdinString.isEmpty()) {
                printUsage();
            }
            else {
                System.out.println(encrypt(stdinString));
            }
        }

    }
}




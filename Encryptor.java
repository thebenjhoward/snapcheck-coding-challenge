import java.lang.Math;
import java.util.Scanner;

class Encryptor {
    private static String encrypt(String s) {
        s = s.replaceAll("\\s", "");
        int cols = (int)Math.ceil(Math.sqrt(s.length()));
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


    public static void main(String[] args) {
        // if there are args, joins those args and encrypts, otherwise
        // try to read piped data, else, print usage

        if(args.length > 0) {
            System.out.println(encrypt(String.join("", args)));
        }
        else {
            StringBuilder stdinBuilder = new StringBuilder();
            Scanner stdinScanner = new Scanner(System.in);
            while(stdinScanner.hasNextLine()) {
                stdinBuilder.append(stdinScanner.nextLine());
            }
            stdinScanner.close();
            String stdinString = stdinBuilder.toString();
            if(stdinString.isBlank()) {
                System.err.println("Please either give a string through command line arguments or pipe one in");
                System.err.println("Examples:");
                System.err.println("\tjava Encryptor have a nice day");
                System.err.println("\tjava Encryptor \"lets walk the dog\"");
                System.err.println("\tjava Encryptor < input.txt");
                System.err.println("\techo 'chill out' | java Encryptor");
            }
            else {
                System.out.println(encrypt(stdinString));
            }
        }

    }
}




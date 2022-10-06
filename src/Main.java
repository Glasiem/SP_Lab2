import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int k = 2;

    private static int alphabetPower;

    private static HashSet<Character> alphabet = new HashSet<>();

    private static int statusPower;

    private static List<MyNode> statuses = new ArrayList<>();

    private static int statusFinalPower;

    private static HashSet<Integer> statusFinal = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\in.txt");
        Scanner input = new Scanner(file);

        alphabetPower = input.nextInt();
        for (int i = 0; i < alphabetPower; i++) {
            alphabet.add((char)(i+65));
        }

        statusPower = input.nextInt();
        for (int i = 0; i < statusPower; i++) {
            statuses.add(new MyNode());
        }

        statuses.get(input.nextInt()).setStart();
//        System.out.println(statuses.get(1).getState());

        statusFinalPower = input.nextInt();
        for (int i = 0; i < statusFinalPower; i++) {
            int temp = input.nextInt();
            statusFinal.add(temp);
        }

        while(input.hasNextLine())
        {
            statuses.get(input.nextInt()).addLink(input.next().charAt(0),input.nextInt());
        }

        for (int i = 0; i < k; i++) {
            for (MyNode status: statuses) {
                if ((status.getState() == 2) || (status.getState() == 3)){
                    status.statusProceed(statuses);
                }
            }
            for (MyNode status: statuses) {
                status.checkState();
            }
        }
        for (int i = 0; i < statusPower; i++) {
            if ((statuses.get(i).getState() == 2) && (statusFinal.contains(i))) {
                System.out.print(statuses.get(i).getPath());
                return;
            }
        }
        System.out.print("There`s no suitable words of length " + k);
    }
}
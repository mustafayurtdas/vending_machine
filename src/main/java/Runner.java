import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {

        start();

    }

    private static void start() {
        Process process =new Process();
        process.fillList();
        process.showList();
        process.process();

    }
}

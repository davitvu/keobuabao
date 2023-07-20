import java.util.Scanner;

public class keo_bua_bao {
    public static void main(String[] args) {
        while(true) {
            Game game = new Game();
            String computePick = game.getComputePick();
            String userPick = game.getUserPick();
            String result = game.getResult(computePick, userPick);

            Scanner sc = new Scanner(System.in);

            System.out.println("Ban chon: " + userPick);
            System.out.println("May chon: " + computePick);
            if(result.equals("hoa")) {
                System.out.println("Ket qua: " + result);
            } else {
                System.out.println("Ket qua: Ban " + result);
            }

            System.out.print("Ban co muon choi tiep? (y/n): ");
            String playAgain = sc.nextLine();
            if(!(playAgain.equals("y"))) {
                break;
            }
        }
    }
}

class Game {
    String userPick;
    String computePick;
    String result;

    String getComputePick() {
        String computePick;
        int random = (int) (Math.random() * 3) + 1;

        if(random == 1) {
            computePick = "keo";
        } else if (random == 2) {
            computePick = "bua";
        } else {
            computePick = "la";
        }
        return computePick;
    }

    String getUserPick() {
        Scanner sc = new Scanner(System.in);
        String userPick;
        while(true) {
            System.out.print("Nhap dam, la hoac keo: ");
            userPick = sc.nextLine();
            userPick = userPick.toLowerCase();

            if(userPick.equals("dam") || userPick.equals("la") || userPick.equals("keo")) {
                break;
            } else {
                System.out.println("Vui long nhap dam, la hoac keo.");
            }
        }
        return userPick;
    }
    String getResult(String computePick,String userPick) {
        if(userPick.equals(computePick)) {
            return "hoa";
        } else if (userPick.equals("dam") && computePick.equals("keo")) {
            return "thang";
        } else if (userPick.equals("keo") && computePick.equals("la")) {
            return "thang";
        } else if (userPick.equals("la") && computePick.equals("dam")) {
            return "thang";
        } else {
            return "thua";
        }
    }
}

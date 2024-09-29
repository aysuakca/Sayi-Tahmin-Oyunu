import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right<5){
            System.out.println("Lutfen Tahmininizi Giriniz :");
            selected = input.nextInt();

            if(selected < 0 || selected > 99){
                System.out.println("Lutfen 0-100 arasinda bir deger giriniz!");
                if(!isWrong){
                    isWrong = true;
                    System.out.println("Bir daha hatali girinisinizde can hakkinizdan dusulecektir!");
                }else{
                    right++;
                    System.out.println("Cok fazla hatali giris yaptiniz. Kalan hak : " + (5-right));
                }
                continue;
            }
            if(selected == number){
                System.out.println("Tebrikler Dogru Tahmin! Tahmin ettiginiz sayi :" +number);
                System.out.println(number);
                isWin= true;
                break;
            } else {
                System.out.println("Yanlis tahmin!");
                if(selected > number){
                    System.out.println(selected + "sayisi, gizli sayidan buyuktur.");
                } else{
                    System.out.println(selected + "sayisi, gizli sayidan kucuktur.");
                }
                wrong[right++] = selected;
                System.out.println("Kalan Hak : " + (5-right));
            }
        }
        if (!isWin){
            System.out.println("Kaybettiniz..");
            if(!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
                System.out.println("Dogru Cevap :" + number);
            }
        }
    }
}
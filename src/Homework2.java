import java.util.Scanner;

public class Homework2 {

    static int x, y;

    static int[] inputX = new int[10];
    static int[] inputY = new int[10];

    static int index;

    static int tmpX, tmpY;

    static double[] dX = new double[10];
    static double[] dY = new double[10];

    static double[] leng = new double[10];

    public static void main(String[] args) {
        MyCoordinate();
        RanCoordinate();
        CalCoordinate();
        MinCoordinate();
    }

    public static void MyCoordinate() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("나의 좌표 값 x:");
        x = sc.nextInt();

        System.out.printf("나의 좌표 값 y:");
        y = sc.nextInt();

        System.out.println("나의 좌표:(" + x + "," + y + ")");

    }

    public static void RanCoordinate() {
        Scanner sc = new Scanner(System.in);

        for (index = 0; index < 10; index++) {
            if (index != 0) {
                Compare();
            } else if (index == 0) {
                System.out.printf("1번째 좌표 x값을 입력해주세요.");
                inputX[0] = sc.nextInt();

                System.out.printf("1번째 좌표 y값을 입력해주세요.");
                inputY[0] = sc.nextInt();

                System.out.printf("1번째 좌표:(" + inputX[0] + ", " + inputY[0] + ")\n");
            }
        }
        System.out.printf("입력된 좌표:");
        for (int i = 0; i < 9; i++) {
            System.out.printf("("+inputX[i]+", "+inputY[i]+")"+", ");
        }
        System.out.printf("("+inputX[9]+", "+inputY[9]+") 일 때\n");
    }

    public static void Compare(){
        Scanner sc = new Scanner(System.in);

        System.out.printf((index+1)+"번째 좌표 x값을 입력해주세요:");
        tmpX = sc.nextInt();

        System.out.printf((index+1)+"번째 좌표 y값을 입력해주세요:");
        tmpY = sc.nextInt();

        for (int i = index; i >=0 ; i--) {
            if((tmpX==inputX[i])&&(tmpY==inputY[i])){
                System.out.println("중복값 오류!");
                index--;
                break;
            }

            inputX[index]=tmpX;
            inputY[index]=tmpY;
        }

        System.out.printf((index+1)+"번째 좌표:("+inputX[index]+", "+inputY[index]+")\n");
    }

    public static void CalCoordinate(){
        for (int i = 0; i < 10; i++) {
            dX[i]=(double)(x-inputX[i]);
            dY[i]=(double)(y-inputY[i]);

            leng[i]=Math.sqrt(dX[i]*dX[i])+(dY[i]*dY[i]);
        }
    }

    public static void MinCoordinate(){
        double min = leng[0];

        int minIndex = 0;

        for (int i = 0; i < leng.length; i++) {
            if(min>leng[i]){
                min=leng[i];
                minIndex=i;
            }
        }
        System.out.printf("제일 가까운 좌표값은: ("+inputX[minIndex]+", "+inputY[minIndex]+")입니다.");
    }
}

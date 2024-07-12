import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        System.out.println("uwu");
//        System.out.println("Hello :D");
//
//        System.out.println(sum_cubes(5));
//
//    }
//
//    public static int sum_cubes(int num) {
//
//        int c = 0;
//        for (int i = 0; i <= num; i++) {
//            int a = i * i * i;
//            c = a + c;
//        }
//        return c;
//
//    }
//
//    public static int average(int[] visitors) {
//
//        //eliminate smaller and bigger values
//        for (int i = 0; i <= visitors.length; i++) {
//
//
//        }
//        //find average do another loop?
//        int average = 0;
//        int o£;
//        return average;
//    }
//
//    public static boolean logical_and_(boolean a, boolean b) {
//        return a && b;
//
//        String s="AMMMDDCCCMD";
//        System.out.println(s.length());


//        StringBuilder sb =  new StringBuilder();

//
//        Random rand = new Random();
//        int die1;
//        int die2;
//        int tryNum=1;
//        do {
//            System.out.println("*********"+tryNum+"*********");
//             die1 = rand.nextInt(1,7);
//             die2 = rand.nextInt(1,7);
//            System.out.println("Die1 rolled as: "+die1);
//            System.out.println("Die2 rolled as: "+die2);
//            tryNum++;
//        }
//        while(die1!=die2);
//        System.out.println("Done!");
//
//        for(int i=0;i<11;i++){
//            System.out.println(i);
//        }


        //develop a function that takes a string of length2 and keeps increasing it until it's 9


        int[] numbers={1,4,17,7,25,3,100};
        int average=0;
        for (int number:numbers){
            average=number+average;
        }
        average=average/numbers.length;

        System.out.println("average= "+average);
        for (int number:numbers){
            if (number>average){
                System.out.println(number);
            }
        }
        int[] num1={1,21,3};
        int[] num2={1,2,3};
        boolean isEqual=true;
        for (int i = 0; i < num1.length; i++) {
            if (num1[i]!=num2[i]){
                isEqual=false;
            }
        }
        System.out.println(isEqual);


        int[] nums ={1,3,6,7,4};
        ArrayList revNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            revNums.add(nums[i]);
        }
        revNums.set(0,nums[nums.length-1]);
        revNums.set(nums.length-1,nums[0]);
        System.out.println(revNums);

                 // column   0,1,2,3    //row
        int[][] Numbers =  {{1,2,3,4},  //0
                            {5,6,7,8}}; //1


                              //[row][column]
        
        System.out.println(Numbers[1][3]);


//        for (int i=0;i<students.length;i++){
//            for (int j=0;j<students[i].length;j++){
//                System.out.println(students[i][j]);
//            }  }







    }





}


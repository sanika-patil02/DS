import java.util.*;

public class BullyAlgorithm {
    public int election_process(int isActive[],int num_pr,int initiator){
        int higher_process=initiator;

        for(int i=initiator;i<=num_pr;i++){
            if(isActive[i]==1){
                for(int j=i+1;j<=num_pr;j++){
                    if(isActive[j]==1){
                        System.out.println("Process "+ i +" sends election message to process "+j);
                    }
                }
                System.out.println();

                for(int j=i+1;j<=num_pr;j++){
                    if(isActive[j]==1){
                        System.out.println("Process "+ j +" sends ok message to process "+i);
                        if(higher_process<j){
                            higher_process=j;
                        }
                    }

                    // if(isActive[j]==1 && higher_process<j){
                    //     higher_process=j;
                    // }
                }
                System.out.println();
        }
    }
    return higher_process;
}

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int num_pr=sc.nextInt();

        int isActive[]=new int[num_pr+1];

        for(int i=1;i<=num_pr;i++){
            isActive[i]=1;
        }

        int old_cor=num_pr;
        isActive[old_cor]=0;

        System.out.println("Enter the process that initiates the election process:");
        int initiator = sc.nextInt();
        System.out.println("The process that failed is : "+old_cor);
        System.out.println("Enter the process that fails (other than the leader process),if none then enter 0: ");        
        int failed_pr=sc.nextInt();
        isActive[failed_pr]=0;

        BullyAlgorithm obj =new BullyAlgorithm();
        int new_cor = obj.election_process(isActive,num_pr,initiator);

        System.out.println("Finally process "+new_cor+" becomes the new leader.");
        for(int i=1;i<new_cor;i++){
            if(isActive[i]==1){
                System.out.println("Process "+new_cor+" sends coordinator message to process "+i);
            }
        }
    
    }
}

// Output-Example 1
// Enter number of processes:
// 5
// Enter the process that initiates the election process:
// 2
// The process that failed is : 5
// Enter the process that fails (other than the leader process),if none then enter 0: 
// 0
// Process 2 sends election message to process 3
// Process 2 sends election message to process 4

// Process 3 sends ok message to process 2
// Process 4 sends ok message to process 2

// Process 3 sends election message to process 4

// Process 4 sends ok message to process 3



// Finally process 4 becomes the new leader.
// Process 4 sends coordinator message to process 1
// Process 4 sends coordinator message to process 2
// Process 4 sends coordinator message to process 3

// Example 2
// Enter number of processes:
// 5
// Enter the process that initiates the election process:
// 2
// The process that failed is : 5
// Enter the process that fails (other than the leader process),if none then enter 0: 
// 4
// Process 2 sends election message to process 3

// Process 3 sends ok message to process 2



// Finally process 3 becomes the new leader.
// Process 3 sends coordinator message to process 1
// Process 3 sends coordinator message to process 2


// OR

// import java.util.*;

// public class BullyAlgorithm {
//     static int num_pr;
//     static int old_cor;
//     static int new_cor;
//     static int initiator;
//     static int failed_pr;
//     static int isActive[];
 
//     public static int election_process(){
//         int higher_process=initiator;

//         for(int i=initiator;i<=num_pr;i++){
//             if(isActive[i]==1){
//                 for(int j=i+1;j<=num_pr;j++){
//                     if(isActive[j]==1){
//                         System.out.println("Process "+ i +" sends election message to process "+j);
//                     }
//                 }
//                 System.out.println();

//                 for(int j=i+1;j<=num_pr;j++){
//                     if(isActive[j]==1){
//                         System.out.println("Process "+ j +" sends ok message to process "+i);
//                     }

//                     if(isActive[j]==1 && higher_process<j){
//                         higher_process=j;
//                     }
//                 }
//                 System.out.println();
//         }
//     }
//     return higher_process;
// }

//     public static void main(String[] args) {
//         Scanner sc =new Scanner(System.in);
//         System.out.println("Enter number of processes:");
//         num_pr=sc.nextInt();

//         isActive=new int[num_pr+1];

//         for(int i=1;i<=num_pr;i++){
//             isActive[i]=1;
//         }

//         old_cor=num_pr;
//         isActive[old_cor]=0;

//         System.out.println("Enter the process that initiates the election process:");
//         initiator = sc.nextInt();
//         System.out.println("The process that failed is : "+old_cor);
//         System.out.println("Enter the process that fails (other than the leader process),if none then enter 0: ");        
//         failed_pr=sc.nextInt();
//         isActive[failed_pr]=0;

//         new_cor = election_process();

//         System.out.println("Finally process "+new_cor+" becomes the new leader.");
//         for(int i=1;i<new_cor;i++){
//             if(isActive[i]==1){
//                 System.out.println("Process "+new_cor+" sends coordinator message to process "+i);
//             }
//         }
    
//     }
// }
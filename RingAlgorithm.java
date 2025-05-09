import java.util.*;

public class RingAlgorithm {
    public int election_process(int isActive[],int num_pr,int initiator){
        System.out.println("Process "+initiator+" initiates election process.");
        int arr[]=new int[num_pr];
        int index=0;
        int i=initiator;
        int receiver=(i%num_pr)+1;

        while(index<num_pr){
            if(isActive[i]==1){
                while(isActive[receiver]==0){
                    receiver=(receiver%num_pr)+1;
                }
                System.out.println(i+" sends election message to process "+receiver);
                arr[index]=i;
                Print_arr(arr,index);
            }
            i=(i%num_pr)+1;
            receiver=(i%num_pr)+1;
            index++;
        }

        int new_cor=0;
        for(int j=0;j<num_pr;j++){
            if(arr[j]>new_cor){
                new_cor=arr[j];
            }
        }
        return new_cor;
    }

    public void Print_arr(int arr[],int size){
        System.out.print("[ ");
        for(int i=0;i<=size;i++){
            if(arr[i]==0)
                continue;
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
        System.out.println();
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

        RingAlgorithm obj =new RingAlgorithm();
        int new_cor = obj.election_process(isActive,num_pr,initiator);

        System.out.println("Finally process "+new_cor+" becomes the new leader.");
        for(int i=1;i<new_cor;i++){
            if(isActive[i]==1){
                System.out.println("Process "+new_cor+" sends coordinator message to process "+i);
            }
        }
    
    }
}


// OUTPUT-1
// Enter number of processes:
// 5
// Enter the process that initiates the election process:
// 2
// The process that failed is : 5
// Enter the process that fails (other than the leader process),if none then enter 0: 
// 0
// Process 2 initiates election process.
// 2 sends election message to process 3
// [ 2 ]
// 3 sends election message to process 4
// [ 2 3 ]
// 4 sends election message to process 1
// [ 2 3 4 ]
// 1 sends election message to process 2
// [ 2 3 4 1 ]
// Finally process 4 becomes the new leader.
// Process 4 sends coordinator message to process 1
// Process 4 sends coordinator message to process 2
// Process 4 sends coordinator message to process 3

// OUTPUT-2
// Enter number of processes:
// 5
// Enter the process that initiates the election process:
// 2
// The process that failed is : 5
// Enter the process that fails (other than the leader process),if none then enter 0:
// 4
// Process 2 initiates election process.
// 2 sends election message to process 3
// [ 2 ]
// 3 sends election message to process 1
// [ 2 3 ]
// 1 sends election message to process 2
// [ 2 3 1 ]
// Finally process 3 becomes the new leader.
// Process 3 sends coordinator message to process 1
// Process 3 sends coordinator message to process 2
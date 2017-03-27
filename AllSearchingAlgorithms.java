import java.util.*;


/* All searching algorithms are here */


class AllSearchingAlgorithms
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr={1,3,4,6,8,9,10};
		int a=ternarySearch(arr,0,arr.length,1);
		System.out.println(a);
	}
		/*Here comes beloved Binary Search,all below algorithms work on previously sorted arrays */
    
	public static int bin_search(int A[], int left, int right, int k)
	{
	if(right==left)return -1;                                    //right is arr.length;
	int mid=left+(right-left)/2;
	if(k>A[mid])return bin_search(A,mid+1,right,k);
	else if(k<A[mid])return bin_search(A,left,mid,k);
	else return mid;
	}
       /*Here is our Jump Search*/
	public static int jump_search(int[] arr,int k){
		int pivot=0;
		while(pivot<arr.length && k>=arr[pivot]){
			if(arr[pivot]==k)return pivot;
			pivot+=4;
		}
		if(pivot>=arr.length){
			pivot=pivot-3;
			for(int i=pivot;i<arr.length;i++){
				if(k==arr[pivot])return pivot;
			}
			return -1;
		}
		for(int i=pivot-3;i<=pivot;i++){
			if(k==arr[pivot])return pivot;
		}
		return -1;
	}
      /*Exponential Search is here*/
  
	public static int expoSearch(int[] arr,int k){
		int high=1;
		while(high<arr.length && k>arr[high]){
			high*=2;
		}
		if(high<arr.length)return bin_search(arr,high/2,high,k);
		else return bin_search(arr,high/2,arr.length,k);
	}
      /*ternarySearch comes to screen*/
  
	public static int ternarySearch(int[] arr,int left,int right,int key){
		if(right<=left){
			return -1;
		}
		int onethird=left+(right-left)/3;
		int twothird=left+2*(right-left)/3;
		if(key<arr[onethird])return ternarySearch(arr,left,onethird,key);
		if(key>arr[onethird] && key<arr[twothird])return ternarySearch(arr,onethird+1,twothird,key);
		if(key>arr[twothird])return ternarySearch(arr,twothird+1,right,key);
		else if(key==arr[onethird])return onethird;
		else return twothird;
	} 
}

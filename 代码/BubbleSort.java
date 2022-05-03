public class BubbleSort{
	public static void main(String[] args){
		int[] arr = {24,69,80,57,13};
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = arr.length-1; j > i; j--){
				if(arr[j-1] > arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("=========array after sort==========");
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
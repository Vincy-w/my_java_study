public class TwoDimenArray02{
	public static void main(String[] args){
		/*
		动态创建以下二维数组：
		i=0: 1
		i=1: 2 2
		i=2: 3 3 3
		*/
		int[][] arr = new int[3][];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new int[i+1];
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = i+1;
			}
		}
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
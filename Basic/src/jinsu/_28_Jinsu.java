package jinsu;

public class _28_Jinsu {

	public static void main(String[] args) {

		int inputNum=25;
		int bin[] = new int[100];
		   
		int i=0;
		int mok=inputNum;
		
		while (mok>0) {
			bin[i]=mok%2;
			mok /=2;
			i++;
		}
		i--;
		for(;i>=0;i--) {
			System.out.println(bin[i]);
		}
	}

}

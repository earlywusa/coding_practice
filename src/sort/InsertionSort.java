package sort;

public class InsertionSort {

	public static void main(String[] args) {
		/*
		 *  .1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.1 = INTEGER: 10
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.2 = INTEGER: 10
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.3 = INTEGER: 11
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.4 = INTEGER: 11
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.5 = INTEGER: 12
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.6 = INTEGER: 12
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.7 = INTEGER: 13
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.8 = INTEGER: 13
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.9 = INTEGER: 14
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.10 = INTEGER: 14
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.11 = INTEGER: 15
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.12 = INTEGER: 15
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.13 = INTEGER: 16
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.14 = INTEGER: 16
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.15 = INTEGER: 17
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.16 = INTEGER: 17
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.17 = INTEGER: 18
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.18 = INTEGER: 18
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.19 = INTEGER: 19
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.20 = INTEGER: 19
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.21 = INTEGER: 3
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.22 = INTEGER: 20
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.23 = INTEGER: 20
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.101 = INTEGER: 2
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.103 = INTEGER: 4
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.104 = INTEGER: 5
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.105 = INTEGER: 6
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.107 = INTEGER: 7
			.1.3.6.1.4.1.17718.3.2.2.2.3.1.1.3.108 = INTEGER: 8

		 * 
		 */
		// TODO Auto-generated method stub
		int[][] input = new int[29][2];
		input[0][0] = 10; input[0][1] = 1;
		input[1][0] = 10; input[1][1] = 2;
		
		input[2][0] = 11; input[2][1] = 3;
		input[3][0] = 11; input[3][1] = 4;
		
		input[4][0] = 12; input[4][1] = 5;
		input[5][0] = 12; input[5][1] = 6;
		
		input[6][0] = 13; input[6][1] = 7;
		input[7][0] = 13; input[7][1] = 8;
		
		input[8][0] = 14; input[8][1] = 9;
		input[9][0] = 14; input[9][1] = 10;
		
		input[10][0] = 15; input[10][1] = 11;
		input[11][0] = 15; input[11][1] = 12;
		
		input[12][0] = 16; input[12][1] = 13;
		input[13][0] = 16; input[13][1] = 14;
		
		input[14][0] = 17; input[14][1] = 15;
		input[15][0] = 17; input[15][1] = 16;
		
		input[16][0] = 18; input[16][1] = 17;
		input[17][0] = 18; input[17][1] = 18;
		
		input[18][0] = 19; input[18][1] = 19;
		input[19][0] = 19; input[19][1] = 20;
		
		input[20][0] = 3; input[20][1] = 21;
		
		input[21][0] = 20; input[21][1] = 22;
		input[22][0] = 20; input[22][1] = 23;

		input[23][0] = 2; input[23][1] = 101;
		input[24][0] = 4; input[24][1] = 103;
		
		input[25][0] = 5; input[25][1] = 104;
		input[26][0] = 6; input[26][1] = 105;
		
		input[27][0] = 7; input[27][1] = 107;
		input[28][0] = 8; input[28][1] = 108;
		InsertionSort is = new InsertionSort();
		for(int i = 0; i<input.length; i++){
			System.out.println("insert: cellID: " + input[i][0] + " tei: " + input[i][1]);
			is.insert(input[i][0], input[i][1]);
			is.print_celldata();
			System.out.println();
			System.out.println();
		}
		
		//is.print_celldata();
		
		
	}
	int MAX_BTS_SUPPORTED = 256;
	int[][] celldata; 
	int totalcell = 0;
	
	public InsertionSort(){
		celldata = new int[MAX_BTS_SUPPORTED][3]; 

		celldata[0][0] = 1; celldata[0][1] = -1; celldata[0][2] = -1;

	    for(int i=1; i<MAX_BTS_SUPPORTED; i++)
	    {
	        celldata[i][0] = -1; celldata[i][1] = -1; celldata[i][2] = -1;
	    }
	    totalcell = 0;
	}
	
	public void insert(int cellid, int tei){
		int i = 1;
		for(i =1 ; i<= totalcell; i++){
			if (celldata[i][0] == cellid){
				if (celldata[i][1] == tei || celldata[i][2] == tei){
	                System.out.println("ERROR: Reinsert the same tei "+ tei);
					System.out.println("Reinsert the same tei " + tei );
					//fix later
	                break;
	            }
	            System.out.println("Existing cell\n");
	            if (celldata[i][1] == -1)
	            {
	                celldata[i][1] = tei;
	            } else if (celldata[i][1] > tei)
	            {
	                celldata[i][2] = celldata[i][1];
	                celldata[i][1] = tei;
	            } else
	            {
	                celldata[i][2] = tei;
	            }
	            break;
	        } 
			else if (celldata[i][0]  > cellid)
	        {
	        	System.out.println("Insert into location "+i);
	            /* insert into this location */
	            int j;
	            if (totalcell == MAX_BTS_SUPPORTED)
	            {
	            	System.out.println("ERROR: Hit maximum number of cell");
	            	System.out.println("Hit maximum number of cell");
	                break;
	            }
	            for(j=totalcell; j>=i; j--)
	            {
	                celldata[j+1][0] = celldata[j][0];
	                celldata[j+1][1] = celldata[j][1];
	                celldata[j+1][2] = celldata[j][2];
	            }
	            celldata[i][0] = cellid;
	            celldata[i][1] = tei;
	            celldata[i][2] = -1;
	            totalcell++;
	            break;
	        }
			

		}
		if (totalcell+1 == i)
	    {
	        /* insert into end */
	        celldata[i][0] = cellid;
	        celldata[i][1] = tei;
	        celldata[i][2] = -1;
	        totalcell++;
	    }
	}
	public void print_celldata()
	{
	    int i;
	    System.out.println("Print celldata: " + totalcell);
	    for(i=0; i<30; i++)
	    {
//	        if(celldata[i][0] != -1 || celldata[i][1] != -1 || celldata[i][2] != -1 )
//	        {
	        	System.out.println( i + ": "+ celldata[i][0] + " " +  celldata[i][1] + " " +  celldata[i][2]);
				//do_log("%d: %d %d %d\n", i, celldata[i][0], celldata[i][1], celldata[i][2]);
				//fix later
//	        }
	    }
	}
}

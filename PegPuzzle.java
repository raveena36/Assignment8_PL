public class PegPuzzle {
/*  
	  *        
         * *   
        * * *  
       * * * * 
      * * * * *
	 
	    0
           1 2 
          3 4 5
         6 7 8 9 
      10 11 12 13 14      */
	
private int[][] moves = { 
			{0, 1, 3}, 
			{0, 2, 5},
			{1, 3, 6}, 
			{1, 4, 8}, 
			{2, 4, 7},
			{2, 5, 9}, 
			{3, 6, 10}, 
			{3, 7, 12},
			{4, 7, 11}, 
			{4, 8, 13}, 
			{5, 8, 12},
			{5, 9, 14}, 
			{3, 4, 5}, 
			{6, 7, 8},
			{7, 8, 9}, 
			{10, 11, 12}, 
			{11, 12, 13},
			{12, 13, 14}
		};

static int[][] step = {
			{3, 1, 0}, 
			{5, 2, 0},
			{6, 3, 1}, 
			{8, 4, 1}, 
			{7, 4, 2},
			{9, 5, 2}, 
			{10, 6, 3}, 
			{12, 7, 3},
			{11, 7, 4}, 
			{13, 8, 4}, 
			{12, 8, 5},
			{14, 9, 5}, 
			{5, 4, 3}, 
			{8, 7, 6},
			{9, 8, 7}, 
			{12, 11, 10}, 
			{13, 12, 11},
			{14, 13, 12}
		};

public static int[] init(int i){
			int[] pegholes = new int[15];
			pegholes[i] = 0;
			return(pegholes);
		}

public static int[] move(int[] i, int from, int over, int to)
		{
			int k =14 ;
			int[] j = i;
			int[] temp = new int[15];

			if(j[from] == 1 && j[over] == 1 && j[to] == 0)
			{
				for(int iter = 0; iter < j.length; iter++)
				{
					temp[iter] = j[iter];
				}
				temp[from] = 0;
				temp[over] = 0;
				temp[to] = 0;
				return(temp);
			}
			return(null);
		}
	
public static int[][] solve(int[] kj)
		{
			int k = kj[0];
			int j = kj[1];
			int[][] nextSoln = {{}, {}};

			if(k < 2)
			{
				nextSoln[1] = kj;
			}
			else
			{
				for(int iter = 0; iter < step.length; iter++)
				{
					int[] kc = move(kj, step[iter][0], step[iter][1], step[iter][2]);
					if(kc != null)
					{
						for(int subIter = 0; subIter < solve(kc).length; subIter++)
						{
							int[] ms = solve(kc)[0];
							int[] newkj = solve(kc)[1];
							nextSoln[0] = ms;
							nextSoln[1] = newkj;
							return(nextSoln);
						}
					}
				}
			}

			return(nextSoln);
		}
public static int[][] puzzle(int i)
		{
			int[] kd = init(i);

			int[][] tempSoln = solve(init(i+1));
			int[] newkd = tempSoln[0];
			int[] ms = tempSoln[1];
			int[] movesList = {};

			for(int iter = 0; iter < ms.length; iter++)
			{
				int m = ms[iter];

				int tempMList[] = new int[movesList.length + 1];

				for(int subIter = 0; subIter < movesList.length; subIter++)
				{
					tempMList[subIter] = movesList[subIter];
				}

				tempMList[tempMList.length] = m;

				movesList = tempMList;
			}

			int[][] next = {kd, movesList, newkd};
			return(next);
		}

public static void show(int[] kd)
		{
			int k = kd[0];
			int d = kd[1];

			int[][] lines = {{4,0,0}, {3,1,2}, {2,3,5}, {1,6,9}, {0,10,14}};

			for(int iter = 0; iter < lines.length; iter++)
			{
				int[] l = lines[iter];
				int t = l[0];
				int a = l[1];
				int b = l[2];
				for(int tab = 0; tab < t; tab++)
				{
					System.out.print(" ");
				}
				for(int subIter = a; subIter <= b; subIter++)
				{
					char c = ' ';
					if(kd[subIter] == 0)
					{
						c = '.';
					}
					else
					{
						c = 'x';
					}
					System.out.print(c);
				}
				System.out.print(' ');
			}
			System.out.print(' ');
		}

public static void replay(int[] ms, int[] kd)
		{
			for(int iter = 0; iter < ms.length; iter++)
			{
				int m = ms[iter];

				show(kd);
				int k = kd[0];
				int d = kd[1];
				int f = ms[0];
				int o = ms[1];
				int t = ms[2];
				int[] def = new int[3];
				def[f] = 0;
				def[o] = 0;
				def[t] = 1;
				kd[0] = k - 1;
				kd[1] = d;
			}
			show(kd);
		}

public static void main(String[] args)
		{	PegPuzzle puzzle = new PegPuzzle();
			
			for(int i = 0; i <= 5; i++)
			{
				System.out.println("=== " + i + " ===");
				System.out.println("    *    ");
				System.out.println("   * *   ");
				System.out.println("  * * *  ");
				System.out.println(" * * * * ");
				System.out.println("* * * * *");
			
			}

		}
}



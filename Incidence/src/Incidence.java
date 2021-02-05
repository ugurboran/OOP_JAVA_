
public class Incidence {
	public void printPath(int[][] incidence, int v0, int v2){
		int v;
		int e;
		for(v=0;v<incidence.length;v++){
			if(v==2){
				continue;
			}

			for(e=0;e<incidence[v].length;e++){
				if(incidence[0][e]==1){

					if(incidence[v][e]==1){

						System.out.print("v"+v);

						if(incidence[3][e]==1){
							if(incidence[v][e]==1){
								System.out.print("v"+v);

								if(incidence[4][e]==1){
									if(incidence[v][e]==1){	
										System.out.print("v"+v);

										if(incidence[1][e]==1){
											if(incidence[v][e]==1){
												System.out.print("v"+v);
											}
										}
									}
								}
							}
						}
					}
				}


				
			}
		}
		System.out.print("v2");
	}

	public static void main(String[] args) {
		Incidence mn = new Incidence();
		int[][] m = {
				{1, 1, 0, 0, 0, 0},
				{0, 0, 1, 1, 0, 1},
				{0, 0, 0, 0, 1, 1},
				{1, 0, 1, 0, 0, 0},
				{0, 1, 0, 1, 1, 0}
		};
		mn.printPath(m, 0, 2);
	}
}

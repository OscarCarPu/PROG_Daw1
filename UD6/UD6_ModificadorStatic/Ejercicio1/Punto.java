package Ejercicio1;
class Punto {
	int x,y;
	static int cnt_punto=0;
	Punto (int x,int y){
		this.x=x;
		this.y=y;
		cnt_punto++;
	}
}

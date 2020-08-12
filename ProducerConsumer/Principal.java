public class Principal {

	public static void main(String[] args) {
		Fila f = new Fila();
		Produtor p = new Produtor(5, f);
		Produtor p2 = new Produtor(5, f);
		Produtor p3 = new Produtor(5, f);
		Consumidor c = new Consumidor(5, f);
		Consumidor c2 = new Consumidor(5, f);
		c.setName("c1");
		c2.setName("c2");
		p.setName("p1");
		p2.setName("p2");
		p3.setName("p3");
		p.start();
		p2.start();
		p3.start();
		c.start();
		c2.start(); 
	}

}

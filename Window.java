import java.awt.GridLayout;

import java.awt.event.KeyListener;

import java.util.ArrayList;



import javax.swing.JFrame;





class Window extends JFrame{

	private static final long serialVersionUID = -2542001418764869760L;

	public static ArrayList<ArrayList<DataOfSquare>> Grid;

	public static int width = 20;

	public static int height = 20;

	public Window(){

		

		

		// Cria a lista de matrizes que conter� os t�picos

		Grid = new ArrayList<ArrayList<DataOfSquare>>();

		ArrayList<DataOfSquare> data;

		

		// Cria Threads e seus dados e os adiciona ao arrayList

		for(int i=0;i<width;i++){

			data= new ArrayList<DataOfSquare>();

			for(int j=0;j<height;j++){

				DataOfSquare c = new DataOfSquare(2);

				data.add(c);

			}

			Grid.add(data);

		}

		

		// Configurando o layout do painel

		getContentPane().setLayout(new GridLayout(20,20,0,0));

		

		// Iniciar e pausar todos os t�picos e, em seguida, adicionar cada quadrado de cada t�pico ao painel

		for(int i=0;i<width;i++){

			for(int j=0;j<height;j++){

				getContentPane().add(Grid.get(i).get(j).square);

			}

		}

		

		// posi��o inicial da cobra

		Tuple position = new Tuple(10,10);

		// passando este valor para o controlador

		ThreadsController c = new ThreadsController(position);

		// Vamos come�ar o jogo agora ..

		c.start();



		// Vincula a janela ao ouvinte de teclado.

		this.addKeyListener((KeyListener) new KeyboardListener());



		// Para fazer: lidar com multijogadores .. O acima funciona, teste e veja o que acontece

		
		//Posi��o da tupla2 = nova Tupla (13,13);


		//ControlleurThreads c2 = new ControlleurThreads(position2);

		//c2.start();

		

	}

}
package pokemon.pok_parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	public static void main(String[] args) {
		try {
			File file = new File("deck1.ptcgo.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBufferDeck1 = new StringBuffer();
			String line;
			String pokemon[][]=new String[60][4];
			String energy[][]=new String[60][4];
			String trainer[][]=new String[60][4];

			int pok_counter=0,ene_counter=0,tra_counter=0;

			int pok_flag=0,tra_flag=0,ene_flag=0;

			while ((line = bufferedReader.readLine()) != null) {
				// Store

				if(line.contains("Deck List Generated"))
				{
					pok_flag=0;tra_flag=0;ene_flag=0;
				}
				if(line.contains("##Pok"))
				{
					pok_flag=1;
					continue;
				}
				if(pok_flag==1)
				{
					if(line.contains("*"))
					{
						String temp[]=line.split(" ");
						int i=temp.length;
						pokemon[pok_counter][0]=temp[1]; // QTY
						pokemon[pok_counter][1]=temp[2]; // NAME
						pokemon[pok_counter][2]=temp[temp.length-2]; // STAGE
						pokemon[pok_counter][3]=temp[temp.length-1];//HP
						pok_counter++;
					}
				}
				stringBufferDeck1.append(line);
				stringBufferDeck1.append("\n");

				if(line.contains("##Trainer"))
				{
					pok_flag=0;
					tra_flag=1;
				}
				if(tra_flag==1)
				{
					if(line.contains("*"))
					{
						String temp[]=line.split(" ");
						int i=temp.length;
						trainer[tra_counter][0]=temp[1]; // QTY
						trainer[tra_counter][1]=temp[2]; // NAME
						trainer[tra_counter][2]=temp[temp.length-2]; // NAME
						trainer[tra_counter][3]=temp[temp.length-1];//HP
						tra_counter++;
					}
				}

				if(line.contains("##Energy"))
				{
					tra_flag=0;
					ene_flag=1;
				}
				if(ene_flag==1)
				{
					if(line.contains("*"))
					{
						String temp[]=line.split(" ");
						int i=temp.length;
						energy[ene_counter][0]=temp[1]; // QTY
						energy[ene_counter][1]=temp[2]; // NAME
						energy[ene_counter][2]=temp[temp.length-2]; // NAME
						energy[ene_counter][3]=temp[temp.length-1];//HP
						ene_counter++;
					}
				}





			}
			fileReader.close();

			System.out.println("Pokemons \n");
			for(int i=0;i<pok_counter;i++)
				{
					System.out.println(i+") "+pokemon[i][1]);
				}
			System.out.println("\nTrainer \n");
			for(int i=0;i<tra_counter;i++)
				{
					System.out.println(i+") "+trainer[i][1]);
				}
			System.out.println("\nEnergy \n");
			for(int i=0;i<ene_counter;i++)
				{
					System.out.println(i+") "+energy[i][1]);
				}
			//System.out.println("Contents of file:");
			//System.out.println(stringBufferDeck1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}


		// try {
		// 	File file = new File("deck2.ptcgo.txt");
		// 	FileReader fileReader = new FileReader(file);
		// 	BufferedReader bufferedReader = new BufferedReader(fileReader);
		// 	StringBuffer stringBufferDeck2 = new StringBuffer();
		// 	String line;
		// 	while ((line = bufferedReader.readLine()) != null) {
		// 		// Store


		// 		stringBufferDeck2.append(line);
		// 		stringBufferDeck2.append("\n");
		// 	}
		// 	fileReader.close();
		// 	System.out.println("Contents of file:");
		// 	System.out.println(stringBufferDeck2.toString());
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
	}
}

package pokemon.CoreClasses;

public class Card {

	public static final int TYPE_POKEMON = 0;
	public static final int TYPE_ENERGY = 1;
	public static final int TYPE_TRAINER = 2;

	int m_type;

	public Card(int type) {
		m_type = type;
	}

}

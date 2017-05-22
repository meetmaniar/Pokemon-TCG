package pokemon.CoreClasses;

public class CardEnergy extends Card{
	public static final int ENERGY_WATER 	= 0;
	public static final int ENERGY_LIGHTING = 1;
	public static final int ENERGY_PSYCHIC 	= 2;
	public static final int ENERGY_FIGHTING = 3;
	public static final int ENERGY_COLORLESS = 4;

	public int 	m_type;
	
	
	
	public CardEnergy()
	{
		super(1);
	}
	
	public CardEnergy(int type) {
		super(type);
		m_type = type;
	}

	public void initEnergy(int type)
	{
		m_type=type;
	}
	
	
}
